import java.util.*;

public class Brukerklient {

    /**
     * Asks for all the different values, and saves them to the different files 
     * @param args
     */
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Fornavn: ");
        String fornavn = in.nextLine();
        System.out.println("Etternavn: ");
        String etternavn = in.nextLine();
        System.out.println("Fødselsår: ");
        int bursdag = in.nextInt();
        //Saves to Person_info file
        Person_info person_info = new Person_info(fornavn, etternavn, bursdag);

        System.out.println("Ansattnummer: ");
        int ansatt_nummer = in.nextInt();
        System.out.println("Ansettelsesår: ");
        int ansettelses_aar = in.nextInt();
        System.out.println("Månedslønn: ");
        double moneds_lonn = in.nextDouble();
        System.out.println("Skatteprosent: ");
        double skatte_prosent = in.nextDouble();
        //Saves to Arbeids_info file
        Arbeids_info arbeids_info = new Arbeids_info(person_info, ansatt_nummer, ansettelses_aar, moneds_lonn, skatte_prosent);

        /**
         * Prints the info at the bottom om Arbeids_info
         */
        printText(arbeids_info);

    while(true) {
        vis_meny(arbeids_info);
    }
    
    }
    /**
     * 
     * @param arbeids_info
     * prints the Menu, then gives the user a switch case that allows for modifications 
     * The modifications are limited to a few of the inputs
     */

    public static void vis_meny(Arbeids_info arbeids_info) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("1: Endre månedslønn");
        System.out.println("2: Endre skatteprosent");
        System.out.println("3: Endre ansattnummer");
        System.out.println("4: Vis personinfo");
        System.out.println("5: Avbryt");
    
        int input = in.nextInt();

        switch(input){
            case 1: 
            System.out.println("\n");
            System.out.println("Ny månedslønn: ");
            double ny_Moneds_lonn = in.nextDouble();
            arbeids_info.setMoneds_lonn(ny_Moneds_lonn);
            System.out.println("Nåværende lønn: " + arbeids_info.hent_moneds_lonn());
            vis_meny(arbeids_info);
            break;
        
            case 2:
            System.out.println("Ny skatteprosent: ");
            double ny_Skatteprosent = in.nextDouble();
            arbeids_info.setSkatteprosent(ny_Skatteprosent);
            System.out.println("Nåværende skatteprosent: " + arbeids_info.hent_skatte_prosent());
            vis_meny(arbeids_info);
            break;

            case 3:
            System.out.println("Ny ansattnummer: ");
            int ny_ansatt_nummer = in.nextInt();
            arbeids_info.setAnsattnummer(ny_ansatt_nummer);
            System.out.println("Nåværende ansattnummer: " + arbeids_info.hent_ansatt_nummer());
            vis_meny(arbeids_info);
            break;

            case 4:
            printText(arbeids_info);
            vis_meny(arbeids_info);
            break;

            case 5:
            System.out.println("Avbryter");
            System.exit(0);
            break;

            default:
            System.out.println("Input må være mellom 1-4");
            vis_meny(arbeids_info);
            break;
        }
        }
/** 
After taking inputs on the switch case, it prints the info once again
This makes the whole program loop
*/
public static void printText(Arbeids_info arbeids_info) {
    System.out.println(arbeids_info);
}




}