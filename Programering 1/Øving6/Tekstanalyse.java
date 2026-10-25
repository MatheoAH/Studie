package Øving6;

public class Tekstanalyse {
    private String tekst;
    private int[] antallTegn = new int[30];
    private String alfabet = "abcdefghijklmnopqrstuvwxyzæøå";
    private int sumBokstaver = 0;
    private int forskjelligeBokstaver = 0;
    private int hoyesteAntall = 0;

    public Tekstanalyse(String tekst) {
        this.tekst = tekst.toLowerCase();
        for (int i = 0; i < this.tekst.length(); i++) {
            int indeks = alfabet.indexOf(this.tekst.charAt(i));
            if (indeks >= 0) {
                antallTegn[indeks]++;
                sumBokstaver++;
            }
        }
    }

    public void ForskjelligeBokstaver() {
        for (int antall : antallTegn) {
            if (antall > 0) {
                forskjelligeBokstaver++;
            }
        }
        System.out.println("Det er " + forskjelligeBokstaver + " forskjellige bokstaver i teksten");

    }
    public void prosentIkkeBokstaver() {
        System.out.println((tekst.length() - sumBokstaver) * 100.0 / tekst.length() + "% av tegn er ikke bokstaver");
    }
    public void TotaltAntallBokstaver() {
        System.out.println("Totalt antall bokstaver er " + sumBokstaver);
    }
    public void BestemtBokstav(String bokstav){
        System.out.println("Det er " + antallTegn[alfabet.indexOf(bokstav.toLowerCase())] + " antall av bokstaven " + bokstav);
    }
    public void MestVanlig(){
        for(int i = 0; i<antallTegn.length;i++){
            if(antallTegn[i]>hoyesteAntall){
                hoyesteAntall=antallTegn[i];
            }
        }
        for(int i = 0; i<antallTegn.length;i++){
            if(antallTegn[i]==hoyesteAntall){
                System.out.println("Bokstaven/Bokstavene med høyest antall er " + antallTegn[i]);
            }
        }
    }
}
