
public class Klient {
    public static void main(String[] args) {
        Person person = new Person("Berit", "Johnsen", 1990);
        ArbTaker a = new ArbTaker(person, 101, 2015, 40000, 30);

        System.out.println("Personalia: " + a.getPersonalia());
        System.out.println("Arbtakernr: " + a.getArbtakernr());
        System.out.println("Ansettelsesår: " + a.getAnsettelsesar());
        System.out.println("Månedslønn: " + a.getManedslonn());
        System.out.println("Skatteprosent: " + a.getSkatteprosent());
        System.out.println("Skattetrekk per måned: " + a.skattetrekkPerManed());
        System.out.println("Bruttolønn per år: " + a.bruttolonnPerAr());
        System.out.println("Skattetrekk per år: " + a.skattetrekkPerAr());
        System.out.println("Navn: " + a.navn());
        System.out.println("Alder: " + a.alder());
        System.out.println("Antall år ansatt: " + a.antallArAnsatt());
        System.out.println("Ansatt mer enn 5 år? " + a.ansattMerEnn(5));
        System.out.println("Ansatt mer enn 20 år? " + a.ansattMerEnn(20));
        System.out.println("");
        a.setManedslonn(45000);
        a.setSkatteprosent(32);
        a.setPersonalia(new Person("Berit", "Hansen", 1990));
        System.out.println(a);
    }
}
