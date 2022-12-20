import java.util.*;
//Finner opp klasser fordi det må ha et navn
class sekundertiltid {

public static void main(String[]args) {
    //Etablerer input 
    Scanner in = new Scanner(System.in);

    //Ber om input fra bruker, og leser dette
    System.out.println("Antall sekunder: ");
    int sekunder = in.nextInt();
    
    
//Prinsippet nedenfor er at int gir hele tall i retur, noe som gjør at en kan finne resten
// og bruke denne resten til å kovertere det til en mindre enhet

    //Konverterer sekunder til til hele timer med bruk av int
    int time = sekunder / 3600;
    //Finner resten som blir igjen etter delingen, dette blir konvertert til minutter
    int rest1= (sekunder%3600);
    
    int minutt = rest1 / 60;
    
    //Her blir sekundene utregnet med å ta de tidligere summene og konvertere dem til sekunder, før det trekkes fra sekundverdien
    int sekund = sekunder - (time*3600+minutt*60);
    
    
    
    //Printer resultat 
    System.out.println("Antall timer: " + time + " Antall minutter: " + minutt + " Antall sekunder: " + sekund);

    


}

}