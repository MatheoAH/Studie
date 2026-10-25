package Øving6;

import java.util.Arrays;

public class Matrise {
    public  double[][] matrise_variabel;
    private int rader = 0;
    private int kolonner = 0;

    public Matrise(double[][] matrise_variabel) {
        if (matrise_variabel == null || matrise_variabel.length == 0 || matrise_variabel[0] == null || matrise_variabel[0].length == 0) {
            throw new IllegalArgumentException("Matrisen må ha minst en rad og en kolonne");
        }

        this.rader = matrise_variabel.length;
        this.matrise_variabel = matrise_variabel;


        for (int i = 0; i < rader; i++) {
            if (matrise_variabel[i] == null || matrise_variabel[i].length != matrise_variabel[0].length) {
                throw new IllegalArgumentException("Alle rader må ha like mange kolonner");
            }
        }
        
        this.kolonner = matrise_variabel[0].length;

    }

    public Matrise Addere(Matrise annen){
        if (annen == null || annen.rader != this.rader || annen.kolonner != this.kolonner) {
            return null;
        }

        double[][] resultat = new double[rader][kolonner];
        for (int rad = 0; rad < this.rader; rad++) {
            for (int kol = 0; kol < this.kolonner; kol++) {
                resultat[rad][kol] = this.matrise_variabel[rad][kol]+ annen.matrise_variabel[rad][kol];
            }
        }

        return new Matrise(resultat);
    }

    public Matrise Multiplisere(Matrise annen){
        if (annen.rader != this.kolonner) {
            return null;
        }
        double[][] resultat = new double[this.rader][annen.kolonner];
        for (int rad = 0; rad < rader; rad++) {
            for (int annen_kol = 0; annen_kol < annen.kolonner; annen_kol++) {
                double sum = 0;
                for (int plass = 0; plass < kolonner; plass++) {
                    sum += matrise_variabel[rad][plass] * annen.matrise_variabel[plass][annen_kol];
                }
                resultat[rad][annen_kol] = sum;
            }
        }
        return new Matrise(resultat);

    }

    public Matrise Transformere(){
        double[][] resultat = new double[kolonner][rader];
        for(int rad = 0; rad<rader; rad++){
            for(int kol = 0; kol<kolonner; kol++){
                resultat[kol][rad] = matrise_variabel[rad][kol];
            }
        }
        return new Matrise(resultat);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] rad : matrise_variabel) {
            sb.append(Arrays.toString(rad)).append('\n');
        }
        return sb.toString();
    }

}
