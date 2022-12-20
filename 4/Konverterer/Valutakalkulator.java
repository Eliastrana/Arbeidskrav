//Import utility
import java.util.*;
//Create a public class
public class Valutakalkulator {
    public static void main(String[]args) {
        //Establishes input from user
        Scanner in = new Scanner(System.in);
        
        //Prints convertion choice, or cancel choice
        System.out.println("Trykk på 1 for å konvertere fra NOK");
        System.out.println("Trykk på 2 for å konvertere til NOK");
        System.out.println("Trykk på 3 for å avslutte");;

        //Establishing the currenct value of the currency 
        Valutakonverterer USD = new Valutakonverterer(10.02f);
        Valutakonverterer EUR = new Valutakonverterer(10.03f);
        Valutakonverterer GBP = new Valutakonverterer(11.55f);

        //reading the input earlier
        int velg_konverterings_vei = in.nextInt();
        //Cancel program if choice is 3
        if (velg_konverterings_vei == 3) {
            System.out.println("Avbryter");
            System.exit(0);
        }
        //Cancel program if choice is not 1 or 2, as those are the only real options
        if (velg_konverterings_vei != 1 && velg_konverterings_vei != 2) {
            System.out.println("Ugyldig valg, velg mellom 1-3.");
            System.exit(0);
        } 
        //Creates a while loop that allows to switch between the different currencies 
        while (velg_konverterings_vei !=3)  {
            switch (velg_konverterings_vei) {
                case 1:
                //Takes another input from user, to choose the currency
                Scanner sc = new Scanner(System.in);
                //Chooses the input
                System.out.println("Trykk 1 for å konvertere til USD");
                System.out.println("Trykk 2 for å konvertere til EUR");
                System.out.println("Trykk 3 for å konvertere til GBP");
                System.out.println("Trykk 4 for å avbryte.");
                //Turns the next input into the velgvaluta variable
                int velgvaluta = sc.nextInt();
                switch (velgvaluta) {
                    //Creating different situations. Case 1 and 2 is for the different conversion way
                    //Case 1-4 inside of those are for the different values and the cancel
                    case 1: 
                    Scanner mengde1 = new Scanner(System.in);
                    System.out.println("Hvor mye NOK ønsker du å konvertere til USD?");
                    //Takes input and creates a total, using the second program that creates a public float
                    //The public float devides or multiplies based on if it is fraNok or tilNok
                    int verdi1 = mengde1.nextInt();
                    float totalsum1= USD.fraNok(verdi1);
                    //Prints the result
                    System.out.println(verdi1 + " NOK i USD er: " + totalsum1 + "\n");
                    //This breaks the active loop while and goes back to the first choice
                    break;
                    
                    case 2: 
                    Scanner mengde2 = new Scanner(System.in);
                    System.out.println("Hvor mye NOK ønsker du å konvertere til EUR?");

                    int verdi2 = mengde2.nextInt();
                    float totalsum2= EUR.fraNok(verdi2);

                    System.out.println(verdi2 + "NOK i EUR er: " + totalsum2 + "\n");

                    break;

                    case 3: 
                    Scanner mengde3 = new Scanner(System.in);
                    System.out.println("Hvor mye NOK ønsker du å konvertere til GBP?");

                    int verdi3 = mengde3.nextInt();
                    float totalsum3= GBP.fraNok(verdi3);

                    System.out.println(verdi3 + "NOK i GBP er: " + totalsum3 + "\n");

                    break;

                    case 4:
                    System.out.println("Avbryter.");
                    System.exit(0);

                    break;
                    //This is what is run if none of the above is reached
                    default:
                    System.out.println("Ugyldig sum. Kjør programmet på nytt og prøv igjen.");
                    System.exit(0);
                    //Breaks the internal case
                    break;

                }
                //Breaks the external case
                break;
                //This does the exact same as the first part except the other way
                case 2:
                Scanner st = new Scanner(System.in);
                System.out.println("Trykk 1 for å konvertere fra USD");
                System.out.println("Trykk 2 for å konvertere fra EUR");
                System.out.println("Trykk 3 for å konvertere fra GBP");
                System.out.println("Trykk 4 for å avbryte.");
                    
                int velgvaluta2 = st.nextInt();
                switch (velgvaluta2) {

                    case 1:
                    Scanner mengde1 = new Scanner(System.in);
                    System.out.println("Hvor mye USD ønsker du å konvertere til NOK?");

                    int verdi1 = mengde1.nextInt();
                    float totalsum1 = USD.tilNok(verdi1);

                    System.out.println(verdi1 + " USD i NOK er: " + totalsum1 + "\n");
                    break;

                    case 2: 
                    Scanner mengde2 = new Scanner(System.in);
                    System.out.println("Hvor mye EUR ønsker du å konvertere til NOK?");

                    int verdi2 = mengde2.nextInt();
                    float totalsum2 = EUR.tilNok(verdi2);

                    System.out.println(verdi2 + " EUR i NOK er: " + totalsum2 + "\n");


                    case 3: 
                    Scanner mengde3 = new Scanner(System.in);
                    System.out.println("Hvor mye GBP ønsker du å konvertere til NOK?");

                    int verdi3 = mengde3.nextInt();
                    float totalsum3 = GBP.tilNok(verdi3);

                    System.out.println(verdi3 + " GBP i NOK er: " + totalsum3 + "\n");
                    break;

                    case 4:
                    
                    System.out.println("Avbryter.");
                    System.exit(0);
                    break;

                    default:
                    System.out.println("Ugyldig sum. Kjør programmet på nytt og prøv igjen.");
                    System.exit(0);
                    break;
                }
                break;

                }
                //After the while loop is broken, it goes to this
                //This allows the user to again go back to the start 
                //If the input is 1 or 2 the program runs the cases 
                in.reset();
                System.out.println("Trykk 1 for å konvertere fra NOK");
                System.out.println("Trykk 2 for å konvertere til NOK");
                System.out.println("Trykk 3 for å avbryte");

                velg_konverterings_vei = in.nextInt();

              

                
                //Cancels if the input is 3
                if (velg_konverterings_vei ==3) {
                    System.out.println("Avbryter");
                    System.exit(0);

                    }
                //Tells the user that the input is wrong and to rerun the program
                if (velg_konverterings_vei !=1 && velg_konverterings_vei !=2) {
                    System.out.println("Ugyldig sum. Kjør programmet på nytt og prøv igjen.");
                    System.exit(0);
                }
                //closes the in function 
        }
        in.close();

    }

}





    





