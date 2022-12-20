//Import the random utility
import java.util.Random;
//Public class with the same name as the file
public class Poengutregning {

    //Establishes the random function
    private Random terning = new Random();
    private int totalpoeng;

//Creates the public function of Poengutregning
    public Poengutregning(int poeng) {
    totalpoeng = poeng;

    }
//Creates the public integer motta_poeng
    public int motta_poeng() {
        return totalpoeng;

    }

//refers to the current object with .this
    public void definer_poeng(int totalpoeng) {
        this.totalpoeng = totalpoeng;
    }

//Simulates the terningkast
    public int kast_terning(int poeng) {
        int nySum;

//Gives it the max sum of 6, but add a 1 in the beggining because ints starts at 0
        int t = terning.nextInt(6) + 1;

//If it gets a one, it changes the total score to 0
    if(t==1) {
        nySum = 0;
    } else {
        nySum = poeng + t;
    }

    return nySum;
    }
//Creates a true of false function 
    public static boolean done(int poeng) {
    
    //If the points surpass or equal to 100, the program is supposed to print who the winner is
        if(poeng >= 100){
            return true;
        }

    //If it doesnt reach 100, it keeps going 
        else {
            return false;
        }


    }

}




