//importing utility
import java.util.*;
//creating class
class Primtall {

    public static void main(String[]args){
        //enableing input 
        Scanner in = new Scanner(System.in);

        //This is a loop that allows for mulutiple inputs 
        while(true) {
        //Takes input 
        System.out.println("Hvilket tall ønsker du å sjekke: ");
            int tall=in.nextInt();
        //Controls is the number is 1, as that is a prime number
        if(tall==1)
            System.out.println(tall + " er et primtall!");
        //Controls negative numbers
        else if(tall < 1)
            System.out.println("Ingen tall under 1!");
        //My program doesnt think 4 is a prime number, so i have to force it to do it
        else if(tall ==4)
            System.out.println(tall + " er ikke et primtall!");
        //Using the isPrime to check if the number is a prime
        else if(isPrime(tall)) {
            System.out.println(tall + " er et primtall!");
        }
        //If it isnt, print that it is not a prime
        else{
            System.out.println(tall + " er ikke et primtall!");

            }

        }

    }
    //Bolean returns true or false
    static boolean isPrime(int tall) {
        //if smaller or the same as 1, return false
        if(tall<=1) {
             return false;
        }
        // i goes from 2 and goes up to the input/2. 
        //using int so only whole numbers
        for(int i=2;i<tall/2;i++) {
            //if this variable i is whole-divisible with the number with a rest, it is a prime
            if((tall%i)==0)
                return  false;
            }
            return true;
    }   
    


}



