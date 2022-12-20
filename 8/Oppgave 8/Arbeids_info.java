import java.util.*;

public class Arbeids_info {

    /**
     * Establishes the different values and their format(int or double)
     */

    private final Person_info personalia;
    private int ansatt_nummer;
    private final int ansettelses_aar;
    private double moneds_lonn;
    private double skatte_prosent;
    GregorianCalendar kalender = new GregorianCalendar();

    /**
     * 
     * @param personalia
     * @param ansatt_nummer
     * @param ansettelses_aar
     * @param moneds_lonn
     * @param skatte_prosent
     * 
     * Creates the method with the different values within it
     */
    public Arbeids_info(Person_info personalia, int ansatt_nummer, int ansettelses_aar, double moneds_lonn, double skatte_prosent) {
        this.personalia = personalia;
        this.ansatt_nummer=ansatt_nummer;
        this.ansettelses_aar=ansettelses_aar;
        this.moneds_lonn=moneds_lonn;
        this.skatte_prosent=skatte_prosent;
    }

    /**
     * creates a modified value that collects the different values, 
     * and then returns it with the same name as the original
     * @return
     * 
     * 
     */

    
    public Person_info hent_personalia(){
        return personalia;
    }

    public int hent_ansatt_nummer(){
        return ansatt_nummer;
    }

    public int hent_ansettelses_aar(){
        return ansettelses_aar;
    }

    public double hent_moneds_lonn(){
        return moneds_lonn;
    }

    public double hent_skatte_prosent(){
        return skatte_prosent;
    }

    //ENDRINGER I VERDIENE

    public void setMoneds_lonn(double ny_Moneds_lonn){
        this.moneds_lonn = ny_Moneds_lonn;
    }

    public void setSkatteprosent(double ny_Skatteprosent){
        this.skatte_prosent = ny_Skatteprosent;
    }

    public void setAnsattnummer(int ny_ansatt_nummer){
        this.ansatt_nummer = ny_ansatt_nummer;
    }

    /**
     * Set values that are able to be changed ^
     * @return
     */


    /**
     * The different calculations based on the different values that are given by the user
     * @return
     */
    public double hent_skatte_innbetaling(){
        double skatte_innbetaling = moneds_lonn * (skatte_prosent / 100);
        return skatte_innbetaling;
    }

    /**
     * takes the netto_moneds_lonn and removes the tax amound from the total month salary 
     * @return
     */
    public double hent_netto_moneds_lonn(){
       hent_moneds_lonn();
       hent_skatte_innbetaling();
       double netto_moneds_lonn = moneds_lonn - hent_skatte_innbetaling();
       return netto_moneds_lonn;
    }
    
    /**
     * Multiplies the moneds_lonn by the 12 months in the year, to get the gross year salary 
     * @return
     */
    public double hent_gross_ars_lønn(){
        hent_moneds_lonn();
        double ars_lonn = moneds_lonn * 12;
        return ars_lonn;
    }
    /**
     * Gets the net year salary by finding the gross yearly salary and subtracting the yearly tax amount
     * @return
     */

    public double hent_netto_ars_lonn(){
        double ars_lonn = (moneds_lonn * 12) - this.hent_arlig_skattebetaling();
        return ars_lonn;
    }
    /**
     * Antall måneder blir 10 + 0,5 siden juni er fri og desember er halv
     * 
     * @return
     */
    
    public double hent_arlig_skattebetaling(){
        double arlig_skattebetaling = (this.hent_skatte_innbetaling() * 10) + (this.hent_skatte_innbetaling() * 0.5);
        return arlig_skattebetaling;
    }

    /**
     * Adds the last name with the first name to give it a proffesional look 
     * @return
     */

    public String hent_fult_navn(){
        String fult_navn = this.hent_personalia().hent_etternavn() + ", " + this.hent_personalia().hent_fornavn();
        return fult_navn;
    }

    /**
     * Uses the java calendar to find out the current year
     * Find the age by taking the current year and subtracting the birth year
     * @return
     */
    public int hent_alder(){
        int aktuelle_aar = kalender.get(java.util.Calendar.YEAR);
        int alder = aktuelle_aar - this.hent_personalia().hent_fodsels_aar();
        return alder;
    }

    /**
     * Current year - the year the person got hired 
     * @return
     */
    public int hent_antall_aar_ansatt(){
        int aktuelle_aar = kalender.get(java.util.Calendar.YEAR);
        int antall_aar_ansatt = aktuelle_aar - this.hent_ansettelses_aar();
        return antall_aar_ansatt;
    }

    /**
     * Boolean that checks if the worker has worked more than five years, returns a "true" og "false"
     * @param aar
     * @return
     */

    public boolean hent_ansatt_lengre_enn(int aar){
        boolean lengre_enn = false;
        if(this.hent_antall_aar_ansatt()>= aar){
            lengre_enn = true;
        }
        if(lengre_enn){
            System.out.println(" Ja");
        }
        return lengre_enn;
    }           

    /**
     * This is the value that is printet at the end, all based on the input given by the user
     * returns the value given to it in string format
     */
    public String toString(){
        return 
            "\n Personinformasjon: " +
            "\n Navn: " + hent_fult_navn() + 
            "\n Alder: " + hent_alder()+" år"+
            "\n Ansattnummer: " + hent_ansatt_nummer() +
            "\n Måntlig lønn: " + hent_moneds_lonn()+ " kr" +
            "\n Årlig lønn: " + hent_gross_ars_lønn() + " kr" +
            "\n Skatt betalt per måned: " + hent_skatte_innbetaling()+ " kr" +
            "\n Årlig skatteinnbetaling: " + hent_arlig_skattebetaling()+ " kr" +
            "\n Årlig nettolønn: " + hent_netto_ars_lonn() + " kr" +
            "\n År ansatt: " + hent_antall_aar_ansatt() + " år"+
            "\n Vært ansatt mer enn 5 år? Svar: " + hent_ansatt_lengre_enn(5);
    }



}