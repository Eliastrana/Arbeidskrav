import java.util.*;

public class Kjokken{

    private ArrayList<Matrett>matretter;
    private ArrayList<Meny>menyer;

    public Kjokken(){
        matretter = new ArrayList<Matrett>();
        menyer = new ArrayList<Meny>();    
    }

    public ArrayList<Meny> hentMenyer(){
        return menyer;
    }

    public ArrayList<Matrett> hentMatretter(){
        return matretter;
    }

    public Matrett nyMatrett(String navn, String matrettType, String oppskrift, double pris){
      Matrett nyMatrett = new Matrett(navn, matrettType, oppskrift, pris);
      matretter.add(nyMatrett);
      return nyMatrett;  
    }

    public ArrayList<Matrett> hentRettViaNavn(String navn){
        ArrayList<Matrett> matrettNavn = new ArrayList<Matrett>();
        for (int i = 0; i < hentMatretter().size(); i++){
            if(hentMatretter().get(i).hentNavn().toLowerCase().equals(navn.toLowerCase())){
                matrettNavn.add(hentMatretter().get(i));
            }
        }
        return matrettNavn;
    }

    public ArrayList<Matrett> hentRettViaRettType(String matrettType){
        ArrayList<Matrett> rettType = new ArrayList<Matrett>();
        for (int i = 0; i < hentMatretter().size(); i++){
            if(hentMatretter().get(i).hentMatrettType().toLowerCase().equals(matrettType.toLowerCase())){
                rettType.add(hentMatretter().get(i));
            }
        }
        return rettType;
    }

    public Meny nyMeny(ArrayList<Matrett> menyRetter){
        Meny nyMeny = new Meny(menyRetter);
        hentMenyer().add(nyMeny);
        return nyMeny;
    }

    public ArrayList<Meny> hentMenyGjennomPrisIntervall(double min, double max) {
        ArrayList<Meny> menyPrisIntervall = new ArrayList<Meny>(); // creates new arraylist to hold objects found within price range
        for (int i = 0; i < hentMenyer().size(); i++) { // iterates through size of arraylist menus
            if (hentMenyer().get(i).hentTotalPris() >= min && hentMenyer().get(i).hentTotalPris() <= max) { // if totalprice is greater than or equal to min value, and lower than or equal to max value
                menyPrisIntervall.add(hentMenyer().get(i)); // then that menu gets added to arraylist menuPriceRange
            }
        } 
        return menyPrisIntervall; // returns new arraylist
    }

    public void matrettDump(){
        nyMatrett("Brød", "Forrett", "Stek dem", 100);
        nyMatrett("Pasta", "Hovedrett", "Kok dem", 150);
        nyMatrett("Is", "Dessert", "frys dem", 80);
        nyMatrett("Mellombar", "Dessert", "Spis den", 20);
    }   
}