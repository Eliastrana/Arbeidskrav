import java.util.*;

/**
 * Klasse som gjør utregningene som kreves 
 * @author Elias
 */

public class Kommune{

    
    private ArrayList<Eiendom>eiendommer;

    /**
     * Etablerer kommune
     */

    public Kommune(){
        eiendommer = new ArrayList<Eiendom>();
    }
    /**
     * returnerer eiendommer
     * @return
     */

    public ArrayList<Eiendom>hentEiendom(){
        return eiendommer;
    }
    /**
     * returnerer eiendomstørrelse
     * @return
     */
    public int getEiendomSize() {
        return eiendommer.size();
    }

    /**
     * 
     * @param kommuneNummer
     * @param kommuneNavn
     * @param gardsNummer
     * @param bruksNummer
     * @param bruksNavn
     * @param areal
     * @param eier
     * @return
     * metoden som skaper en ny eiendom 
     */
    public Eiendom nyEiendom(int kommuneNummer, String kommuneNavn, int gardsNummer, int bruksNummer, String bruksNavn, double areal, String eier){
        Eiendom nyEiendom = new Eiendom(kommuneNummer, kommuneNavn, gardsNummer, bruksNummer, bruksNavn, areal, eier);
        eiendommer.add(nyEiendom);
        return nyEiendom;
    }

    /**
     * henter bruksnavn fra arrayListen
     * @param bruksNavn
     * @return
     */
    public ArrayList<Eiendom> bruksNavnSoker(String bruksNavn){
        ArrayList<Eiendom> navn = new ArrayList<Eiendom>();
        for (int i = 0; i < hentEiendom().size(); i++){
            if(hentEiendom().get(i).getBruksNavn().toLowerCase().equals(bruksNavn.toLowerCase())){
                navn.add(hentEiendom().get(i));
            }
        }
        return navn;
    }
    /**
     * henter gårdsnummer fra ArrayListen
     * @param gardsNummer
     * @return
     */
    public ArrayList<Eiendom> gardsNummerSoker(int gardsNummer){
        ArrayList<Eiendom> navn = new ArrayList<Eiendom>();
        for (int i = 0; i < hentEiendom().size(); i++){
            if(hentEiendom().get(i).getGardsNummer() == gardsNummer){
                navn.add(hentEiendom().get(i));
            }
        }
        return navn;
    }

    /**
     * henter kommunenummer via ArrayListen
     * @param kommuneNummer
     * @return
     */
    public ArrayList<Eiendom> kommuneNummerSoker(int kommuneNummer){
        ArrayList<Eiendom> navn = new ArrayList<Eiendom>();
        for (int i = 0; i < hentEiendom().size(); i++){
            if(hentEiendom().get(i).getKommuneNummer() == kommuneNummer){
                navn.add(hentEiendom().get(i));
            }
        }
        return navn;
    }
    /**
     * Henter bruksnummer via ArrayListen
     * @param bruksNummer
     * @return
     */
    public ArrayList<Eiendom> bruksNummerSoker(int bruksNummer){
        ArrayList<Eiendom> navn = new ArrayList<Eiendom>();
        for (int i = 0; i < hentEiendom().size(); i++){
            if(hentEiendom().get(i).getBruksNummer() == bruksNummer){
                navn.add(hentEiendom().get(i));
            }
        }
        return navn;
    }
    /**
     * finner eiendommen via de tre parametrene
     * @param kommuneNummer
     * @param gardsNummer
     * @param bruksNummer
     * @return
     */
    
    public String eiendomFinner(int kommuneNummer, int gardsNummer, int bruksNummer) {
        for (int i = 0; i < eiendommer.size(); i++) {
            if (eiendommer.get(i).getKommuneNummer() == kommuneNummer && eiendommer.get(i).getGardsNummer() == gardsNummer && eiendommer.get(i).getBruksNummer() == bruksNummer) {
                return eiendommer.get(i).toString();
            }
        }
        return "Fant ikke eiendommen";
    }
    
