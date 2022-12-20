//Java ;(
import java.util.*;
//Finner opp klasse som ikke er public
class Minuttsekund {

    public static void main(String[]args) {
        //Denne gjør at jeg kan ta input fra bruker
        Scanner sc = new Scanner(System.in);
        //Printer fårespørsel, samt mottar første input
        //Dette gjentas på timer, minutt og sekund
        System.out.println("Antall timer: ");
        int timer = sc.nextInt();

        System.out.println("Antall minutter: ");
        int minutt = sc.nextInt();

        System.out.println("Antall sekunder: ");
        int sekund = sc.nextInt();
        //Finner sekundene med å gange med hvor mange sekund det er i en time
        int totaltime = timer * 3600;
        //Finner sekundene med å gange med hvor mange sekund det er i et minutt 
        int totalminutt = minutt * 60;
        //Produserer i totalsummen i int (ønsker ikke kommatall), ingen vitts å konvertere sekundene da de allerede er sekunder
        int totalsum = totaltime + totalminutt + sekund;
        //Printer resultatet
        System.out.println("Antall sekunder: " + totalsum);

    }

}
