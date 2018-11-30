package Controller;

import Model.GameBoard;
import Model.Spil;
import Model.Spiller;
import Model.Feltliste;
import View.GameGUIView;
import View.GameView;

public class SpilController{
    private Spil spil;
    private GameView view;
    private GameBoard spilBraet;
    
    // #----------Constructor----------#
    public SpilController(){
        this.spilBraet = new GameBoard();
        this.view = new GameGUIView(this.spilBraet);
        initialiserSpil();
        spillerTur(spil.getAktivSpiller());

    }

    private void initialiserSpil(){
        // pga. abstrakt klasse, har vi polymorfi, og kan kalde "getantalspillere" for ethvert view
        int spillerAntal = this.view.getAntalSpillere();
        String[] spillerNavne = new String[spillerAntal];

        for (int i = 0; i < spillerAntal; i++) {
            if (i==0){
                spillerNavne[i] = (this.view.getSpillerNavn("Indtast venligst første, yngste spillers navn."));

            }else{
                spillerNavne[i] = (this.view.getSpillerNavn("Indtast venligst " + (i+1) + ". spillers navn."));
            }
        }

        spil = new Spil(this.spilBraet, spillerNavne);
        this.view.setSpillere(spil.getSpillere());
        this.view.resetBoard();
    }


    public void spillerTur(Spiller spiller){
        view.getRundeValgMedTekst(spiller.getNavn() + "'s tur. Rul venligst terningen.", "Rul terning");

        int forrigeFelt = spiller.getFelt();

        Spiller muligSpiller = spil.spilTur();

        if (muligSpiller != null){
            opdaterUIspiller(muligSpiller, forrigeFelt);
            view.setTerning(muligSpiller.getSidstSlaaet());
            view.setCenterTekst(muligSpiller.toString());
            muligSpiller.setChaneKort(null);
            muligSpiller.setSidsteHandling("");

            spillerTur(spil.getAktivSpiller());
        }else {
            view.slutTekst("spillet er slut!");
        }
    }

    private void opdaterUIspiller(Spiller spiller, int forrigeFelt){
        view.opdaterSpillerData(spiller, forrigeFelt);
    }


    // #--------------Get--------------#

    public boolean spilAktivt(){
        return !spil.isAfsluttet();
    }

}