public class Valuta {
    private String navn;
    private double kursTilNOK; 

    public Valuta(String navn, double kursTilNOK) {
        this.navn = navn;
        this.kursTilNOK = kursTilNOK;
    }

    public String getNavn() {
        return navn;
    }

    public double getKursTilNOK() {
        return kursTilNOK;
    }

    public double tilNorskeKroner(double belop) {
        return belop * kursTilNOK;
    }

    public double fraNorskeKroner(double belopNOK) {
        return belopNOK / kursTilNOK;
    }
}
