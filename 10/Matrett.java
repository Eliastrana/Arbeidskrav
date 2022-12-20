public class Matrett{

    private String navn, matrettType, oppskrift;
    private double pris;

    public Matrett(String navn, String matrettType, String oppskrift, double pris){
        this.navn = navn;
        this.matrettType = matrettType;
        this.oppskrift = oppskrift;
        this.pris = pris;
    }

    public String hentNavn(){
        return navn;
    }

    public String hentMatrettType(){
        return matrettType;
    }

    public String hentOppskrift(){
        return oppskrift;
    }

    public double hentPris() {
        return pris;
    }

    public String toString(){
        return "Navn: " + this.hentNavn() + "\n" +"Retttype: "+ this.hentMatrettType() + "\n"+"Oppskrift: " + this.hentOppskrift() +"\n"+ "Pris: "+ this.hentPris();
    }

    public String toString2(){
        return this.hentNavn() +": "+ this.hentPris()+ " |";
    }

}