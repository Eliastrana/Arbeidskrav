//Importing java utility 
import java.util.*;
//Establishing public class 
public class Terning {

    public static void main(String[] args) {
    //Creates the variable that asks the player if you want to run the game 
    spill_oppfordring();

    }

    //Creates a dedicated function for the game itself 
    public static void spill_oppfordring() {
    
    //Prints the options for the user 
        System.out.println("Ønsker du å spille terningspillet?");
        System.out.println("1 = Ja");
        System.out.println("2 = Nei");

    //Establishes the input from the user
        Scanner in = new Scanner(System.in);
        int svar = in.nextInt();

    //Either it begins the program, or it doesnt. Or it tells you that you gave an invalid input 
        if(svar == 1) {
            begynn_terningkast();
        } else if (svar == 2) {

            System.out.println("Neivell ;-(");
            System.exit(0);

        } else {
            System.out.println("Du kan bare skrive 1 eller 2");
            spill_oppfordring();
        }
    }   

    /**
     * Establishing the game itself 
     */
    public static void begynn_terningkast() {

        //Creates the two different players that will be given the sums of the dice-trows.
        Poengutregning[] spiller = new Poengutregning[2];
        spiller[0] = new Poengutregning(0);
        spiller[1] = new Poengutregning(0);
    
        //Statrs the round on 1, as a round 0 sounds stupid 
        int rundenummer = 1;

        //While spiller 0(1) and spiller 1(2) is false, keep the loop active
        while(!spiller[0].done(spiller[0].motta_poeng()) && !spiller[1].done(spiller[1].motta_poeng())) {

            
            //Takes the values given by the other file and ads it to the total spiller-value
            //This value is stored in the spiller.motta_poeng value 
            spiller[0].definer_poeng(spiller[0].kast_terning(spiller[0].motta_poeng()));
            spiller[1].definer_poeng(spiller[1].kast_terning(spiller[1].motta_poeng()));

            //Prints the while as until the totla sum is reached above 100
            System.out.println("Runde: " + rundenummer + ", spiller 1: " + spiller[0].motta_poeng() + ", spiller 2: " + spiller[1].motta_poeng());
            
            //Ads one number to the rundenummer so that it will keep adding as it prints results
            rundenummer += 1;

        } 
        //If spiller 1 reaches above 100 points first, print that that is the winner
        //If spiller 1 is not the one to reach it first, it prints that spiller 2 is the winner
        if(spiller[0].done(spiller[0].motta_poeng()) == true) {
            System.out.println ("Vinneren er spiller 1!");

            } 
            
            else {

            System.out.println ("Vinneren er spiller 2!");
            }
        //if loop done


        //Asks the user to play the game again 
        System.out.println ("Ønsker du å spille igjen, trykk på 1!");
        System.out.println ("Ønsker du å avslutte, trykk på 2!");

        //Takes input again 
        Scanner in = new Scanner(System.in);
        int gjennta = in.nextInt();

        //If yes(1), then start the terningkast function again, if not the close the program
        //If 1 or 2 is not pressed, run the ask again 
        if(gjennta == 1) {
            begynn_terningkast();
        }
 
            else if (gjennta == 2) {
        
                System.out.println("Avslutter programmet...");
                    System.exit(0);
                } else {
            
                System.out.println("Du har gitt et ugyldig input. Du må velge enten 1 eller 2.");
                    spill_oppfordring(); 

                }



        }   

}