import java.util.GregorianCalendar;
import java.util.Calendar;

public class ArbTaker {
    private Person personalia;          // kan byttes ut (Person er immutabel)
    private int arbtakernr;       // endres normalt ikke
    private int ansettelsesar;    // endres normalt ikke
    private double manedslonn;
    private double skatteprosent;

    public ArbTaker(Person personalia, int arbtakernr, int ansettelsesar,
                    double manedslonn, double skatteprosent) {
        this.personalia = personalia;
        this.arbtakernr = arbtakernr;
        this.ansettelsesar = ansettelsesar;
        this.manedslonn = manedslonn;
        this.skatteprosent = skatteprosent;
    }

    public Person getPersonalia()   { return personalia; }
    public int getArbtakernr()      { return arbtakernr; }
    public int getAnsettelsesar()   { return ansettelsesar; }
    public double getManedslonn()   { return manedslonn; }
    public double getSkatteprosent(){ return skatteprosent; }

    // ---------- set-metoder (kun for det som naturlig endres) ----------
    public void setPersonalia(Person personalia) { this.personalia = personalia; }
    public void setManedslonn(double manedslonn) { this.manedslonn = manedslonn; }
    public void setSkatteprosent(double skatteprosent) { this.skatteprosent = skatteprosent; }

    // ---------- hjelpemetode ----------
    private int innevaerendeAr() {
        GregorianCalendar kalender = new GregorianCalendar();
        return kalender.get(Calendar.YEAR);
    }

    // ---------- operasjoner ----------

    /** Skattetrekk per måned i kroner. */
    public double skattetrekkPerManed() {
        return manedslonn * skatteprosent / 100.0;
    }

    /** Bruttolønn per år. */
    public double bruttolonnPerAr() {
        return manedslonn * 12;
    }

    /** Skattetrekk per år: juni er skattefri, desember halv skatt => 10,5 måneders trekk. */
    public double skattetrekkPerAr() {
        return skattetrekkPerManed() * 10.5;
    }

    /** Navn på formen "etternavn, fornavn". Samarbeider med Person. */
    public String navn() {
        return personalia.getEtternavn() + ", " + personalia.getFornavn();
    }

    /** Alder i år. Samarbeider med Person. */
    public int alder() {
        return innevaerendeAr() - personalia.getFodselsar();
    }

    /** Antall år ansatt i bedriften. */
    public int antallArAnsatt() {
        return innevaerendeAr() - ansettelsesar;
    }

    /** Sant hvis personen har vært ansatt mer enn et gitt antall år. */
    public boolean ansattMerEnn(int antallAr) {
        return antallArAnsatt() > antallAr;
    }

    @Override
    public String toString() {
        return "Arbeidstaker nr. " + arbtakernr + "\n"
             + "  Navn:            " + navn() + "\n"
             + "  Alder:           " + alder() + " år\n"
             + "  Ansatt siden:    " + ansettelsesar + " (" + antallArAnsatt() + " år)\n"
             + "  Månedslønn:      " + manedslonn + " kr\n"
             + "  Skatteprosent:   " + skatteprosent + " %";
    }
}
