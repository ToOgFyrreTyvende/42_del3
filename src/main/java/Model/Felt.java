package Model;

/**
 * -------------------------------------------------
 * Denne superklasse bruges til at gøre det nemmere
 * at give alle felterne et navn, beksrivelse og
 * hvilken effekt feltet skal gøre
 *-------------------------------------------------
 */

public class Felt {
    private String navn, subText, beskrivelse;

    // #----------Constructor----------#
    public Felt(String navn, String subText, String beskrivelse){
        this.navn=navn;
        this.subText=subText;
        this.beskrivelse=beskrivelse;
    }

    // #--------------Get--------------#
    public String Felte(){
        String help="help";
        return help;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    // #--------------Set--------------#
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
}
