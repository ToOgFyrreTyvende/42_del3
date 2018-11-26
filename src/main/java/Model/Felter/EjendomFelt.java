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
    int pris;
    int leje;
    Spiller ejer;
    Color farve;

    // #----------Constructor----------#
    public EjendomFelt(String navn, String subText, String beskrivelse) {
        super(navn, subText, beskrivelse);
    }
}
