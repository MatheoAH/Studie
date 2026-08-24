package Øving2;

import java.util.Scanner;

public class Oppgave1 {
    public static void main(){
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Skriv ett år: ");
                int Aar = scanner.nextInt();
                if(Aar < 0){
                    throw new Exception();
                }
                scanner.close();
                if (Aar%4==0 && Aar%100!=0 || Aar%400==0){
                    System.out.println("Året "+Aar+" er ett skuddår");
                }
                else{
                    System.out.println("Året "+Aar+" er ikke ett skuddår");
                }
                break;
            } catch(Exception e){
                System.out.println("Skriv inn ett heltall som er større enn 0");
            }
            
        }
    }
}
