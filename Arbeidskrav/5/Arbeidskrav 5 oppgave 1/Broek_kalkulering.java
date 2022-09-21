/**
 * The import is used to allow for input-windows to be displayed
 */

import static javax.swing.JOptionPane.*;

/**
 * Creates integer that is stored as the input that is requested
 * This is asked in a showInputDialog
 * the function Broek is defined, and stores teller 1 and nevner 1
 * The try function allows the code to be tested for errors while it is being run
 * The catch function allows you to define a block of code to be executed, if an error occurs in the try block.
 */
public class Broek_kalkulering {
    public static void main(String[]args) {

        int teller1 = Integer.parseInt(showInputDialog("Skriv inn din teller: "));
        int nevner1 = Integer.parseInt(showInputDialog("Skriv inn din nevner: "));

        Broek broek = new Broek(teller1, nevner1);

        try {

        } catch (IllegalArgumentException invalid) {
            showMessageDialog(null, invalid);
        }


    /**
     * The while loop runs as long as it isnt broken
     * This allows the program to return to the choice of what calculation the user wants to use
     * The 5 is used to system.exit
     * If the input is between 1-4, it will run the different cases based on the input
     */

        while(true) {

            showMessageDialog(null, "Din nåværende brøk er: " + broek.getTeller()+ "/"+ broek.getNevner());
            int MenyValg = Integer.parseInt(showInputDialog("Hvilken matematisk utregning ønsker du å gjøre: \n 1. Addisjon \n 2. Subtraksjon \n 3. Multiplikasjon \n 4. Divisjon \n 5. Avbryt"));

            if(MenyValg == 5) {
                showMessageDialog(null, "Avbryter programmet");
                System.exit(0);
            }

                int teller2 = Integer.parseInt(showInputDialog("Skriv inn din andre teller"));
                int nevner2 = Integer.parseInt(showInputDialog("Skriv inn din andre nevner"));

            switch(MenyValg) {
                case 1:
                showMessageDialog(null, broek.getTeller() + "/" + broek.getNevner() + " + " + teller2 + "/" + nevner2 + " = ");
                broek.addisjon(teller2, nevner2);
                showMessageDialog(null, "Svar:\n" + broek.getTeller() + "/" + broek.getNevner());
                break;
            }

            switch(MenyValg) {
                case 2:
                showMessageDialog(null, broek.getTeller() + "/" + broek.getNevner() + " - " + teller2 + "/" + nevner2 + " = ");
                broek.subtraksjon(teller2, nevner2);
                showMessageDialog(null, "Svar:\n" + broek.getTeller() + "/" + broek.getNevner());
                break;
            }

            switch(MenyValg) {
                case 3:
                showMessageDialog(null, broek.getTeller() + "/" + broek.getNevner() + " * " + teller2 + "/" + nevner2 + " = ");
                broek.multiplikasjon(teller2, nevner2);
                showMessageDialog(null, "Svar:\n" + broek.getTeller() + "/" + broek.getNevner());
                break;
            }

            switch(MenyValg) {
                case 4:
                showMessageDialog(null, broek.getTeller() + "/" + broek.getNevner() + " / " + teller2 + "/" + nevner2 + " = ");
                broek.divisjon(teller2, nevner2);
                showMessageDialog(null, "Svar:\n" + broek.getTeller() + "/" + broek.getNevner());
                break;
            }

            switch(MenyValg) {
                case 5:
                showMessageDialog(null, "Avbryter");
                System.exit(0);
                break;
            }

            /**
             * Here the user is asked if they wish to continue
             * If they press 1, it will loop back to the top
             * If the input is above 2 or below 0, it is supposed to exit the program
             */

            int nyttMenyValg = Integer.parseInt(showInputDialog("Ønsker du å fortsette å regne brøk? \n 1. Ja \n 2. Nei"));
                if(nyttMenyValg == 2) {
                    System.exit(0);
                } else if (nyttMenyValg == 1) {
                    continue;
                } else {
                    showMessageDialog(null, "Ugyldig input :-(");
                    System.exit(0);

                }
            }
        }
}


