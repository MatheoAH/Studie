package Øving5;

public class Brok{
    private int teller;
    private int nevner;

    public Brok(int teller, int nevner){
        if(nevner == 0){
            throw new IllegalArgumentException("Nevner kan ikke være lik 0");
        }
        this.teller = teller;
        this.nevner = nevner;
    }

    public Brok(int teller){
        this.teller = teller;
        this.nevner = 1;
    }

    public void Multiplisere(Brok annen){
        this.teller *= annen.teller;
        this.nevner *= annen.nevner;
    }

    public void Dividere(Brok annen){
        this.teller *= annen.nevner;
        this.nevner *= annen.teller;
    }

    public void Summere(Brok annen){
        this.teller = teller*annen.nevner+annen.teller*nevner;
        this.nevner *=annen.nevner;
    }

    public void Subtrahere(Brok annen){
        this.teller = teller*annen.nevner-annen.teller*nevner;
        this.nevner *=annen.nevner;
    }

    public int getTeller(){
        return this.teller;
    }

    public int getNevner(){
        return this.nevner;
    }

    public static void main(String[] args){
        Brok a = new Brok(1,2);
        Brok b = new Brok(3);
        Brok c = new Brok(3,2);

        a.Summere(b);
        System.out.println(a.getTeller() + "/" + a.getNevner());
        b.Multiplisere(c);
        System.out.println(b.getTeller() + "/" + b.getNevner());
        c.Dividere(a);
        System.out.println(c.getTeller() + "/" + c.getNevner());
        c.Subtrahere(a);
        System.out.println(c.getTeller() + "/" + c.getNevner());




    }

    
}