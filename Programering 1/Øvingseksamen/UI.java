import java.util.ArrayList;
import java.util.Scanner;

/**
 * Text based user interface for the property register.
 *
 * <p>This class is responsible for all interaction with the user: it presents a menu,
 * reads input from the user and prints the results. All storage and searching of
 * properties is delegated to {@link LotRegister}, so that this class only handles
 * input and output.</p>
 *
 * @author MatheoHammer
 * @version 1.0
 */
public class UI {
    /** Menu choice for adding a new property. */
    private static final int ADD_PROPERTY = 1;
    /** Menu choice for listing all properties. */
    private static final int LIST_ALL_PROPERTIES = 2;
    /** Menu choice for searching for a property by its ID. */
    private static final int FIND_PROPERTY = 3;
    /** Menu choice for calculating the average area of all properties. */
    private static final int CALCULATE_AVERAGE_AREA = 4;
    /** Menu choice for removing a property. */
    private static final int REMOVE_LOT = 5;
    /** Menu choice for finding all properties with a given lot number. */
    private static final int FIND_BY_LOT_NUMBER = 6;
    /** Menu choice for changing the owner of a property. */
    private static final int CHANGE_OWNER = 7;
    /** Menu choice for changing the name of a property. */
    private static final int CHANGE_NAME = 8;
    /** Menu choice for quitting the application. */
    private static final int EXIT = 9;

    /** The register holding all properties. */
    private LotRegister lotRegister = new LotRegister();

