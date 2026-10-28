package Øving9;

public class OppgaveoversiktTest {
    public static void main(String[] args) {
        Oppgaveoversikt Oversikt = new Oppgaveoversikt();
        
        Student Stud1 = new Student("Matheo");
        Student Stud2 = new Student("Linus");
        Student Stud3 = new Student("Viktor");

        System.out.println(Oversikt.toString());

        Oversikt.regStud(Stud1);
        Oversikt.regStud(Stud3);
        Oversikt.regStud(Stud2);

        Oversikt.økAntOppg("Matheo",5);
        Oversikt.økAntOppg("Viktor", 10);

        System.out.println(Oversikt.finnAntOppg("Linus") + "\n");


        System.out.println(Oversikt.toString());

    }
}
