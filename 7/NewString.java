import java.util.*;

 class NewString {

    final String text;
    static Scanner in = new Scanner(System.in);

    public NewString(String word) {
        this.text = word; 
    }

    /**
     * keep running the showTextInput until the System.exit(0);
     * Takes input from user in String format
     * returns the value input as input
     * Gives the user choice
     */

    public static void main(String[] args) {
        String input = textInput();
        while(true) {
            showTextInput(input);
        }
    }

    public static String textInput(){
        System.out.println("Enter your text: ");
        String input = in.nextLine();

        return input;
    }

    public static void showTextInput(String input){


        System.out.println("Press 1: Shorten text");
        System.out.println("Press 2: Remove a letter");
        System.out.println("Press 3: Exit");
        int menuInput = in.nextInt();

        /**
         * Establishes the file that does the calculations 
         * Creates switchcase
         * Based on input, prints the result 
         * The result uses the calculations from the Tekstmanipulasjon file
         */
               
        Tekstmanipulasjon tekstmanipulasjon = new Tekstmanipulasjon(input);

            switch(menuInput) {
          
            case 1: System.out.println(tekstmanipulasjon.shorten());
                    break;

            case 2: System.out.println("Enter the letter you want to remove:");
                    char letter = in.next().charAt(0);
                    System.out.println(tekstmanipulasjon.remove(letter));
                    break;

            case 3: System.out.println("Exiting the program");
                    System.exit(0);

            default: System.out.println("INVALID INPUT: Enter 1, 2 or 3");
                     showTextInput(input);
                     break;
            

            
           }

        
    }

}

