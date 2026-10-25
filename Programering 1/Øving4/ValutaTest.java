import java.text.DecimalFormat;
import java.util.Scanner;

public class ValutaTest {
    public static void main(String[] args) {
        Valuta dollar = new Valuta("dollar", 9.43);
        Valuta euro = new Valuta("euro", 10.81);
        Valuta svenskeKroner = new Valuta("svenske kroner", 0.96);

        Scanner scanner = new Scanner(System.in);
        int valg = 0;

        while (valg !=4) {
            System.out.println("Velg valuta:");
            System.out.println("1: dollar");
            System.out.println("2: euro");
            System.out.println("3: svenske kroner");
            System.out.println("4: avslutt");
            valg = scanner.nextInt();

            Valuta valgtValuta = null;
            switch (valg) {
                case 1 -> valgtValuta = dollar;
                case 2 -> valgtValuta = euro;
                case 3 -> valgtValuta = svenskeKroner;
                case 4 -> { continue; }
                default -> System.out.println("Ugyldig valg, prøv igjen.");
            }

            if (valgtValuta != null) {
                DecimalFormat f = new DecimalFormat("##.00");
                System.out.print("Skriv inn beløp i " + valgtValuta.getNavn() + " eller i NOK : ");
                double belop = scanner.nextDouble();
                double norskeKroner = valgtValuta.tilNorskeKroner(belop);
                double fraNorskeKroner = valgtValuta.fraNorskeKroner(belop);
                System.out.println(belop + " " +  valgtValuta.getNavn() +" = " + f.format(norskeKroner) + " NOK");
                System.out.println(belop + "NOK = " + f.format(fraNorskeKroner) +" "+ valgtValuta.getNavn());
            }

            System.out.println("");
        }

        scanner.close();
    }
}
