import java.util.*;
//Klasser blir definert 😎
class kjøttdeig {

public static void main(String[]args) {
    //Etablerer input fra bruker
    Scanner in = new Scanner(System.in);

    //Her blir prisen og vekten på 2 ulike kjøttdeiger inputtet
    

    System.out.println("Vekt på kjøttdeig A: ");
    int kjøttdeiga = in.nextInt();

    System.out.println("Pris på kjøttdeig A: ");
    double prisa = in.nextDouble();

    System.out.println("Vekt på kjøttdeig B: ");
    int kjøttdeigb = in.nextInt();

    System.out.println("Pris på kjøttdeig B: ");
    double prisb = in.nextDouble();

    //Her blir vekten del på prisen på hver av kjøttdeigene
    
    double kiloprisa = kjøttdeiga / prisa; 

    double kiloprisb = kjøttdeigb / prisb;

    //Her sammenlignere den pris per gram på kjøttdeigene, og printer hvilken som er billigst
    System.out.println("                          ");

    if(kiloprisa > kiloprisb){
        System.out.println("Kjøttdeig A er billigst!");
        }
        else if(kiloprisa < kiloprisb){
        System.out.println("Kjøttdeig B er billigst!");
        }
        else{
        System.out.println("Kjøttdeigene koster det samme!");
    }
    System.out.println("                          ");
    //I tillegg til å si hvilken som  er billigst så blir også gram per kr også vist til brukeren for å se forholdet
    System.out.println("Kjøttdeig A: g/kr: " + kiloprisa);
    System.out.println("Kjøttdeig B: g/kr " + kiloprisb);

}

}
