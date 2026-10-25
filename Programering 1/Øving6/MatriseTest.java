package Øving6;


public class MatriseTest {
    public static void main(String[] args){
        Matrise a = new Matrise(new double[][] {{2,5}, {6,7}});
        Matrise b = new Matrise(new double[][] {{3,2,1}, {3,0.5,1}});
        Matrise c = new Matrise(new double[][] {{1},{2},{3}});

        System.out.println("Matrise A: \n" + a);
        System.out.println("Matrise B: \n" + b);
        System.out.println("Matrise C: \n" + c);

        System.out.println("A + A: \n"+ a.Addere(a));
        System.out.println("A * B: \n"+ a.Multiplisere(b));
        System.out.println("Matrise C transformert: \n" + c.Transformere());
    }
}
