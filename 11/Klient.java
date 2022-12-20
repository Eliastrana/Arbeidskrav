import java.util.*;

/**
 * Denne klassen inneholder brukermenyen, samt metoder som henter 
 * input fra brukeren og kommununiserer med kommune-klassen
 */

public class Klient{

    /**
     * Main metode som sier velkommen, etablerer kommune klassen, 
     * fyller programmet med infoen, og looper brukermenyen
     * @param args
     */

    public static void main(String[]args){
        System.out.println("Velkommen til kommuneregister");
        Kommune k = new Kommune();
        fyllKommuneMedInfo(k);

        while(true){
            visBrukerMeny(k);
        }
    }
    /**
     * Fyller programmet med forhåndsinfo
     * @param k
     */

    public static void fyllKommuneMedInfo(Kommune k){
        k.eiendomsDump();
    }

    /**
     * Brukermenyen
     * Det er switch caser inni switchcaser som starter metoder lengre ned i filen
     * @param k
     */

    public static void visBrukerMeny(Kommune k){

        Scanner in = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("1: Registrer ny eiendom");
        System.out.println("2: Vis alle registerte eiendommer");
        System.out.println("3: Vis antall eiendommer");
        System.out.println("4: Søk etter eiendom");
        System.out.println("5: Regne ut gjennomsnittareal for alle eiendommer");
        System.out.println("6: Endre eier eller areal på en eiendom");
        System.out.println("7: Slett en eiendom");
        System.out.println("8: Avbryt programmet");
    

    int brukerMenyValg = in.nextInt();

    switch(brukerMenyValg){

        case 1: 
        nyEiendom(k);
        break;

        case 2:
        System.out.println(k.toString());
        break;

        case 3:
        hentStorrelse(k);
        break;

        case 4:
            System.out.println("Velg hva du ønker å søke etter: ");
            System.out.println("1: Via kommunenummer");
            System.out.println("2: Via gårdsnummer");
            System.out.println("3: Via bruksnummer");
            System.out.println("4. Via bruksnavn");
            System.out.println("5. Søk på alle 3 parameter (kommunenummer, gårdsnummer, bruksnummer):");

            int input = in.nextInt();
            switch(input){
                case 1: 
                hentKommuneNummer(k);
                break;

                case 2: 
                hentGardsNummer(k);
                break;

                case 3:
                hentBruksNummer(k);
                break;

                case 4:
                hentBruksNavn(k);
                break;

                case 5: 
                finnEiendom(k);
                break;

                default:
                System.out.println("Ugyldig input");
                visBrukerMeny(k);

            }
        break;

        case 5:
        System.out.println("Gjennomsnittsareal for alle eiendommer: ");
        System.out.println(k.hentGjennomsnittAreal()+ " m^2");   
        break;

        case 6:
        System.out.println("Velg hva du ønsker å redigere: ");
        System.out.println("1: Eier");
        System.out.println("2: Areal");
        int velgEndring = in.nextInt();

        switch(velgEndring){
            case 1:
            endreEier(k);
            break;
            case 2:
            endreAreal(k);
            break;
            default: visBrukerMeny(k);
        
        }
        break;

        case 7: 
        eiendomFjerner(k);
        break;

        case 8:
        System.out.println("Avbryter...");
        System.exit(0);
        break;

        default: visBrukerMeny(k);

        }
    }

    /**
     * Henter info for etablering av ny eiendom, bruker kommune for å skape den
     * @param k
     */
    private static void nyEiendom(Kommune k){
        Scanner in = new Scanner(System.in);
        System.out.println("Bruksnavn: ");
        String bruksNavn = in.nextLine();

        if (k.bruksNavnSoker(bruksNavn).size()> 0){
            System.out.println("Denne eiendommen finnes allerede!");
        } else {
            System.out.println("Kommunenummer: ");
            int kommuneNummer = in.nextInt();

            System.out.println("Kommunenavn: ");
            in.nextLine();
            String kommuneNavn = in.nextLine();

            System.out.println("Gårdsnummer: ");
            int gardsNummer = in.nextInt();
            
            System.out.println("Bruksnummer: ");
            int bruksNummer = in.nextInt();

            System.out.println("Areal: ");
            double areal = in.nextDouble();

            System.out.println("Eier: ");
            in.nextLine();
            String eier = in.nextLine();

            Eiendom nyEiendom = k.nyEiendom(kommuneNummer, kommuneNavn, gardsNummer, bruksNummer, bruksNavn, areal, eier);
            System.out.println("Den nye eiendommen har blitt registrert: ");
            System.out.println(nyEiendom.toString());
        }
    }

    /**
     * skaper ny eier med å finne identifikasonen, og så endre navnet 
     * @param k
     */

    public static void endreEier(Kommune k) {
        Scanner in = new Scanner(System.in);

        System.out.println("Kommunenummer:");
        int kommuneNummer = in.nextInt();
        System.out.println("Gårdsnummer:");
        int gardsNummer = in.nextInt();
        System.out.println("Bruksnummer:");
        int bruksNummer = in.nextInt();
        in.nextLine();
        System.out.println("Skriv inn navn på ny eier: ");
        String nyEier = in.nextLine();

        try {
            k.endreEier(kommuneNummer, gardsNummer, bruksNummer, nyEier);

            System.out.println("Eieren har blitt endret: ");
            System.out.println(k.toString());

        } catch (IllegalArgumentException e) {
            System.out.println("Fant ikke eiendommen du forsøker å redigere");
        }
    }

