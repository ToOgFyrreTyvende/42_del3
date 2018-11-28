package Controller;

import Model.Spil;
import Model.Spiller;
import Model.Feltliste;
import View.GameGUIView;
import View.GameView;

public class SpilController{
    private Spil spil;
    private GameView view;
    
    // #----------Constructor----------#
    public SpilController(){
        this.view = new GameGUIView();
        initialiserSpil();
        spillerTur(spil.getAktivSpiller());

    }

    private void initialiserSpil(){
        // pga. abstrakt klasse, har vi polymorfi, og kan kalde "getantalspillere" for ethvert view
        int spillerAntal = this.view.getAntalSpillere();
        String[] spillerNavne = new String[spillerAntal];

        for (int i = 0; i < spillerAntal; i++) {
            spillerNavne[i] = (this.view.getSpillerNavn(i + 1));
        }

        spil = new Spil(spillerNavne);
        this.view.setSpillere(spil.getSpillere());
        this.view.resetBoard();
    }


    public void spillerTur(Spiller spiller){
        view.getRundeValgMedTekst("Spiller 1's tur. Rul venligst terningen.", "Rul terning");
        Spiller muligSpiller = spil.spilTur();
        if (muligSpiller != null){
            opdaterUIspiller(muligSpiller);
            spillerTur(spil.getAktivSpiller());
        }else {
            view.slutTekst("spillet er slut!");
        }
    }

    private void opdaterUIspiller(Spiller spiller){
        view.opdaterSpillerData(spiller);
    }


    // #--------------Get--------------#

    public boolean spilAktivt(){
        return !spil.isAfsluttet();
    }

}