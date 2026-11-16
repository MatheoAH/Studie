package Øving10;

import java.util.ArrayList;
import java.util.List;

public class Meny {
    private final String navn;
    private final ArrayList<Rett> retter;

    /** Rett-objektene deles med registeret (og andre menyer), men listen er menyens egen kopi. */
    public Meny(String navn, List<Rett> retter) {
        this.navn = navn;
        this.retter = new ArrayList<>(retter);
    }

    public String getNavn() {
        return navn;
    }

    public List<Rett> getRetter() {
        return List.copyOf(retter);
    }

    public double getTotalpris() {
        double sum = 0;
        for (Rett r : retter) {
            sum += r.getPris();
        }
        return sum;
    }

    public boolean prisInnenfor(double min, double maks) {
        double total = getTotalpris();
        return total >= min && total <= maks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Meny: ").append(navn).append("\n");
        for (Rett r : retter) {
            sb.append("  ").append(r).append("\n");
        }
        sb.append(String.format("  Totalpris: %.2f kr", getTotalpris()));
        return sb.toString();
    }
}
