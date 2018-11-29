package Model;

import Model.Felter.EjendomFelt;
import Model.Felter.TilFaengselFelt;

import java.util.ArrayList;
import java.util.List;

/**
 * ------------------------------------------------------------/ 
 * Denne klasse er hoveddelen der kører hele spillet og diverse 
 * klasser efter en bruger har åbnet programmet
 * ------------------------------------------------------------/
 */

public class Spil {
    private int[] muligeStartPenge = {20, 18, 16};
    private int startPenge;

    private Spiller[] spillere;
    private Spiller vinder;
    private Spiller aktivSpiller;

    private Terning terning;
    private List<Runde> runder;
    private Runde aktivRunde;    
    private boolean afsluttet;

    private GameBoard spilBraet;

    // #----------Constructor----------#

    public Spil(GameBoard sb, String[] spillerNavne){
        opretSpillere(spillerNavne);

        //Kodedelen med runder er taget fra vores forrige opgave: 42_del1
        runder = new ArrayList<>();
        runder.add(new Runde());
        terning = new Terning();

        aktivSpiller = spillere[0];
        aktivRunde = runder.get(runder.size()-1);

        spilBraet = sb;

        afsluttet = false;
    }

    private void opretSpillere(String[] spillerNavne){

        this.startPenge = muligeStartPenge[spillerNavne.length - 2];

        Spiller[] spillere = new Spiller[spillerNavne.length];
        for (int i = 0; i < spillerNavne.length; i++) {
            spillere[i] = new Spiller(spillerNavne[i]);
            spillere[i].setPenge(startPenge);
        }

        this.spillere = spillere;
    }

    
    public Spiller spilTur(){
        if (!afsluttet) {
            int nuIndex = java.util.Arrays.asList(spillere).indexOf(aktivSpiller);
            int nyIndex = (nuIndex + 1) % spillere.length;
            int slag = terning.getResultat();
            int[] tempTur = {slag, nuIndex};

            Spiller _aktivSpiller = aktivSpiller;

            spilRegler(slag);

            opdaterAktivSpillerMedSlag(slag);

            aktivRunde.tilfoejTur(tempTur);
            aktivSpiller = spillere[nyIndex];

            checkRunde();

            return _aktivSpiller;
        }else{
            return null;
        }
    }

    private void spilRegler(int slag) {
        if (aktivSpiller.isiFaengsel()){
            aktivSpiller.addPenge(-1);
            aktivSpiller.setiFaengsel(false);
            checkRunde();
        }

        if (!afsluttet){
            int feltId = aktivSpiller.getFelt() + slag;
            Felt landetFelt = this.getSpilBraet().getFeltModel(feltId);
            ejendomBetal(feltId, landetFelt);
            //chancekort skal tilføjes...
            tjekTilFaengsel(feltId, landetFelt);



        }else {

        }

    }

    private void ejendomBetal(int feltId, Felt landetFelt) {
        if (landetFelt instanceof EjendomFelt) {
            if (this.getSpilBraet().erEjet(feltId)){
                System.out.println(aktivSpiller.getNavn() + " Har købt " + landetFelt.getNavn());
                betalTilSpillerFelt(aktivSpiller, (EjendomFelt) landetFelt);
            }else{
                koebFelt(aktivSpiller, (EjendomFelt) landetFelt);
            }
        }
    }

    public void betalTilSpillerFelt(Spiller spiller, EjendomFelt landetFelt){
        Spiller ejer = landetFelt.getEjer();
        int betaling = landetFelt.getLeje();
        spiller.addPenge( - betaling);
        ejer.addPenge(betaling);
    }

    private void koebFelt(Spiller spiller, EjendomFelt landetFelt) {
        int betaling = landetFelt.getPris();
        spiller.addPenge( - betaling);
    }

    private void tjekTilFaengsel(int feltId, Felt landetFelt) {
        if (landetFelt instanceof TilFaengselFelt) {
            smidIFaengsel(aktivSpiller);
        }
    }

    public void smidIFaengsel(Spiller spiller){
        spiller.setFelt(spilBraet.getFaengsel());
        spiller.setiFaengsel(true);
    }


    private void opdaterAktivSpillerMedSlag(int slag) {
        int nyFelt = (aktivSpiller.getFelt() + slag) % 24;

        aktivSpiller.setFelt(nyFelt);
        aktivSpiller.setSidstSlaaet(slag);
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

    // Getters & setters


    public Spiller[] getSpillere() {
        return spillere;
    }

    public void setSpillere(Spiller[] spillere) {
        this.spillere = spillere;
    }

    public Spiller getVinder() {
        return vinder;
    }

    public void setVinder(Spiller vinder) {
        this.vinder = vinder;
    }

    public Spiller getAktivSpiller() {
        return aktivSpiller;
    }

    public void setAktivSpiller(Spiller aktivSpiller) {
        this.aktivSpiller = aktivSpiller;
    }

    public Terning getTerning() {
        return terning;
    }

    public void setTerning(Terning terning) {
        this.terning = terning;
    }

    public List<Runde> getRunder() {
        return runder;
    }

    public void setRunder(List<Runde> runder) {
        this.runder = runder;
    }

    public Runde getAktivRunde() {
        return aktivRunde;
    }

    public void setAktivRunde(Runde aktivRunde) {
        this.aktivRunde = aktivRunde;
    }

    public boolean isAfsluttet() {
        return afsluttet;
    }

    public void setAfsluttet(boolean afsluttet) {
        this.afsluttet = afsluttet;
    }

    public int getStartPenge() {
        return startPenge;
    }

    public void setStartPenge(int startPenge) {
        this.startPenge = startPenge;
    }

    public GameBoard getSpilBraet() {
        return spilBraet;
    }

    public void setSpilBraet(GameBoard spilBraet) {
        this.spilBraet = spilBraet;
    }

}
