import java.util.Random;

public class Spiller {
    private int sumPoeng;
    private Random terning;

    public Spiller() {
        sumPoeng = 0;
        terning = new Random();
    }

    public int getSumPoeng() {
        return sumPoeng;
    }

    public int kastTerningen() {
        int terningkast = terning.nextInt(6) + 1;

        if (terningkast == 1) {
            sumPoeng = 0;
        }
        else {
            if (sumPoeng > 100){
                terningkast -= terningkast;
            }
            sumPoeng += terningkast;
        }
        return Math.abs(terningkast);
    }

    public boolean erFerdig() {
        return sumPoeng == 100;
    }
}
