import java.util.*;



public class Personinfo {

    private final Person personalia;
    private final int arbtakernr, ansettelsesaar;
    private static double manedslonn, skatteprosent;
    GregorianCalendar kalender = new GregorianCalendar();


private static Scanner in = new Scanner(System.in);


public Personinfo (Personinfo personalia_info, int arbtakernr, int ansettelsesaar, double moenedeslønn, dobule skatteprosent) {

    this.personalia_info = personalia_info;
    this.arbtakernr = arbtakernr;
    this.ansettelsesaar = ansettelsesaar;
    this.moenedeslønn = moenedeslønn;
    this.skatteprosent = skatteprosent;
    
}



public Person(String fornavn, String etternavn, int fodselsdag){
this.fornavn = "Elias";
this.etternavn = "Trana";
this.fodselsdag = 2002;

}

public Personalia getPersonalia() {

    return personalia;
}


public String[] fult_navn() {
String[] fult_navn = etternavn + fornavn;

return fult_navn;

}










}

