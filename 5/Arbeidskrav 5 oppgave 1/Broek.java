/**
 * Creating the ints for the teller and nevner to the first brøk
 * Puts these in the public function "Broek"
 * Creates if statement that removes the ability to input an illegal fraction
 * uses .this to confirm that the current value is the one to be used
 * The getTeller and getNevner are public so that the main file can use them
 */

public class Broek {

    private int teller1;
    private int nevner1;

    public Broek(int teller1, int nevner1) {
        if(nevner1 == 0) {

        throw new IllegalArgumentException("Brøker kan ikke ha 0 i nevneren! ");

        }

        this.teller1 = teller1;
        this.nevner1 = nevner1;

    }

    public Broek(int teller1) {

        this.teller1=teller1;
        this.nevner1= 1; //The nevner is being forced to be one until it is changed, as thats the smallest value it can be

    }

    public int getTeller() {
        return teller1;
    }

    public int getNevner() {
        return nevner1;

    }

    /**
     * Here the different math choices are calculated 
     * the division one uses the flip method to calculate the answers
     */

    public void addisjon(int teller2, int nevner2) {

        teller1 = (teller1 * nevner2) + (teller2 * nevner1);
        nevner1 = (nevner1 * nevner2);


    }

    public void subtraksjon(int teller2, int nevner2) {

        teller1 = (teller1 * nevner2) - (teller2 * nevner1);
        nevner1 = (nevner1 * nevner2);


    }

    public void multiplikasjon(int teller2, int nevner2) {

        teller1 *= teller2;
        nevner1 *= nevner2;


    }

    public void divisjon(int teller2, int nevner2) {

        teller1 *= nevner2;
        teller2 *= nevner1;


    }

}

