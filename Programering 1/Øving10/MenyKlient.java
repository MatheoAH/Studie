package Øving10;

import java.util.List;

public class MenyKlient {
    public static void main(String[] args) {
        MenyRegister register = new MenyRegister();

        // Registrer retter
        register.registrerRett(new Rett("Tomatsuppe", "forrett", 89, "Tomater, løk, hvitløk, buljong. Kok i 20 min."));
        register.registrerRett(new Rett("Rekecocktail", "forrett", 119, "Reker, salat, dressing."));
        register.registrerRett(new Rett("Biff", "hovedrett", 289, "Stek biffen 3 min per side."));
        register.registrerRett(new Rett("Laks", "hovedrett", 249, "Ovnsbakt laks, 200 grader i 15 min."));
        register.registrerRett(new Rett("Sjokoladekake", "dessert", 99, "Smør, sukker, egg, kakao, mel."));
        register.registrerRett(new Rett("Is", "dessert", 59, "Vaniljeis med bær."));

        System.out.println("--- Registrere rett med navn som finnes fra før ---");
        boolean ok = register.registrerRett(new Rett("biff", "hovedrett", 199, "..."));
        System.out.println("Registrert: " + ok + " (forventet false)");

        System.out.println("\n--- Finn rett gitt navn ---");
        Rett laks = register.finnRett("Laks");
        System.out.println(laks);
        System.out.println("Oppskrift: " + laks.getOppskrift());
        System.out.println("Finn 'Pizza': " + register.finnRett("Pizza") + " (forventet null)");

        System.out.println("\n--- Alle desserter ---");
        for (Rett r : register.finnRetterAvType("dessert")) {
            System.out.println(r);
        }

        System.out.println("\n--- Registrer menyer ---");
        Meny m1 = register.registrerMeny("Fiskemeny", List.of("Rekecocktail", "Laks", "Is"));
        Meny m2 = register.registrerMeny("Kjøttmeny", List.of("Tomatsuppe", "Biff", "Sjokoladekake"));
        Meny m3 = register.registrerMeny("Lettmeny", List.of("Tomatsuppe", "Is")); // Tomatsuppe og Is i flere menyer
        Meny ugyldig = register.registrerMeny("Ugyldig", List.of("Biff", "Pizza"));
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
        System.out.println("Meny med ukjent rett: " + ugyldig + " (forventet null)");

        System.out.println("\n--- Menyer med totalpris mellom 400 og 500 kr ---");
        for (Meny m : register.finnMenyerIPrisintervall(400, 500)) {
            System.out.println(m);
        }

        System.out.println("\n--- Menyer med totalpris mellom 0 og 200 kr ---");
        for (Meny m : register.finnMenyerIPrisintervall(0, 200)) {
            System.out.println(m);
        }
    }
}
