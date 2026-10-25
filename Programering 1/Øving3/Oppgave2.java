package Øving3;

import java.util.Scanner;
public class Oppgave2 {
    public static void main(){
        while(true){
            try{
                Boolean primtall_test = true;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Skriv inn ett heltall over 0: ");
                int primtall = scanner.nextInt();

                if(primtall < 0){
                    throw new Exception();
                }
                for (int i = primtall-1; i > 1 && primtall_test; i--) {
                    if (primtall % i == 0){
                        primtall_test = false;
                    }
                    else{
                        primtall_test = true;
                    }  
                }
                if (primtall_test){
                    System.out.println("Tallet er ett primtall");
                } else{
                    System.out.println("Tallet er ikke ett primtall");
                }
            } catch(Exception e){
                System.out.println("Skriv inn et heltall over 0");
            }
        }
        
        
    }
}
