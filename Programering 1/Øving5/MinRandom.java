package Øving5;

import java.util.Random;

public class MinRandom {
    private Random tall;

    public MinRandom(){
        tall = new Random();
    }

    public int nesteHeltall(int nedre, int ovre){
        if(ovre <= nedre){
            throw new IllegalArgumentException("Øvre må være større en nedre");
        }
        return tall.nextInt(nedre, ovre+1);
    }

    public double nesteDesimaltall(double nedre, double ovre){
        if(ovre <= nedre){
            throw new IllegalArgumentException("Øvre må være større en nedre");
        }
        return tall.nextDouble(nedre, ovre);
    }

    public  static void main(String[] args) throws Exception{
        MinRandom tilfeldig_tall = new MinRandom();
        for (int i = 0; i < 100; i++) {
            
            int tilfedlig_heltall = tilfeldig_tall.nesteHeltall(10, 20);
            double tilfeldig_desimaltall = tilfeldig_tall.nesteDesimaltall(10, 20);

            if(tilfedlig_heltall < 10 || tilfedlig_heltall >20 || tilfeldig_desimaltall < 10 || tilfeldig_desimaltall>=20){
                throw new Exception("Tallet er utenfor ønsket område");
            }
        }
        
        

    }
}
