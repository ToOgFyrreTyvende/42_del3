package Model.Felter;

import Model.Felt;
import Model.Spiller;

import java.awt.*;

/**
 * @author Xephyz
 * Denne klasse holder styr på alle felter der handler om Ejendomme som kan købes af spillere
 */

public class EjendomFelt extends Felt {
    // Variables
    private int pris;
    private int leje;
    private Spiller ejer;
    private Color farve;

    // #----------Constructor----------#
    public EjendomFelt(String navn, String subText, String beskrivelse) {
        super(navn, subText, beskrivelse);
    }

    // #--------------Get--------------#
    @Override
    public String getNavn() {
        return super.getNavn();
    }

    @Override
    public String getSubText() {
        return super.getSubText();
    }

    @Override
    public String getBeskrivelse() {
        return super.getBeskrivelse();
    }

    public int getPris() {
        return pris;
    }

    public int getLeje() {
        return leje;
    }

    public Spiller getEjer() {
        return ejer;
    }

    public Color getFarve() {
        return farve;
    }

    // #--------------Get--------------#
    public void setPris(int pris) {
        this.pris = pris;
    }

    public void setLeje(int leje) {
        this.leje = leje;
    }

    public void setEjer(Spiller ejer) {
        this.ejer = ejer;
    }

    public void setFarve(Color farve) {
        this.farve = farve;
    }
}
