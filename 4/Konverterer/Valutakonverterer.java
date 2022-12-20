
//Public class with the same name as the valuta in the first program
public class Valutakonverterer { 
    
    private final float kurs;
    //Creates a public float that establishes the kurs 
    public Valutakonverterer(float kurs) {
        this.kurs = kurs;
    }
    //If the case that converts to NOK is chosen, it will take the sum and mulutply it with the kurs
    public float tilNok(float sum) {
        return sum * kurs;
    }
    //If the case that converts to NOK is chosen, it will take the sum and devide it with the kurs
    public float fraNok(float sum) {
        return sum / kurs;

    }

}

//Returns both sums and allows the original program to use it and print it out if it is chosen