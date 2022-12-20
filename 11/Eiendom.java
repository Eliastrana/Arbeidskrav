/**
 * Klassen som inneholder Eiendom
 * Det er denne som brukes av kommune klassen
 */

public class Eiendom {

    private final int kommuneNummer;
    private final String kommuneNavn;
    private final int gardsNummer;
    private final int bruksNummer;
    private final String bruksNavn;
    private double areal;
    private String eier;

    /**
     * Etablerer eiendom, med alle verdiene som tilhører
     * @param kommuneNummer
     * @param kommuneNavn
     * @param gardsNummer
     * @param bruksNummer
     * @param bruksNavn
     * @param areal
     * @param eier
     */

    public Eiendom(int kommuneNummer, String kommuneNavn, int gardsNummer, int bruksNummer, String bruksNavn, double areal, String eier){

        this.kommuneNummer = kommuneNummer;
        this.kommuneNavn = kommuneNavn;
        this.gardsNummer = gardsNummer;
        this.bruksNummer = bruksNummer;
        this.bruksNavn = bruksNavn;
        this.areal = areal;
        this.eier = eier;
    }

 
    /**
     * Returnerer kommunenummer 
     * @return
     */
    public int getKommuneNummer(){
        return kommuneNummer;
    }
    /**
     * Returnerer kommunenavn
     * @return
     */

    public String getKommuneNavn(){
        return kommuneNavn;
    }
    /**
     * Returnerer gårdsnummer
     * @return
     */
    public int getGardsNummer(){
        return gardsNummer;
    }
    /**
     * Returnerer bruksnummer
     * @return
     */
    public int getBruksNummer(){
        return bruksNummer;
    }
    /**
     * returnerer bruksnavn
     * @return
     */
    public String getBruksNavn(){
        return bruksNavn;
    }
    /**
     * Returnerer arealet
     * @return
     */
    public double getAreal(){
        return areal;
    }
    /**
     * Returnerer eier
     * @return
     */
    public String getEier(){
        return eier;
    }
    /**
     * Returnerer nyEier
     * @param nyEier
     */
    public void setEier(String nyEier) {
        this.eier = nyEier;
    }
    /**
     * Returnerer nyAreal
     * @param nyAreal
     */
    public void setAreal(double nyAreal){
        this.areal = nyAreal;
    }
    /**
     * returnerer eiendomsidentifiseringen
     * @return
     */
    public String getEiendomIdentifikasjon(){
        return this.getKommuneNummer() + "-" + this.getGardsNummer() + "/" + this.getBruksNummer();
    }

    /**
     * toString som formaterer og printer alle verdiene som er ønsket
     */
    public String toString(){
        return "Kommunenr-gnr/brn: " + this.getKommuneNummer() + "-" + this.getGardsNummer() + "/" + this.getBruksNummer()
        +"| Kommunenavn: "+ this.getKommuneNavn()  + "| Bruksnavn: "+  this.getBruksNavn() +"| Areal: "+ this.getAreal() +" m^2" +"| Eier: "+ this.getEier()+"\n";
    }    
}