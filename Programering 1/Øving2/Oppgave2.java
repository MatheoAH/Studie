package Øving2;

public class Oppgave2 {
    public static void main(){
        double merkeA_vekt = 450; //g 
        double merkeA_pris = 35.90; //kr

        double merkeB_vekt = 500; //g
        double merkeB_pris = 39.50; //kr

        if (merkeA_pris/merkeA_vekt > merkeB_pris/merkeB_vekt){
            System.out.println("Ved merkeB får du mer for pengene");
        }
        else if (merkeA_pris/merkeA_vekt < merkeB_pris/merkeB_vekt){
            System.out.println("Ved merkeA får du mer for pengene");
        }
        else{
            System.out.println("merkeA og merkeB gir like mye for pengene");
        }
    }
}
