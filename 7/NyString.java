import java.util.*;

 class NyString {

    private static String text;
    private static Scanner in = new Scanner(System.in);

    public NyString shorten() {
        String newText = "";
        String original = this.text;
        String[] word = original.split(" ");

        for (int i = 0; i <word.length; i++) {
            newText +=word[i].charAt(0);
        }
        return newText;
    }

    private String remove(char t) {
        String original = this.text;
        String newText = original;
        while(newText.indexOf(t) > -1) {
            newText = newText.substring(0, newText.indexOf(t)) + newText.substring(newText.indexOf(t)+1);
        }
        return newText;
    }

    public static void main(String[] args) {
        while(true) {
            showMenu();
        }
    }

    public static void showMenu(){
        System.out.println("Enter your text: ");
        String input = in.nextLine();
        nyString a = new nyString(input);
        System.out.println("Press 1: Shorten text");
        System.out.println("Press 2: Remove a letter");

        int menuInput = in.nextInt();
        switch(menuInput) {
            case 1: System.out.println(a.shorten());
            break;

            case 2: System.out.println("Enter the letter you want to remover:");
                    char letter = in.next().charAt(0);
                    System.out.println(a.remove(letter));
                    break;

            default: System.out.println("INVALID INPUT: Enter 1 or 2");
                    showMenu();
                    break;
        }
    }
}

