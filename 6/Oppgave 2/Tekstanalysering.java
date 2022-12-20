import java.util.*;

class Tekstanalystering {
/**
 *While loop that does looping 
 */
public static void main(String[]args) {
        while (true) {
        start();
        }
}

/**
 * Scanner, and asks for input
 * import Analyse, the other file with the calculations
 */
public static void start() {
    Scanner in = new Scanner(System.in);
    System.out.println("\n");
    System.out.println("Venligst skriv inn teksten ønsker du å analysere:");
    String input = in.nextLine();
    Analyse analyse = new Analyse(input);
    analyser(analyse);
}

/**
 * Prints the different value by grabbing the public variables from the Analyse file
 */
public static void analyser(Analyse analyse) {
    System.out.println("\n");
    System.out.println("Totalt antall bokstaver: " + Analyse.hent_antall_bokstaver());
    System.out.println("Antall unike bokstaver: " + Analyse.ulike_bokstaver());
    System.out.println("Andel ikke bokstaver(eks. tegn og mellomrom): " + Analyse.prosentandell_ikkebokstav() + "%");
    System.out.println(Analyse.flest_tilfeller());
    System.out.println("Du kan gjerne jobbe litt mer med setningsoppbyggingen din 😅");

}
}
    

