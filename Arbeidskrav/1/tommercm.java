import java.util.* ; 

class Konvertering {

    public static void main(String[]args) {
        //Etablerer muligheten for input fra bruker
        Scanner sc = new Scanner(System.in);
//Stiller spørsmål
System.out.println("Hvor mange tommer ønsker du å konvertere til cm? ");
//Her brukes double da det gir desimaltall i retur
double tommer = sc.nextInt();
//Regner ut brukerinput med koverteringssummen for tommer
double cm = tommer * 2.54;

//Printer resultat
System.out.println(tommer + " tommer er "+ cm + "cm");

}

}