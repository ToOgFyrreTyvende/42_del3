package Model;

/**
 * -------------------------------------------------
 * Denne superklasse bruges til at gøre det nemmere
 * at give alle felterne et navn, beksrivelse og
 * hvilken effekt feltet skal gøre
 *-------------------------------------------------
 */

public abstract class Felt {
    protected String navn, subText, beskrivelse;

    // #----------Constructor----------#
    public Felt(String navn, String subText, String beskrivelse){
        this.navn=navn;
        this.subText=subText;
        this.beskrivelse=beskrivelse;
    }

    // #--------------Get--------------#
    public String getNavn() {
        return navn;
    }

    public String getSubText() {
        return subText;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }


}
