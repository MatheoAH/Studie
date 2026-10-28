package Øving9;

import java.util.ArrayList;

public class Oppgaveoversikt {
    private ArrayList<Student> studenter = new ArrayList<>();
    private int antStud = 0;

    public int antallStud(){
        return antStud;
    }

    public void regStud(Student stud){
        antStud += 1;
        studenter.add(stud);
    }

    public String finnAntOppg(String navn){
        for (Student stud : studenter){
            if (stud.getNavn() == navn){
                return stud.toString();
            }
        }
        return null;
    }

    public void økAntOppg(String navn, int økning){
        for (Student stud : studenter){
            if (stud.getNavn() == navn){
                stud.økAntOppg(økning);
            }
        }
    }

    public String toString(){
        if(antStud == 0){
            return "Ingen studenter i listen";
        }
        String finalprint = "";
        for(Student stud : this.studenter){
            finalprint += stud.toString() + "\n";
        }
        return finalprint;
    }
}
