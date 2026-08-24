package Øving1;
import java.util.Scanner;
public class Oppgave3 {
    
    public static void main(String[] args){
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Skriv ett antall sekunder: ");
                double tot_antall_sekunder = scanner.nextDouble();
                if (tot_antall_sekunder <= 0){
                    throw new IllegalAccessException();
                }
                scanner.close();
                
                double timer = Math.floor(tot_antall_sekunder/3600);
                tot_antall_sekunder -= timer * 3600;
                double minutter = Math.floor(tot_antall_sekunder / 60);
                tot_antall_sekunder -= minutter *60;

                System.out.println(timer +" timer, " + minutter +" minutter og "+ tot_antall_sekunder + " sekunder");
                break;
            } catch(Exception e){
                System.out.println("Skriv inn ett tall som er større enn 0");
            }
            
        }
           

        



    }
}
