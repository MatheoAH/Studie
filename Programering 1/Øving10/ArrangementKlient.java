package Øving10;

import java.util.List;
import java.util.Scanner;

public class ArrangementKlient {
    private static final Scanner input = new Scanner(System.in);
    private static final ArrengementRegister register = new ArrengementRegister();
    private static int nesteNummer = 1;

    public static void main(String[] args) {
        leggInnTestdata();

        boolean ferdig = false;
        while (!ferdig) {
            skrivMeny();
            int valg = lesHeltall("Velg: ");
            switch (valg) {
                case 1 -> registrerArrangement();
                case 2 -> finnPaaSted();
                case 3 -> finnPaaDato();
                case 4 -> finnMellomDatoer();
                case 5 -> System.out.println(register);
                case 0 -> ferdig = true;
                default -> System.out.println("Ugyldig valg, prøv igjen.");
            }
        }
        System.out.println("Ha det!");
    }

    private static void skrivMeny() {
        System.out.println();
        System.out.println("===== ARRANGEMENTSREGISTER =====");
        System.out.println("1. Registrer nytt arrangement");
        System.out.println("2. Finn arrangementer på et sted");
        System.out.println("3. Finn arrangementer på en dato");
        System.out.println("4. Finn arrangementer mellom to datoer");
        System.out.println("5. Vis alle (sortert på sted, type, tid)");
        System.out.println("0. Avslutt");
    }

    private static void registrerArrangement() {
        String navn = lesTekst("Navn: ");
        String sted = lesTekst("Sted: ");
        String arrangor = lesTekst("Arrangør: ");
        String type = lesTekst("Type (f.eks. konsert, foredrag): ");
        long tidspunkt = lesTidspunkt("Tidspunkt (ååååmmddttmm, f.eks. 202211161800): ", 12);

        register.addArrangement(new Arrangement(nesteNummer, navn, sted, arrangor, type, tidspunkt));
        System.out.println("Arrangement nr. " + nesteNummer + " registrert.");
        nesteNummer++;
    }

    private static void finnPaaSted() {
        String sted = lesTekst("Sted: ");
        skrivListe(register.findByPlace(sted));
    }

    private static void finnPaaDato() {
        long dato = lesTidspunkt("Dato (ååååmmdd): ", 8);
        skrivListe(register.findByDate(dato));
    }

    private static void finnMellomDatoer() {
        long start = lesTidspunkt("Fra dato (ååååmmdd): ", 8);
        long slutt = lesTidspunkt("Til dato (ååååmmdd): ", 8);
        if (start > slutt) {
            System.out.println("Fra-datoen må være før til-datoen.");
            return;
        }
        skrivListe(register.findBetweenDates(start, slutt));
    }

    private static void skrivListe(List<Arrangement> liste) {
        if (liste.isEmpty()) {
            System.out.println("Fant ingen arrangementer.");
            return;
        }
        for (Arrangement a : liste) {
            System.out.println(a);
        }
    }

    // ---------- Hjelpemetoder for innlesing ----------

    private static String lesTekst(String ledetekst) {
        while (true) {
            System.out.print(ledetekst);
            String tekst = input.nextLine().trim();
            if (!tekst.isEmpty()) {
                return tekst;
            }
            System.out.println("Feltet kan ikke være tomt.");
        }
    }

    private static int lesHeltall(String ledetekst) {
        while (true) {
            System.out.print(ledetekst);
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Skriv inn et tall.");
            }
        }
    }

    /** Leser et tall med nøyaktig antallSiffer siffer (8 for dato, 12 for tidspunkt). */
    private static long lesTidspunkt(String ledetekst, int antallSiffer) {
        while (true) {
            System.out.print(ledetekst);
            String tekst = input.nextLine().trim();
            if (tekst.matches("\\d{" + antallSiffer + "}")) {
                return Long.parseLong(tekst);
            }
            System.out.println("Må være nøyaktig " + antallSiffer + " siffer.");
        }
    }

    private static void leggInnTestdata() {
        register.addArrangement(new Arrangement(nesteNummer++, "Jazzkveld", "Samfundet", "Studentersamfundet", "Konsert", 202211181900L));
        register.addArrangement(new Arrangement(nesteNummer++, "Java for alle", "Gløshaugen", "NTNU", "Foredrag", 202211161015L));
        register.addArrangement(new Arrangement(nesteNummer++, "Quiz", "Samfundet", "Studentersamfundet", "Quiz", 202211162000L));
        register.addArrangement(new Arrangement(nesteNummer++, "Rockekonsert", "Samfundet", "UKA", "Konsert", 202211251930L));
        register.addArrangement(new Arrangement(nesteNummer++, "Bokbad", "Biblioteket", "Folkebiblioteket", "Foredrag", 202212011800L));
    }
}