    /**
     * Klientfilen henter denne dumpen av info slik at registeret fylles 
     */
    public void eiendomsDump(){
        nyEiendom(1445, "Gloppen", 77, 631, "", 1017.6, "Jens Olsen");
        nyEiendom(1445, "Gloppen", 77, 131, "Syningom", 661.3, "Nicolay Madsen");
        nyEiendom(1445, "Gloppen", 75, 19, "Fugletun", 650.6, "Evilyn Jensen");
        nyEiendom(1445, "Gloppen", 74, 188, "", 1457.2, "Karl Ove Bråten");
        nyEiendom(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Elsa Indregård");
    }

    /**
     * henter totalareal og så deler på antall eiendommer
     * @return
     */
    public double hentGjennomsnittAreal(){
        double totalAreal = 0;
        double gjennomsnittAreal = 0;
        for (int i = 0; i< eiendommer.size(); i++){
            totalAreal = totalAreal + hentEiendom().get(i).getAreal();
        }
        gjennomsnittAreal = (totalAreal/eiendommer.size());
        return gjennomsnittAreal;
    }
    /**
     * Fjerner eiendommer basert på intervallene som blir spurt om
     * @param kommuneNummer
     * @param gardsNummer
     * @param bruksNummer
     */

    public void fjernEiendom(int kommuneNummer, int gardsNummer, int bruksNummer) {
        String eiendomsIdentifiserer = kommuneNummer + "-" + gardsNummer + "/" + bruksNummer;
        boolean eiendomFinnes = false;

        if (kommuneNummer < 0 || gardsNummer < 0 || bruksNummer < 0) {
            throw new IllegalArgumentException("Du må skrive positive verdier");
        } else {
            for (int i = 0; i < getEiendomSize(); i++) {
                if (eiendommer.get(i).getEiendomIdentifikasjon().equals(eiendomsIdentifiserer)) {
                    eiendomFinnes = true;
                    Eiendom eiendom = eiendommer.get(i);
                    eiendommer.remove(eiendom);
                    break;
                }
            }
            if (!eiendomFinnes) {
                throw new IllegalArgumentException("Eiendommen finnes ikke");
            }
        }
    }

    /**
    * en toString som returnerer det som alt i registeret 
    */
    
    public String toString() {
        String tekst = "";
        for (int i = 0; i < getEiendomSize(); i++) {
          tekst = tekst + eiendommer.get(i).toString();
        }
        return tekst;
    }
    
    /**
     * Skaper en nyEier som erstatter den originale eier
     * Her kan det brukes deep copy, men det blir på mappevurderingen 
     * @param kommuneNummer
     * @param gardsNummer
     * @param bruksNummer
     * @param nyEier
     */
    
    public void endreEier(int kommuneNummer, int gardsNummer, int bruksNummer, String nyEier) {
        String eiendomsIdentifiserer = kommuneNummer + "-" + gardsNummer + "/" + bruksNummer;
        boolean eiendomFinnes = false;

        if (kommuneNummer < 0 || gardsNummer < 0 || bruksNummer < 0) {
            throw new IllegalArgumentException("Verdiene må være positive");
        } else {
            for (int i = 0; i < getEiendomSize(); i++) {
                if (eiendommer.get(i).getEiendomIdentifikasjon().equals(eiendomsIdentifiserer)) {
                    eiendomFinnes = true;
                    eiendommer.get(i).setEier(nyEier);
                    break;
                }
            }
            if (!eiendomFinnes) {
                throw new IllegalArgumentException("Ingen eiendommer med din gitte identifisering ble funnet");
            }
        }
    }

      /**
     * Skaper en nyEier som erstatter den originale eier
     * Her kan det brukes deep copy, men det blir på mappevurderingen 
     * @param kommuneNummer
     * @param gardsNummer
     * @param bruksNummer
     * @param nyAreal
     */
    public void endreAreal(int kommuneNummer, int gardsNummer, int bruksNummer, double nyAreal) {
        String eiendomsIdentifiserer = kommuneNummer + "-" + gardsNummer + "/" + bruksNummer;
        boolean arealFinnes = false;

        if (kommuneNummer < 0 || gardsNummer < 0 || bruksNummer < 0) {
            throw new IllegalArgumentException("Verdiene må være positive");
        } else {
            for (int i = 0; i < getEiendomSize(); i++) {
                if (eiendommer.get(i).getEiendomIdentifikasjon().equals(eiendomsIdentifiserer)) {
                    arealFinnes = true;
                    eiendommer.get(i).setAreal(nyAreal);
                    break;
                }
            }
            if (!arealFinnes) {
                throw new IllegalArgumentException("Ingen eiendommer med din gitte identifisering ble funnet");
            }
        }
    }
}
