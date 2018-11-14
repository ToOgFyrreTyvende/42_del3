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

    private int vinderPenge = 3000;

    // #----------Constructor----------#
    Spil(String spiller1navn, String spiller2navn){
        this.spillere = new Spiller[]{
            new Spiller(spiller1navn), 
            new Spiller(spiller2navn)
        };
        //Kodedelen med runder er taget fra vores forrige opgave: 42_del1    
        runder = new ArrayList<>();
        runder.add(new Runde());
        terning = new Terning();

        aktivSpiller = spillere[0];
        aktivRunde = runder.get(runder.size()-1);

        afsluttet = false;
    }

    
    public String spilTur(){
        if (!afsluttet) {
            int nuIndex = java.util.Arrays.asList(spillere).indexOf(aktivSpiller);
            int nyIndex = nuIndex == 1 ? 0 : 1;
            int[] slag = terning.getResultat();
            int[] tempTur = {slag[0], slag[1], slag[2], nuIndex};
            boolean ekstraTur;

            Spiller _aktivSpiller = aktivSpiller;

            int feltFraSlag = slag[2] - 2;
            int pengeFraFelt = getFeltPenge(feltFraSlag);

            ekstraTur = Feltliste.getEkstraTur(feltFraSlag);
            
            aktivSpiller.addPenge(pengeFraFelt);
            aktivSpiller.setFelt(feltFraSlag);

            aktivRunde.tilfoejTur(tempTur);
            this.aktivSpiller = spillere[nyIndex];
            
            // vinder skal have 3000 guld for at vinde, dette tjekkes her
            checkRunde(nuIndex);
            tjekEkstraTur(ekstraTur, nuIndex);

            return String.format(Feltliste.feltTekst.getString("TurnsRolled"),
                    _aktivSpiller.getNavn(), slag[2]);
        }else{
            return Feltliste.feltTekst.getString("GameEnd");
        }
    }

    public void tjekEkstraTur(boolean ekstraTur, int spillerIndex) {
        if(ekstraTur){
            aktivSpiller = spillere[spillerIndex];
        }
    }

    //godt og grundigt Yoinked direkte fra vores 42_del1 af CDIO
    public void checkRunde(int spillerIndex){
        // Vi tjekker om den nuværende spiller er den sidste psiller i spiller listen. Dette gør, at 
        // alle spillere har mulighed for at vinde i slutningen af en runde
        if (spillerIndex == spillere.length - 1){
            Spiller muligVinder = spillerMedPenge(vinderPenge);
            if(muligVinder != null){
                this.setVinder(muligVinder);
                this.slutSpil();
            }
            else {
                this.runder.add(new Runde());
                this.aktivRunde   = runder.get(runder.size() - 1);
            }
            
        }
    }
    
    private Spiller spillerMedPenge(int penge){
        int fundet = 0;
        int res    = 0;
        
        for(int i = 0; i < spillere.length; i++) {
            if (spillere[i].getPenge() >= penge) {
                fundet++;
                res = i;
            }
        }

        if (fundet == 1) {
            return spillere[res];
        }
        else if (fundet > 1) {
            if (spillere[0].getPenge() > spillere[1].getPenge()) {
                return (spillere[0]);
            }
            else if (spillere[0].getPenge() < spillere[1].getPenge()){
                return (spillere[1]);
            }
            else{
                return null;
            }
        }
        else
            return null;
    }

    // #--------------Get--------------#
    private int getFeltPenge(int felt){
        return Feltliste.getFeltPenge(felt);
    }
 
    public Spiller getAktivSpiller(){
        return aktivSpiller;
    }

    public Spiller getVinder(){
        return this.vinder;
    }

    public Spiller[] getSpillere() {
        return this.spillere;
    }

    public int getVinderPenge(){ return vinderPenge; }

    // #-------------Set---------------#

    private void setVinder(Spiller vinder){
        this.vinder = vinder;
    }

    // #-------------Other-------------#

    public boolean spilAktivt(){
        return !afsluttet;
    }

    private void slutSpil(){
        this.afsluttet = true;
    }
}