    /**
     * Fills the register with the five properties in Gloppen
     * given as test data in the task description.
     */
    private void fillWithTestData() {
        lotRegister.addLot(new Lot(1445, "Gloppen", 77, 631, "", 1017.6, "Jens Olsen"));
        lotRegister.addLot(new Lot(1445, "Gloppen", 77, 131, "Syningom", 661.3, "Nicolay Madsen"));
        lotRegister.addLot(new Lot(1445, "Gloppen", 75, 19, "Fugletun", 650.6, "Evilyn Jensen"));
        lotRegister.addLot(new Lot(1445, "Gloppen", 74, 188, "", 1457.2, "Karl Ove Bråten"));
        lotRegister.addLot(new Lot(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Elsa Indregård"));
    }

    /**
     * Presents the menu for the user, and awaits input from the user. The menu
     * choice selected by the user is being returned.
     *
     * @param sc the scanner to read the user's input from
     * @return the menu choice by the user as a positive number starting from 1.
     *         If 0 is returned, the user has entered a wrong value
     */
    private int showMenu(Scanner sc)
    {
        int menuChoice = 0;
        System.out.println("\n***** Property Register Application v0.1 *****\n");
        System.out.println("1. Add property");
        System.out.println("2. List all properties");
        System.out.println("3. Search property");
        System.out.println("4. Calculate average area");
        System.out.println("5. Remove property");
        System.out.println("6. Find all properties with a lot number");
        System.out.println("7. Change owner of a property");
        System.out.println("8. Change name of a property");
        System.out.println("9. Quit");
        System.out.println("\nPlease enter a number between 1 and 9.\n");
        String input = sc.nextLine().trim();
        try {
            menuChoice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("You must enter a number, not text");
        }
        return menuChoice;
    }

    /**
     * Prompts the user until a valid whole number is entered.
     *
     * @param sc the scanner to read from
     * @param prompt the text shown to the user
     * @return the integer entered by the user
     */
    private int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    /**
     * Asks the user for municipality number, lot number and section number,
     * and finds the matching property in the register.
     *
     * @param sc the scanner to read the user's input from
     * @return the property matching the numbers entered by the user
     * @throws IllegalArgumentException if no property with the given numbers exists
     */
    private Lot findByMuniLotSec(Scanner sc){
        int muniNrSearch = readInt(sc, "Enter the municipality Number: ");
        int lotNrSearch = readInt(sc, "Enter the Lot Number: ");
        int secNrSearch = readInt(sc, "Enter the Section Number: ");
        
        Lot foundLot = lotRegister.findLotByMuniLotSecNr(muniNrSearch, lotNrSearch, secNrSearch);
        if(foundLot != null){
            return foundLot;  
        }else{
            throw new IllegalArgumentException("Found no property with "+ muniNrSearch+"-"+lotNrSearch+"/"+secNrSearch);
        }
        
    }

    /**
     * Prompts the user until a valid decimal number is entered.
     * Accepts both comma and period as decimal separator.
     *
     * @param sc the scanner to read from
     * @param prompt the text shown to the user
     * @return the decimal number entered by the user
     */
    private double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number, e.g. 1017,6");
            }
        }
    }
    /**
     * Starts the application. This is the main loop of the application,
     * presenting the menu, retrieving the selected menu choice from the user,
     * and executing the selected functionality. The register is filled with
     * test data before the menu is shown.
     *
     * @param sc the scanner to read the user's input from
     */
    public void start(Scanner sc) {
        fillWithTestData();
        boolean finished = false;
        // The while-loop will run as long as the user has not selected
        // to quit the application
        while (!finished) {
            int menuChoice = this.showMenu(sc);
            switch (menuChoice)
            {
                case ADD_PROPERTY:
                    int muniNr = readInt(sc, "Enter the municipality Number (101-5054): ");
                    System.out.print("Enter the municipality Name: ");
                    String muniName = sc.nextLine();
                    int lotNr = readInt(sc, "Enter the Lot Number: ");
                    int secNr = readInt(sc, "Enter the Section Number: ");
                    System.out.print("Enter the name of the lot: ");
                    String name = sc.nextLine();
                    double area = readDouble(sc, "Enter the area of the lot: ");
                    System.out.print("Enter the name of the owner: ");
                    String nameOwner = sc.nextLine();
                    try {
                        Lot newLot = new Lot(muniNr, muniName, lotNr, secNr, name, area, nameOwner);
                        lotRegister.addLot(newLot);
                        System.out.println("Property " + newLot + " was added.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Could not add property: " + e.getMessage());
                    }
                    break;
                case LIST_ALL_PROPERTIES:
                    System.out.println(lotRegister);
                    break;
                case FIND_PROPERTY:
                    try{
                        System.out.println(findByMuniLotSec(sc));
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }                  
                    break;
                case CALCULATE_AVERAGE_AREA:
                    if(lotRegister.getNumberOfLots() > 0){
                        System.out.println(String.format("Average area of lots: %.1f m2", lotRegister.avgAreaOfLots()));
                    }else{
                        System.out.println("There must be at least one property in the register");
                    }
                    break;
                case REMOVE_LOT:
                    try {
                        lotRegister.removeLot(findByMuniLotSec(sc));
                        System.out.println("Removed property");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case FIND_BY_LOT_NUMBER:
                    int lotNrToFind = readInt(sc, "Enter the Lot Number: ");
                    ArrayList<Lot> lotsWithLotNr = lotRegister.findAllByLotNr(lotNrToFind);
                    if (lotsWithLotNr.isEmpty()) {
                        System.out.println("No properties with lot number " + lotNrToFind);
                    } else {
                        System.out.println("Properties with lot number " + lotNrToFind + ":");
                        for (Lot lotWithLotNr : lotsWithLotNr) {
                            System.out.println(lotWithLotNr);
                        }
                    }
                    break;
                case CHANGE_OWNER:
                    try {
                        Lot lotToChangeOwner = findByMuniLotSec(sc);
                        System.out.println("Current owner: " + lotToChangeOwner.getNameOfOwner());
                        System.out.print("Enter the name of the new owner: ");
                        String newOwner = sc.nextLine().trim();
                        if (newOwner.isEmpty()) {
                            System.out.println("The owner name can not be empty. Nothing was changed.");
                        } else {
                            lotToChangeOwner.setNameOfOwner(newOwner);
                            System.out.println("Owner of " + lotToChangeOwner.getMuniLotSecNr() + " changed to " + newOwner);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case CHANGE_NAME:
                    try {
                        Lot lotToRename = findByMuniLotSec(sc);
                        System.out.println("Current name: " + (lotToRename.getName().isEmpty() ? "(no name)" : lotToRename.getName()));
                        System.out.print("Enter the new name of the property: ");
                        String newName = sc.nextLine().trim();
                        lotToRename.setName(newName);
                        System.out.println("Name of " + lotToRename.getMuniLotSecNr() + " changed to " + (newName.isEmpty() ? "(no name)" : newName));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case EXIT:
                    System.out.println("Thank you for using the Properties app!\n");
                    finished = true;
                    break;
                default:
                    System.out.println("Unrecognized menu selected..");
                    break;
            }
        }
    }
    
    /**
     * Entry point of the application. Creates the user interface and starts it.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UI ui = new UI();
        ui.start(sc);
    }
}
