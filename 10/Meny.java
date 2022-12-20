
import java.util.*;


public class Meny{

    private ArrayList<Matrett> menyRetter;

    public Meny(ArrayList<Matrett> menyRetter){
        this.menyRetter = menyRetter;
    }

    public ArrayList<Matrett> hentMenyRetter(){
        return menyRetter;
    }

    public double hentTotalPris(){
        double pris = 0;
        for (int i = 0; i< menyRetter.size(); i++){
            pris = pris + hentMenyRetter().get(i).hentPris();
    
        }
        return pris;
    }


    public String toString(){
        String menyRetter = "";
        for (int i = 0; i <hentMenyRetter().size(); i++){
            if(i != 0){
            menyRetter = menyRetter + ", ";
        }
        menyRetter = menyRetter + hentMenyRetter().get(i).toString2();
    }
    menyRetter = menyRetter + "\nTotal pris: " + hentTotalPris();
    return menyRetter;
}
}