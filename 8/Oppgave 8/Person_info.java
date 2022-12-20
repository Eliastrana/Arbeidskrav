import java.util.*;

public class Person_info {


private final String fornavn;
private final String etternavn;
private final int bursdag;

/**
 * 
 * @param fornavn
 * @param etternavn
 * @param bursdag
 * 
 * Creates a method that contains the different values 
 */
public Person_info(String fornavn, String etternavn, int bursdag) {
    this.fornavn = fornavn;
    this.etternavn = etternavn;
    this.bursdag = bursdag;
}
/**
 * Strings that collects info and return them as the correct category
 */

public String hent_fornavn(){
    return fornavn;
}

public String hent_etternavn(){
    return etternavn;
}

public int hent_fodsels_aar(){
    return bursdag;
}
}