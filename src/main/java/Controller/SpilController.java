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
        // pga. abstrakt klasse, har vi polymorfi, og kan kalde "getantalspillere" for ethvert view
        System.out.println(this.view.getAntalSpillere());
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
        System.out.println(Feltliste.feltTekst.getString("GameBegun"));
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