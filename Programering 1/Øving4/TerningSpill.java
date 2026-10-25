/**
 * Klientprogram som simulerer terningspillet "100" mellom to spillere, A og B.
 */
public class TerningSpill {
    public static void main(String[] args) {
        Spiller spillerA = new Spiller();
        Spiller spillerB = new Spiller();
        int runde = 0;

        while (true) {
            runde++;

            int kastA = spillerA.kastTerningen();
            int kastB = spillerB.kastTerningen();

            System.out.println("Runde " + runde + ":");
            System.out.println("  Spiller A kastet " + kastA + ", sum = " + spillerA.getSumPoeng());
            System.out.println("  Spiller B kastet " + kastB + ", sum = " + spillerB.getSumPoeng());

            if (spillerA.erFerdig()) {
                System.out.println("Spiller A har vunnet spillet!");
                break;
            } else if (spillerB.erFerdig()) {
                System.out.println("Spiller B har vunnet spillet!");
                break;
            }
        }
    }
}
