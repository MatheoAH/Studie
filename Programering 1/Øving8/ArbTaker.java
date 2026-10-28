import java.util.GregorianCalendar;
import java.util.Calendar;

public class ArbTaker {
    private Person personalia;
    private int arbtakernr;
    private int ansettelsesar;
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

    public void setPersonalia(Person personalia) { this.personalia = personalia; }
    public void setManedslonn(double manedslonn) { this.manedslonn = manedslonn; }
    public void setSkatteprosent(double skatteprosent) { this.skatteprosent = skatteprosent; }

    private int innevaerendeAr() {
        GregorianCalendar kalender = new GregorianCalendar();
        return kalender.get(Calendar.YEAR);
    }


    public double skattetrekkPerManed() {
        return manedslonn * skatteprosent / 100.0;
    }

    public double bruttolonnPerAr() {
        return manedslonn * 12;
    }

    public double skattetrekkPerAr() {
        return skattetrekkPerManed() * 10.5;
    }

    public String navn() {
        return personalia.getEtternavn() + ", " + personalia.getFornavn();
    }

    public int alder() {
        return innevaerendeAr() - personalia.getFodselsar();
    }

    public int antallArAnsatt() {
        return innevaerendeAr() - ansettelsesar;
    }

    public boolean ansattMerEnn(int antallAr) {
        return antallArAnsatt() > antallAr;
    }

    @Override
    public String toString() {
        return "Arbeidstaker nr. " + arbtakernr + "\n"
             + "Navn: " + navn() + "\n"
             + "Alder: " + alder() + " år\n"
             + "Ansatt siden: " + ansettelsesar + " (" + antallArAnsatt() + " år)\n"
             + "Månedslønn: " + manedslonn + " kr\n"
             + "Skatteprosent: " + skatteprosent + " %";
    }
}
