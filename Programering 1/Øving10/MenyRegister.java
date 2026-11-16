package Øving10;

import java.util.ArrayList;
import java.util.List;

public class MenyRegister {
    private final ArrayList<Rett> retter = new ArrayList<>();
    private final ArrayList<Meny> menyer = new ArrayList<>();

    /** Registrerer en ny rett. Returnerer false hvis en rett med samme navn finnes fra før. */
    public boolean registrerRett(Rett rett) {
        if (finnRett(rett.getNavn()) != null) {
            return false;
        }
        retter.add(rett);
        return true;
    }

    /** Returnerer retten med gitt navn, eller null hvis den ikke finnes. */
    public Rett finnRett(String navn) {
        for (Rett r : retter) {
            if (r.harNavn(navn)) {
                return r;
            }
        }
        return null;
    }

    public ArrayList<Rett> finnRetterAvType(String type) {
        ArrayList<Rett> resultat = new ArrayList<>();
        for (Rett r : retter) {
            if (r.erAvType(type)) {
                resultat.add(r);
            }
        }
        return resultat;
    }

    /**
     * Registrerer en ny meny ut fra navnene på rettene.
     * Returnerer menyen, eller null hvis en av rettene ikke er registrert.
     */
    public Meny registrerMeny(String menynavn, List<String> rettnavn) {
        ArrayList<Rett> valgteRetter = new ArrayList<>();
        for (String navn : rettnavn) {
            Rett r = finnRett(navn);
            if (r == null) {
                return null;
            }
            valgteRetter.add(r);
        }
        Meny meny = new Meny(menynavn, valgteRetter);
        menyer.add(meny);
        return meny;
    }

    public ArrayList<Meny> finnMenyerIPrisintervall(double min, double maks) {
        ArrayList<Meny> resultat = new ArrayList<>();
        for (Meny m : menyer) {
            if (m.prisInnenfor(min, maks)) {
                resultat.add(m);
            }
        }
        return resultat;
    }
}
