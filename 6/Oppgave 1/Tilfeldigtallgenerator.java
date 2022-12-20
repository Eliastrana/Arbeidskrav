import java.util.*;
/**
 * Creates public class
 * Creates main string
 * Creates random
 * creates round amount: 1000
 * creates for loop that goes from 0-9(total 10 prints)
 */
public class Tilfeldigtallgenerator {
    public static void main(String[]args) {

        Random random = new Random();
        int runder = 10000;
        int antall_tall = 10;
        int[] antall = new int[antall_tall];

        for (int i = 0; i < runder; i++){
            int tilfeldig_tall = random.nextInt(antall_tall);
            antall[tilfeldig_tall]++;
        }
        /**
         * prints how many times the numbers were printet within the total number (5000);
         */
        
        for (int i=0; i<antall_tall; i++) {
            int total_sum = antall[i];
            System.out.println("Tallet " + i +" forekom: " + total_sum);

        }
    }
}
