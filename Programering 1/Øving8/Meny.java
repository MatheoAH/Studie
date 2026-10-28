import java.util.Scanner;

/**
 * Menystyrt program som lar brukeren endre dataene i et ArbTaker-objekt.
 */
public class Meny {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbTaker a = new ArbTaker(new Person("Berit", "Johnsen", 1990), 101, 2015, 40000, 30);

        boolean fortsett = true;
        while (fortsett) {
            System.out.println("");
            System.out.println("1. Endre månedslønn");
            System.out.println("2. Endre skatteprosent");
            System.out.println("3. Endre navn og fødselsår (nytt Person-objekt)");
            System.out.println("4. Avslutt");
            System.out.print("Valg: ");

            String valg = scanner.nextLine();
            switch (valg) {
                case "1":
                    System.out.print("Ny månedslønn: ");
                    a.setManedslonn(scanner.nextDouble());
                    break;
                case "2":
                    System.out.print("Ny skatteprosent: ");
                    a.setSkatteprosent(scanner.nextDouble());
                    break;
                case "3":
                    System.out.print("Fornavn: ");
                    String fornavn = scanner.nextLine();
                    System.out.print("Etternavn: ");
                    String etternavn = scanner.nextLine();
                    System.out.print("Fødselsår: ");
                    int aar = scanner.nextInt();
                    a.setPersonalia(new Person(fornavn, etternavn, aar));
                    break;
                case "4":
                    fortsett = false;
                    break;
                default:
                    System.out.println("Ugyldig valg.");
            }

            if (fortsett) {
                skrivUt(a);
            }
        }
        scanner.close();
    }

    private static void skrivUt(ArbTaker a) {
        System.out.println("");
        System.out.println("Person");
        System.out.println(a);
        System.out.println("Skattetrekk per måned: " + a.skattetrekkPerManed());
        System.out.println("Bruttolønn per år:     " + a.bruttolonnPerAr());
        System.out.println("Skattetrekk per år:    " + a.skattetrekkPerAr());
        
    }
}
