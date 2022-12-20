import java.util.*;

public class Klient {
    
    public static void main(String[]args){
        System.out.println("Velkommen til Matrettmeny");
        Kjokken k = new Kjokken();
        fyllRestaurantMedRetter(k);
        while(true){
            visBrukerMeny(k);
        }
    }

    public static void visBrukerMeny(Kjokken k){

        Scanner in = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("1: Registrer ny rett");
        System.out.println("2: Finn rett via navn");
        System.out.println("3: Finn rett via retttype");
        System.out.println("4: Lag ny meny");
        System.out.println("5: Finn meny via prisintervall");
        System.out.println("6: Avbryt programmet");

        int brukerMenyValg = in.nextInt();
    
        switch(brukerMenyValg){
            case 1: 
            nyMatrett(k);  
            break;

            case 2:
            finnRettViaNavn(k);   
            break;

            case 3: 
            finnMatrettViaRetttype(k);
            break;

            case 4: 
            nyMeny(k);
            break;

            case 5:
            finnMenyViaPrisIntervall(k);
            break;

            case 6: 
            System.out.println("Avslutter...");
            System.exit(0);
            break;

            default: visBrukerMeny(k);
        }
    }

        public static void nyMatrett(Kjokken k){
            Scanner in = new Scanner(System.in);
            System.out.println("Navn: ");
            String navn = in.nextLine();
            if (k.hentRettViaNavn(navn).size()> 0){
                System.out.println("Denne retten finnes allerede!");
            } else {
                System.out.println("Retttype: ");
                String rettType = in.nextLine();

                System.out.print("Oppskrift: ");
                String oppskrift = in.nextLine();

                System.out.println("Pris: ");
                double pris = in.nextDouble();

                Matrett nyMatrett = k.nyMatrett(navn, rettType, oppskrift, pris);
                System.out.println("Den nye retten har blitt registrert: ");
                System.out.println(nyMatrett.toString());
            }
        }

        public static void finnRettViaNavn(Kjokken k){
            Scanner in = new Scanner(System.in);
            System.out.println("Navn: ");
            String navn = in.nextLine();

            ArrayList<Matrett>matretter=k.hentRettViaNavn(navn);
            if(matretter.size()>0){
                for (int i = 0; i <matretter.size(); i++){
                    System.out.println(matretter.get(i).toString());
            }
            }
            else { System.out.println("Ingen retter med navn " + navn + " er registrert");
            }
        }

        public static void finnMatrettViaRetttype(Kjokken k){
            Scanner in = new Scanner(System.in);
            System.out.println("Navn: ");
            String rettType = in.nextLine();

            ArrayList<Matrett> matretter = k.hentRettViaRettType(rettType); 
            if (matretter.size() > 0) { 
                for (int i = 0; i < matretter.size(); i++) {
                    System.out.println(matretter.get(i).toString()+"\n"); 
                }
            } else { 
                System.out.println("Ingen "+ rettType + " ble funnet");
            }
        }

        public static void nyMeny(Kjokken k) {
            Scanner in = new Scanner(System.in);
            boolean done1 = false; 
            ArrayList<Matrett> matretter = new ArrayList<Matrett>(); 
    
            String alleRetter = ""; 
            for (int i = 0; i < k.hentMatretter().size(); i++) {
                if (i != 0) {
                    alleRetter = alleRetter + ", "; 
                }
                alleRetter = alleRetter + k.hentMatretter().get(i).toString2(); 
            }
            System.out.println("Registrerte retter: \n" + alleRetter); 
            
            while (!done1) { 
                if (matretter.size() < 1) { 
                    System.out.println("Skriv inn navnet på en rett for å registrere retten:");
                } else { 
                    System.out.println("Trykk 1 for å registrere menyen (Etter alle retter er lagt til)");
                }
                String navn = in.nextLine();
    
                if (navn.equals("1")) { 
                    done1 = true;
                } else { // Hvis input ikke 1, fortsett
                    ArrayList<Matrett> nyMatrett = k.hentRettViaNavn((navn)); 
                    if (nyMatrett.size() > 0) { 
                        matretter.add(nyMatrett.get(0)); 
                        System.out.println(navn + " ble lagt til i menyen"); 
                    } else { 
                        System.out.println("Fant ingen retter med navnet " + navn); 
                    }
                }
            }
            System.out.println("Menyen har blitt registrert");
            k.nyMeny(matretter); 
            }
        

        public static void finnMenyViaPrisIntervall(Kjokken k) {
            Scanner in = new Scanner(System.in);
            System.out.println("Skriv inn laveste pris: ");
            int min = in.nextInt();
    
            System.out.println("Skriv inn høyeste pris: ");
            int max = in.nextInt();
    
            ArrayList<Meny> menyer = k.hentMenyGjennomPrisIntervall(min, max); 
            System.out.println("Meny innenfor prisklassen  " + min + " and " + max + ":");
            for (int i = 0; i < menyer.size(); i++) { 
                System.out.println("Meny nr " + (i + 1) + ":"); 
                System.out.println(menyer.get(i).toString() + "\n"); 
            }
        }
    
        public static void fyllRestaurantMedRetter(Kjokken k) {
        k.matrettDump();
        }
}