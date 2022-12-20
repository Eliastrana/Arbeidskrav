import java.util.*;

class Word {

    
    private static Scanner in = new Scanner(System.in);
    
   
    public static void main(String[]args) {
        inputText();
    }

    public static void inputText() {
        System.out.println("Enter your text: ");
        String input =in.nextLine();

        showMenu(input);
    }

    public static void showMenu(String a) {
        System.out.println("\n");
        System.out.println("1: Show statistics");
        System.out.println("2: Swap one word with another");
        System.out.println("3: Make all letters BIG");
        System.out.println("4: See your text");
        System.out.println("5: Cancel program");

        int menuInput = in.nextInt();

        Wordfunctions wordfunctions = new Wordfunctions(a);
        switch(menuInput) {

            case 1: System.out.println("Amount of words: " + wordfunctions.getWordAmount());
                    System.out.println("Avarage wordlength: " + wordfunctions.wordAmount() + " words");
                    System.out.println("Avarage amount of words per period: " + wordfunctions.periods().length + " words \n");
                    showMenu(a);
                    break;

            case 2: System.out.println("Enter the word you want to swap: "); 
                    String words1 = in.next();
                    System.out.println("Enter the new word: "); 
                    String words2 = in.next();
                    System.out.println("Your new sentence is: ");
                    System.out.println(wordfunctions.swap(words1, words2));
                    System.out.println("\n");
                    showMenu(a);
                    break;

            case 3: System.out.println(wordfunctions.large_text());
                    showMenu(a);
                    System.out.println("\n");
                    break;

            case 4: System.out.println(wordfunctions.lookAtString());
                    showMenu(a);
                    System.out.println("\n");
                    break;

            case 5: System.out.println("Canceling program");
                    System.exit(0);

            default:System.out.println("ERROR: Only input allowed 1-5");
                    showMenu(a);
                    System.out.println("\n");
                    break;
        }
    }
}