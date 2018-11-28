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

    public SpilController(String spiller1, String spiller2){
        this.spil = new Spil(spiller1, spiller2);
    }

    // #--------------Get--------------#
    public String getAktivSpiller() {
        return this.spil.getAktivSpiller().getNavn();
    }

    public String getSlutTekst() {
        if (!this.spil.spilAktivt()) {
            Spiller vinder = this.spil.getVinder();
            return String.format(Feltliste.feltTekst.getString("YouWon"), vinder.getNavn(), vinder.getPenge());
        } else {
            return "";
        }
    }

    // #-------------Other-------------#    
    public void start() {
        view.getRundeValgMedTekst(Feltliste.feltTekst.getString("GameBegun"), "Ok");
    }

    public String kastTerning(){
        if(!this.spil.spilAktivt()){
            System.out.println();
            Spiller vinder = this.spil.getVinder();
            if(vinder != null){
                return String.format(Feltliste.feltTekst.getString("GetGold"),
                            vinder.getNavn(), vinder.getPenge());
            }else{
                return Feltliste.feltTekst.getString("GameError");
            }
        }else{
            Spiller aktivSpiller = spil.getAktivSpiller();
            String turTekst = (spil.spilTur());
    
            String kastFeltTekst = Feltliste.getFeltTekst(aktivSpiller.getFelt());
            String pengeMsg = String.format(Feltliste.feltTekst.getString("GetGold2"), aktivSpiller.getNavn(), aktivSpiller.getPenge());
    
            return turTekst + "\n" + kastFeltTekst + "\n" + pengeMsg;
        }
    }

    public boolean spilAktivt(){
        return spil.spilAktivt();
    }

}