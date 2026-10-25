package Øving7;

public class NyString {
    private String tekst;


    public NyString(String tekst) {
        this.tekst = tekst;
    }

    public String Forkorting(){
        String forkortet_tekst = "";
        String[] split_tekst = tekst.split(" ");
        for (String ord : split_tekst){
            forkortet_tekst += ord.charAt(0);
        }
        return forkortet_tekst;
    }

    public String Fjerning(String bokstav){
        String fjernet_bokstav = "";
        char bokstavChar = bokstav.charAt(0);
        for (int i = 0; i < tekst.length(); i++) {
            if (tekst.charAt(i) != bokstavChar) {
                fjernet_bokstav += tekst.charAt(i);
            }
        }
        return fjernet_bokstav;
    }
}
