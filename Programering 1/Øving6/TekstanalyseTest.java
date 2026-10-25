package Øving6;

import java.util.Scanner;
public class TekstanalyseTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Skriv inn en setning eller slutt for å avslutte løkken");
            String valg = scanner.nextLine();
            if (valg.equalsIgnoreCase("slutt")) {
                break;
            }
            Tekstanalyse tekstanalyse = new Tekstanalyse(valg);
            tekstanalyse.ForskjelligeBokstaver();
            tekstanalyse.prosentIkkeBokstaver();
            tekstanalyse.TotaltAntallBokstaver();
            tekstanalyse.BestemtBokstav("b");
            tekstanalyse.MestVanlig();

        }
        scanner.close();
    }
}
