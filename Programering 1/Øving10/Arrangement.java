package Øving10;

public class Arrangement {
    private String SPACEBETWEEN = "24";
    private int nummer;
    private String navn;
    private String sted;
    private String arrangør;
    private String type;
    private long tidspunkt;

    public Arrangement(int nummer, String navn, String sted, String arrangør, String type, long tidspunkt){
        this.nummer = nummer;
        this.navn = navn;
        this.sted = sted;
        this.arrangør = arrangør;
        this.type = type;
        this.tidspunkt = tidspunkt; //200210301800 (kl 18 den 30.oktober 2002)
    }

    public int getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }

    public String getArrangør() {
        return arrangør;
    }

    public String getSted() {
        return sted;
    }

    public long getTidspunkt() {
        return tidspunkt;
    }

    public String getType() {
        return type;
    }

    @Override 
    public String toString(){
        return String.format("%-5s %-"+SPACEBETWEEN+"s %-"+SPACEBETWEEN+"s %-"+SPACEBETWEEN+"s %-"+SPACEBETWEEN+"s %-"+SPACEBETWEEN+"s", nummer, navn, sted, arrangør, type, tidspunkt);
    }
}