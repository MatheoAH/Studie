package Øving9;

public class Student {
    private String NAVN;
    private int antOppg = 0;

    public Student(String navn){
        this.NAVN = navn;
    }

    public String getNavn(){
        return NAVN;
    }

    public int getAntOppg(){
        return antOppg;
    }

    public void økAntOppg(int økning){
        antOppg += økning;
    }

    public String toString(){
        return "Navn: " + this.NAVN + ", Antall Oppgaver: " + this.antOppg;
    }
}
