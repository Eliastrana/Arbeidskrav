import java.util.*;

public class Tekstmanipulasjon {

    /**
     * Establishes text
     * this.text = word ensures that it is the current iteration that is used
     * newText has "" as it is empty until it is filled with the first letters of each word
     * charAt returns a letter from a word, the 0 collects the first letter in each word
     * 
     */
    private final String text;


    public Tekstmanipulasjon(String word) {
        this.text = word;
    }

    public String shorten() {
        String newText = "";
        String original = this.text;
        String[] word = original.split(" ");

        for (int i = 0; i <word.length; i++) {
            newText +=word[i].charAt(0);
        }
        return newText;
    }

    /**
     *indexOf finds the first value within and returns -1 if nothing is found
     *while loop keeps running as long as it keeps getting values
     *It then swaps the first word with a new word
     *returns the newText with the changed word 
     */

    public String remove(char t) {
        String original = this.text;
        String newText = original;
        while(newText.indexOf(t) > -1) {
            newText = newText.substring(0, newText.indexOf(t)) + newText.substring(newText.indexOf(t)+1);
        }
        return newText;
    }

}