package Øving7;

public class Tekstbehandling {
    private String tekst;
    private int antall_ord;
    private double snitt_ordlengde;
    private double snitt_ord_i_periode;
    private String[] tekst_split;
    private String[] tekst_split_periode;
    String[] ny_teskt;

    public Tekstbehandling(String tekst){
        this.tekst = tekst;
        tekst_split = tekst.split(" ");
        antall_ord = tekst_split.length;

    }

    public int AntallOrd(){
        return antall_ord;
    }

    public double Snitt_per_ord(){
        snitt_ordlengde = 0;
        for(String ord : tekst_split){
            snitt_ordlengde += ord.length();
        }
        return snitt_ordlengde/antall_ord;
    }

    public double Snitt_per_periode(){
        snitt_ord_i_periode = 0;
        tekst_split_periode = tekst.split("[.!?:]");
        int antall_perioder = tekst_split_periode.length;
        for (String setning : tekst_split_periode){
            String[] ord_liste = setning.split(" ");
            snitt_ord_i_periode += ord_liste.length;
        }
        return snitt_ord_i_periode/antall_perioder;
    }

    public String Bytt_Ord(String Ord_til_bytting, String nyttOrd){
        ny_teskt = tekst_split.clone();
        for (int i = 0; i < ny_teskt.length; i++) {
            if (ny_teskt[i].equals(Ord_til_bytting)) {
                ny_teskt[i] = nyttOrd;
            }
        }
        return String.join(" ", ny_teskt);
    }

    public String get_Tekst(){
        return tekst;
    }

    public String get_Tekst_Upper(){
        return tekst.toUpperCase();
    }
}
