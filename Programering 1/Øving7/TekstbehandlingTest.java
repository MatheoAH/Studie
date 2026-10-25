package Øving7;


public class TekstbehandlingTest {
    public static void main(String[] args) {
        Tekstbehandling tekst = new Tekstbehandling("Hei verden! Hvordan går det? Bra.");

        System.out.println("Tekst: " + tekst.get_Tekst());
        System.out.println("Antall ord: " + tekst.AntallOrd());
        System.out.println("Snitt ordlengde: " + tekst.Snitt_per_ord());
        System.out.println("Snitt ord per periode: " + tekst.Snitt_per_periode());
        System.out.println(tekst.Bytt_Ord("Hei", "Hei på deg"));
        System.out.println(tekst.get_Tekst());
        System.out.println(tekst.get_Tekst_Upper());

        
    }
}
