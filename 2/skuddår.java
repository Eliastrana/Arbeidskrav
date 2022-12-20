import java.util.*;
//Etablerer klasse
class skuddår {

public static void main(String[]args) {
    //Etablerer input fra bruker
    Scanner in = new Scanner(System.in);

System.out.println("Skriv inn årstall: ");
int year = in.nextInt();

//variabelen "oppdelt" er i dette tilfellet det som blir igjen etter en deler året som brukeren skriver inn med 100


//Her sier den at hvis det oppdelte året delt på 4 blir 0, så er det et skuddår
//Den sier også at hvis året er delelig på 400 så er det et skuddår   
if (year % 400 ==0)
    System.out.println(year + " er et skuddår");

else if (year % 100 ==0)
    System.out.println(year + " er ikke et skuddår");


else if (year % 4 ==0){
    System.out.println(year + " er et skuddår");
} 





    //Dette printer den hvis året som blir gitt ikke dekke noen av de 2 tidligere kravene

else {
    System.out.println(year + " er ikke et skuddår");
 
}

}

}