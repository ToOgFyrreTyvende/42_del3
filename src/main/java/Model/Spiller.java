package Model;

import gui_fields.GUI_Player;

/**
 * ------------------------------------------------------------/
 * Denne klasse kaldes for at oprette en ny spiller
 * Model.Spiller kan have et brugervalgt navn som bruges under
 * kørsel af spillet
 * ------------------------------------------------------------/
 */

 // PLACEHOLDER! Skift Model.Spiller til at initialisere ÉN spiller
 // af gangen.
public class Spiller {
    private int felt = 0;
    private String navn;
    private int pengebeholdning = 1;
    private int sidstSlaaet = 0;

    // #----------Constructor----------#
    public Spiller(String navn){
        // Vælg spiller navn selv
        this.navn = navn;
    }

    // #------------Get/Set------------#
    public int getFelt(){
        // Returnerer nuværende felt af spiller
        return felt;
    }
    public int setFelt(int nyFelt){
        // Returnerer nye felt af spiller
        felt = nyFelt;
        return felt;
    }

    public int getPenge(){
        return this.pengebeholdning;
    }

    public void setPenge(int penge){
        this.pengebeholdning = penge;
    }

    public void setSidstSlaaet(int sidstSlaaet) {
        this.sidstSlaaet = sidstSlaaet;
    }

    // #--------------Get--------------#
    public String getNavn(){
        // Returnerer spiller navn
        return navn;
    }

    public int getSidstSlaaet() {
        return sidstSlaaet;
    }

    // #-------------Other-------------#
    public void addPenge(int penge){
        this.pengebeholdning = pengebeholdning + penge;
    }
}
