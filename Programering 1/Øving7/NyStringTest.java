package Øving7;

public class NyStringTest {
    public static void main(String[] args){
        NyString tekst = new NyString("Denne setningen kan forkortes");
        System.err.println(tekst.Forkorting());
        System.err.println(tekst.Fjerning("e"));

    }
}
