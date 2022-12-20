import java.util.*;

class Analyse {

    /**
     * add the alphabet
     * Create an analasys string 
     * a +1 until it reaches 30
    
     */

    private static int[] tegn_antall;
    private static String[] alfabet = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","æ","ø","å"};

    public Analyse(String input) {

        tegn_antall = new int[30];
        for (int a = 0; a < 30; a++) {
            tegn_antall[0]=0;   
        }
        /**
         * turns the input into lower case
         * establishes length, and creates a variable that +1 until it is the same as length
         * 
         */
        input = input.toLowerCase();
        int lengde = input.length();
        for (int p = 0; p < lengde; p++) {

            //Char functions as: from 0 to n-1
            //This means 30 goes from 0-29, the alphabet
            char indexChar = input.charAt(p);
            String bokstav = Character.toString((char)indexChar);
            int index = Arrays.asList(alfabet).indexOf(bokstav);
            
            //If indexOf doesnt find anything it becomes -1, this is then turned into 29
            if (index == -1) {

                index = 29;
            }

            tegn_antall[index] +=1;
        }
    }

    /**
     * This count the amount of different letters
     */
    public static int ulike_bokstaver(){
        int sum = 0;
        for (int i = 0; i <29; i++) {
            if (tegn_antall[i]>0) {
                sum++;
            }
        }
            return sum;

        }
    
    /**
     * Total amount of letters, here it is pluss sum instead of adding 1 to the sum
     */
    public static int hent_antall_bokstaver(){
            int sum = 0;
            for (int i = 0; i <29; i++) {
            sum = tegn_antall[i] + sum;
            }
                return sum;
            }    


    /**
     * Persent calculation of the total from hent_antall_bokstaver
     */
    public static double prosentandell_ikkebokstav(){

        int antall_bokstaver = hent_antall_bokstaver();
        int antall_ikkebokstav = tegn_antall[29];
        double total_antall = antall_bokstaver + antall_ikkebokstav;
        double prosent = (antall_ikkebokstav/total_antall)*100;
        prosent = Math.round(prosent * 100) / 100;
        return prosent; 
    }


    /**
     * Print the letter most used in the text, and how many times it was used
     */
    public static String flest_tilfeller(){

        int hoyest = -1;
        String hoyest_bokstav = "";
        for (int i = 0; i < 29; i++) {

        if(tegn_antall[i] > hoyest) {
            hoyest = tegn_antall[i]; 
            hoyest_bokstav = alfabet[i];
        } else if (tegn_antall[i] == hoyest) {
            hoyest_bokstav = (hoyest_bokstav + ", " + alfabet[i]);
        }
        }
        return "Bokstaven(e) som forekommer oftest er \"" + hoyest_bokstav + "\" (" + hoyest + " ganger)";
    }
}

