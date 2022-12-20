import java.util.*;

class Wordfunctions {

    private String sentence;

    public Wordfunctions(String text) {
        this.sentence = text;
    }

    public int getWordAmount() {

    String[] words = sentence.split(" ");
    int wordAmount = words.length;
    int letters = 0;
    for (int i = 0; i<words.length; i++) {
        letters += words[i].length(); 
    }
    return letters/wordAmount;
    }

    public String[] periods() {
        String[] periods = sentence.split("[.!:?]+");

        return periods;
    }

    public int wordAmount(){
        String[] words = sentence.split(" ");

        int wordAmount = words.length;
        return wordAmount / periods().length;


    }

    public String swap(String words1, String words2) {
        String newSentence = sentence.replaceAll(words1, words2);
        return newSentence;
    }

    public String lookAtString() {
        return this.sentence;
    }

    public String large_text() {
        sentence = sentence.toUpperCase();
        return sentence;
    }


    
}