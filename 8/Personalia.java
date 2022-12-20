import java.util.*;

public class Personalia {

    public static Scanner in = new Scanner(System.in);


    public ArbTaker (Personinfo personalia_info, int arbtakernr, int ansettelsesaar, double moenedeslønn, dobule skatteprosent) {

        this.personalia_info = personalia_info;
        this.arbtakernr = arbtakernr;
        this.ansettelsesaar = ansettelsesaar;
        this.moenedeslønn = moenedeslønn;
        this.skatteprosent = skatteprosent;
        
    }
    
    public Person getPersonalia() {
        return personalia;
    }
    public int getArbtakernr() {
        return arbtakernr;
    }
    public int getAnsettelsesaar() {
        return ansettelsesaar;
    }
    public double getManedslonn() {
        return manedslonn;
    }
    public double getSkatteprosent() {
        return skatteprosent;

    }


public static void meny(String a) {


System.out.println("1. Velg hva du ønsker å printe: ");
System.out.println("2. Fult navn");
System.out.println("3. Skattetrekk");
System.out.println("4. Bruttolønn");
System.out.println("5. Alder:");
System.out.println("6. Antall år ansatt");
System.out.println("7. Om ansatt har vært i arbeid lengre enn x");

int input = in.nextInt();






switch(input) {

case 1:
    System.out.println(personinfo.fult_navn());

case 2: 


case 3:

default: System.out.println("Oh no!");
        break;






}
    
}

}