    /**
     * Endrer areal ved å spørre om identifisering og så endrer den arealet 
     * @param k
     */

    public static void endreAreal(Kommune k) {
        Scanner in = new Scanner(System.in);

        System.out.println("Kommunenummer:");
        int kommuneNummer = in.nextInt();
        System.out.println("Gårdsnummer:");
        int gardsNummer = in.nextInt();
        System.out.println("Bruksnummer:");
        int bruksNummer = in.nextInt();
        in.nextLine();
        System.out.println("Skriv inn nytt areal: ");
        double nyAreal = in.nextDouble();

        try {
            k.endreAreal(kommuneNummer, gardsNummer, bruksNummer, nyAreal);

            System.out.println("Arealet har blitt endret: ");
            System.out.println(k.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Fant ikke eiendommen du forsøker å redigere");
        }
    }
    
    /**
     * Henter størrelse via getEiendomSize
     * @param k
     */

    public static void hentStorrelse(Kommune k){
        System.out.println("Antall eiendommer: " + k.getEiendomSize());
    }

    /**
     * Sjekker om den er to, og hvis ikke så henter den kommunenummer
     * @param k
     */
    public static void hentKommuneNummer(Kommune k){
        Scanner in = new Scanner(System.in);
        System.out.println("Kommunenummer: ");
        int kommuneNummer = in.nextInt();

        if(k.kommuneNummerSoker(kommuneNummer).isEmpty()){
            System.out.println("Ingen "+ kommuneNummer + " ble funnet");
        } else
        System.out.println(k.kommuneNummerSoker(kommuneNummer));
        }
 /**
     * Sjekker om den er to, og hvis ikke så henter den gårdsnummer
     * @param k
     */

    public static void hentGardsNummer(Kommune k){
        Scanner in = new Scanner(System.in);
        System.out.println("Gårdsnummer: ");
        int gardsNummer = in.nextInt();

        if(k.gardsNummerSoker(gardsNummer).isEmpty()){
            System.out.println("Ingen "+ gardsNummer + " ble funnet");
        } else
        System.out.println(k.gardsNummerSoker(gardsNummer));
        }

 /**
     * Sjekker om den er to, og hvis ikke så henter den bruksnummer
     * @param k
     */
    public static void hentBruksNummer(Kommune k){
        Scanner in = new Scanner(System.in);
        System.out.println("Bruksnummer: ");
        int bruksNummer = in.nextInt();


        if(k.bruksNummerSoker(bruksNummer).isEmpty()){
            System.out.println("Ingen "+ bruksNummer + " ble funnet");
        } else
        System.out.println(k.bruksNummerSoker(bruksNummer));
        }
    /**
     * Sjekker om den er to, og hvis ikke så henter den bruksnavnet
     * @param k
     */

    public static void hentBruksNavn(Kommune k){
        Scanner in = new Scanner(System.in);
        System.out.println("Navn: ");
        String bruksNavn = in.nextLine();
        
        if(k.bruksNavnSoker(bruksNavn).isEmpty()){
            System.out.println("Ingen "+ bruksNavn + " ble funnet");
        } else
        System.out.println(k.bruksNavnSoker(bruksNavn));
        }


        /**
         * Denne metoden spør om 3 input og sjekker at alle er tilstede før 
         * den returnerer eiendommen som passer parametrene
         * @param k
         */
    public static void finnEiendom(Kommune k) {
        Scanner in = new Scanner(System.in);
        System.out.println("Tast inn info om eiendommen du vil finne:");
        System.out.print("Kommunenummer: "); 
        int kommuneNummer = in.nextInt();
        System.out.print("Gårdsnummer: "); 
        int gardsNummer = in.nextInt();
        System.out.print("Bruksnummer: "); 
        int bruksNummer = in.nextInt();

        if (kommuneNummer < 0 || gardsNummer < 0 || bruksNummer < 0) {
            throw new IllegalArgumentException("Du må skrive positive verdier");
        } else {
        if (k.eiendomFinner(kommuneNummer, gardsNummer, bruksNummer) != null) {
            System.out.println(k.eiendomFinner(kommuneNummer, gardsNummer, bruksNummer).toString());
        } else {
            System.out.println("Finner ingen eiendommer i register som stemmer med opplysningene du oppga");
        }
    }
}
    /**
     * Denne spør om 3 parametre og så fjerner den eiendommen som passer
     * @param k
     */
    public static void eiendomFjerner(Kommune k) {

        Scanner in = new Scanner(System.in);
        System.out.println("Kommunenummer:");
        int kommuneNummer = in.nextInt();
        System.out.println("Gårdsnummer:");
        int gardsNummer = in.nextInt();
        System.out.println("Bruksnummer:");
        int bruksNummer = in.nextInt();
        if (kommuneNummer < 0 || gardsNummer < 0 || bruksNummer < 0) {
            throw new IllegalArgumentException("Du må skrive positive verdier!");
        } else {
            try {
                k.fjernEiendom(kommuneNummer, gardsNummer, bruksNummer);
                System.out.println("Eiendommen med ID: " + kommuneNummer +"-"+ gardsNummer +"/"+ bruksNummer + " ble slettet.");
            } catch (IllegalArgumentException e) {
                System.out.println("Ingen eiendommer med denne identifikasjonen ble funnet");
            }
        }
    }
}