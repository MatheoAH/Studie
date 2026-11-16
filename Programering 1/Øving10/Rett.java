package Øving10;

public class Rett {
    private final String navn;
    private final String type;
    private final double pris;
    private final String oppskrift;

    public Rett(String navn, String type, double pris, String oppskrift) {
        if (navn == null || navn.isBlank()) {
            throw new IllegalArgumentException("Navn kan ikke være tomt");
        }
        if (pris < 0) {
            throw new IllegalArgumentException("Pris kan ikke være negativ");
        }
        this.navn = navn;
        this.type = type;
        this.pris = pris;
        this.oppskrift = oppskrift;
    }

    public String getNavn() {
        return navn;
    }

    public String getType() {
        return type;
    }

    public double getPris() {
        return pris;
    }

    public String getOppskrift() {
        return oppskrift;
    }

    /** Navnet identifiserer retten entydig, uavhengig av store/små bokstaver. */
    public boolean harNavn(String navn) {
        return this.navn.equalsIgnoreCase(navn);
    }

    public boolean erAvType(String type) {
        return this.type.equalsIgnoreCase(type);
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10s %8.2f kr", navn, type, pris);
    }
}
