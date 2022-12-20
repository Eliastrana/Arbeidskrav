import java.util.*;


/**
 * creates a scanner
 * Prints introduction message 
 * Creates a while loop that asks for input and then starts case 1 og 2, or canceles the program
 */

public class MyRandom {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[]args) {

        System.out.println("                ");
        System.out.println("Velkommen til tilfeldig-tall-generatoren!");
        System.out.println("Hvis du skriver et større tall på det første inputet crasher programmet🥹");
      
        while(true) {

            System.out.println("                ");

            System.out.println("Skriv inn ditt lave tall: ");
            double lav = in.nextDouble();
            System.out.println("Skriv inn ditt høyeste tall: ");
            double hoy = in.nextDouble();

        
            System.out.println("Ønsker du å printe et heltall eller et desimaltall?");
            System.out.println("1: Heltall\n2: Desimaltall\n3: Avbryt programmet");

            int menyValg= in.nextInt();

            if(menyValg == 3) {
                System.out.println("Avbryter programmet");
                System.exit(0);

            }

        /**
         * Case 1 and 2 are identical in structure 
         * Except the first case uses int and whole numebers, and the second uses double and desimal numbers
         * They ask for a lower and an upper limit, and then stores them as an input
         * Then it creates a random value between those inputs, and prints it 10 times 
         */
        switch(menyValg) {

            case 1: 

                System.out.println("Du har valgt heltall");

                System.out.println("Skriv inn ditt nedre tall: ");

                                        
                System.out.println("                ");
                System.out.print("Dine tilfeldige tall er: "+ "\n");
                System.out.println("                ");

                Random random = new Random();
                for(int i = 0; i < 10; i++) {

                System.out.print(random.nesteHeltall+ "\n");
                }
        }


        switch(menyValg) {

            case 2: 

                System.out.println("Du har valgt desimaltall");

                System.out.println("                ");
                System.out.print("Dine tilfeldige tall er: ");
                System.out.println("                ");

                for(int i = 0; i < 10; i++) {

                Random random = new Random();
                System.out.print(random.nextDouble(hoy-lav) + "\n");  

                }
        }


}

}

}