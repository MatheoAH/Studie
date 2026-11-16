import java.util.ArrayList;

/**
 * Represents a register of properties (lots) in a municipality.
 *
 * <p>The register can add and remove properties, search for properties, and
 * calculate the average area of all registered properties.</p>
 *
 * <p><b>Choice of collection:</b> The properties are stored in an {@link ArrayList}.
 * The number of properties in a municipality is not known in advance and will change
 * over time. An ArrayList grows and shrinks automatically, so there is no need to
 * pick a fixed size up front, as with a fixed size array, and no need to handle
 * empty slots or copying when the array is full. It also provides ready-made methods
 * for adding, removing and iterating over the elements.</p>
 *
 * @author MatheoHammer
 * @version 1.0
 */
public class LotRegister {
    /** All properties in the register. */
    private ArrayList<Lot> allLots = new ArrayList<>();

    /**
     * Adds a property to the register.
     *
     * @param lot the property to add
     * @throws IllegalArgumentException if a property with the same ID
     *                                  (municipality number, lot number and section number)
     *                                  is already registered
     */
    public void addLot(Lot lot){
        if(findLotByMuniLotSecNr(lot.getMunicipalityNumber(), lot.getLotNumber(), lot.getSectionNumber()) != null){
            throw new IllegalArgumentException("Property "+ lot.getMuniLotSecNr()+" is already in register");
        }
        allLots.add(lot);
    }

    /**
     * Removes a property from the register.
     *
     * @param lot the property to remove
     * @throws IllegalArgumentException if the property is not in the register
     */
    public void removeLot(Lot lot){
        if(!allLots.contains(lot)){
            throw new IllegalArgumentException("Property not in register");
        }
        allLots.remove(lot);
    }

    /**
     * Returns the number of properties in the register.
     *
     * @return the number of registered properties
     */
    public int getNumberOfLots(){
        return allLots.size();
    }

    /**
     * Finds the property with the given municipality number, lot number and section number.
     *
     * @param municipalityNumber the municipality number of the property
     * @param lotNumber the lot number (gnr) of the property
     * @param sectionNumber the section number (bnr) of the property
     * @return the matching property, or {@code null} if no property was found
     */
    public Lot findLotByMuniLotSecNr(int municipalityNumber, int lotNumber, int sectionNumber){
        String search = municipalityNumber +"-"+ lotNumber +"/"+ sectionNumber;
        for (Lot lot : allLots){
            if(lot.getMuniLotSecNr().equals(search)){
                return lot;
            }
        }
        return null;
    }

    /**
     * Calculates the average area of all properties in the register.
     * The register should contain at least one property before this method is called,
     * otherwise the result is {@code NaN}.
     *
     * @return the average area in square meters
     */
    public double avgAreaOfLots(){
        double sum = 0;
        for (Lot lot : allLots){
            sum += lot.getArea();
        }
        return sum/allLots.size();
    }

    /**
     * Finds all properties with the given lot number (gnr).
     *
     * @param lotNumber the lot number to search for
     * @return a list of all properties with the given lot number,
     *         or an empty list if none were found
     */
    public ArrayList<Lot> findAllByLotNr(int lotNumber){
        ArrayList<Lot> allLotsByLotNr = new ArrayList<>();
        for (Lot lot : allLots){
            if(lotNumber == lot.getLotNumber()){
                allLotsByLotNr.add(lot);
            }
        }
        return allLotsByLotNr;
    }

    /**
     * Returns all properties in the register as a table, with one property per line
     * and a header line with the column names.
     *
     * @return the register as a formatted table
     */
    @Override
    public String toString(){
        String output = String.format("%-18s %-12s %-10s %-10s %s\n", "Muni Lot Sec Nr", "Muni Name", "Name", "Area", "Name of Owner");
        for (Lot lot: allLots){
            output += String.format("%-18s %-12s %-10s %-10s %s\n", lot.getMuniLotSecNr(), lot.getMunicipalityName(), lot.getName(), lot.getArea(), lot.getNameOfOwner());
        }
        return output;
    }
}
