package Øving10;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class ArrengementRegister {
    private String SPACEBETWEEN = "24";
    private ArrayList<Arrangement> arrangements = new ArrayList<>();

    public ArrengementRegister(){

    };

    public void addArrangement(Arrangement a){
        arrangements.add(a);
    }

    public ArrayList<Arrangement> findByPlace(String sted){
        ArrayList<Arrangement> arrangementsByPlace = new ArrayList<>();
        for (Arrangement a : arrangements){
            if (a.getSted().equalsIgnoreCase(sted)){
                arrangementsByPlace.add(a);
            }
        }
        return arrangementsByPlace;
    }

    public ArrayList<Arrangement> findByDate(long dato){
        ArrayList<Arrangement> arrangementsByDate = new ArrayList<>();
        for (Arrangement a : arrangements){
            if (a.getTidspunkt()/10000 ==dato){
                arrangementsByDate.add(a);
            }
        }
        return arrangementsByDate;
    }

    public ArrayList<Arrangement> findBetweenDates(long start, long slutt){
        ArrayList<Arrangement> arrangementsBetweenDates = new ArrayList<>();
        for (Arrangement a : arrangements){
            long dag = a.getTidspunkt() / 10000;
            if (dag >= start && dag <= slutt){
                arrangementsBetweenDates.add(a);
            }
        }
        return arrangementsBetweenDates;
    }

    public List<Arrangement> sortList(){
        return arrangements.stream().sorted(Comparator.comparing(Arrangement::getSted, String.CASE_INSENSITIVE_ORDER)
        .thenComparing(Arrangement::getType, String.CASE_INSENSITIVE_ORDER).thenComparingLong(Arrangement::getTidspunkt)).toList();
    }
    @Override 
    public String toString(){
        String output = String.format("%-5s %-"+SPACEBETWEEN+"s %-"+SPACEBETWEEN+"s %-"+SPACEBETWEEN+"s %-"+SPACEBETWEEN+"s %-"+SPACEBETWEEN+"s", "ID", "Navn", "Sted", "Arrangør", "Type", "Tidspunkt") + "\n";
        for (Arrangement a : sortList()){
            output+=a+"\n";
        }
        return output;
    }

}
