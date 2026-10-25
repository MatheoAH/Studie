package Øving3;

import java.util.Scanner;
public class Oppgave1 {
    public static void main(){
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Skriv inn ett heltall over 0: ");
                int gange_tabell_tall = scanner.nextInt();
                if(gange_tabell_tall < 0){
                    throw new Exception();
                }
                System.out.println("Skriv inn ett heltall over "+ gange_tabell_tall+" : ");
                int gange_tabell_tall_slutt = scanner.nextInt();
                if(gange_tabell_tall_slutt < gange_tabell_tall){
                    throw new Exception();
                }
                scanner.close();
                int diff = gange_tabell_tall_slutt-gange_tabell_tall;
                for (int j = 0; j <= diff; j++) {
                    for (int i = 1; i <= 10; i++) {
                    System.out.println(gange_tabell_tall+j + " * " + i + " = " + (gange_tabell_tall+j)*i);
                    }
                    System.out.println("");
                }
                
                break;
            } catch(Exception e){
                System.out.println("Skriv inn et heltall over 0");
            }
        }
        
    }
}
