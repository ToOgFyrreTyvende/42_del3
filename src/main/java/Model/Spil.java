package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * ------------------------------------------------------------/ 
 * Denne klasse er hoveddelen der kører hele spillet og diverse 
 * klasser efter en bruger har åbnet programmet
 * ------------------------------------------------------------/
 */

public class Spil {
    private Spiller[] spillere;
    private Spiller vinder;
    private Spiller aktivSpiller;

    private Terning terning;
    private List<Runde> runder;
    private Runde aktivRunde;    
    private boolean afsluttet;

    private int pengeHvis2 = 20;
    private int pengeHvis3 = 18;
    private int pengeHvis4 = 16;
    private int startPenge;

    // #----------Constructor----------#

    public Spil(String[] spillerNavne){
        opretSpillere(spillerNavne);

        //Kodedelen med runder er taget fra vores forrige opgave: 42_del1
        runder = new ArrayList<>();
        runder.add(new Runde());
        terning = new Terning();

        aktivSpiller = spillere[0];
        aktivRunde = runder.get(runder.size()-1);

        afsluttet = false;
    }

    private void opretSpillere(String[] spillerNavne){

        if (spillere.length == 2) {startPenge = pengeHvis2;}
        else if (spillere.length == 3) {startPenge = pengeHvis3;}
        else if (spillere.length == 4) {startPenge = pengeHvis4;}

        Spiller[] spillere = new Spiller[spillerNavne.length];
        for (int i = 0; i < spillerNavne.length; i++) {
            spillere[i] = new Spiller(spillerNavne[i]);
            spillere[i].setPenge(startPenge);
        }

        this.spillere = spillere;
    }

    
    public String spilTur(){
        if (!afsluttet) {
            int nuIndex = java.util.Arrays.asList(spillere).indexOf(aktivSpiller);
            int nyIndex = (nuIndex + 1) % spillere.length;
            int slag = terning.getResultat();
            int[] tempTur = {slag, nuIndex};

            Spiller _aktivSpiller = aktivSpiller;

            aktivRunde.tilfoejTur(tempTur);
            this.aktivSpiller = spillere[nyIndex];
            
            // vinder skal have 3000 guld for at vinde, dette tjekkes her
            checkRunde();

            return String.format(Feltliste.feltTekst.getString("TurnsRolled"),
                    _aktivSpiller.getNavn(), slag);
        }else{
            return Feltliste.feltTekst.getString("GameEnd");
        }
    }

    //godt og grundigt Yoinked direkte fra vores 42_del1 af CDIO
    public void checkRunde(){
        // Vi tjekker om den nuværende spiller er den sidste psiller i spiller listen. Dette gør, at 
        // alle spillere har mulighed for at vinde i slutningen af en runde

        for (int i = 0; i < spillere.length; i++) {
            if (spillere[i].getPenge() <= 0){
                afsluttet = true;
            }
        }
    }

    public Spiller findVinder() {

        Spiller højest = null;

        if (afsluttet) {
            int max = 0;


            for (int i = 0; i < spillere.length; i++) {
                if (spillere[i].getPenge() > max) {
                    max = spillere[i].getPenge();
                    højest = spillere[i];
                }
            }
        }
        return (højest);
    }
}
