package View;

import Model.Spiller;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;
import java.util.HashMap;

// Vi ved godt, at mange elementer i denne klasse er gentagende fra vores model
// Men vi har været nødt til at "tvinge" noget data ind i UIets format igennem denne klasse.

public class GameGUIView extends GameView {
    private GUI ui;
    private GUI_Field[] fields;

    private HashMap<Spiller, GUI_Player> spillere = new HashMap<>();

    public GameGUIView() {
        this.ui = new GUI(makeFields());
    }

    private GUI_Field[] makeFields() {
        fields = new GUI_Field[24];
        int i = 0;
        int var2 = i + 1;
        // Der er GUI_Street, GUI_Chance, GUI_Tax, GUI_Shipping, GUI_Jail, GUI_brewery
        fields[i] = new GUI_Start("Start", "Modtag: 2 M", "Modtag 2M,-\n når de passerer start", Color.RED, Color.BLACK);
        fields[i++] = new GUI_Street("Burgerbaren", "Pris:  1M", "Burgerbaren", "Leje:  1M", new Color(75, 155, 225), Color.BLACK);
        fields[i++] = new GUI_Street("Pizzahuset","Pris: 1M","", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[i++] = new GUI_Tax("Chance","","", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "Øresund", "Pris:  200", "Øresundsredderiet", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("Roskildevej", "Pris:  100", "Roskildevej", "Leje:  40", new Color(255, 135, 120), Color.BLACK);
        fields[i++] = new GUI_Street("Valby\nLanggade", "Pris:  100", "Valby Langgade", "Leje:  40", new Color(255, 135, 120), Color.BLACK);
        fields[i++] = new GUI_Street("Allégade", "Pris:  120", "Allégade", "Leje:  45", new Color(255, 135, 120), Color.BLACK);
        fields[i++] = new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg i fængslet", new Color(125, 125, 125), Color.BLACK);
        fields[i++] = new GUI_Street("Frederiks-\nberg Allé", "Pris:  140", "Frederiksberg Allé", "Leje:  50", new Color(102, 204, 0), Color.BLACK);
        fields[i++] = new GUI_Brewery("default", "Tuborg", "Pris:  150", "Tuborg bryggeri", "10 x [Terningslag]", Color.BLACK, Color.WHITE);
        fields[i++] = new GUI_Street("Bülowsvej", "Pris:  140", "Bülowsvej", "Leje:  50", new Color(102, 204, 0), Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("Gammel Kongevej", "Pris:  140", "Gammel Kongevej", "Leje:  50", new Color(102, 204, 0), Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        return fields;
    }

    @Override
    public int getAntalSpillere() {
        return ui.getUserInteger("Hvor mange spillere?", 2,4);
    }

    @Override
    public String getSpillerNavn(int nr) {
        return ui.getUserString("Indtast venligst spiller " + nr + "s navn.");
    }


    @Override
    public String getRundeValg(String... valg) {
        return ui.getUserButtonPressed("Foretag venligst en handling.", valg);
    }

    @Override
    public String getRundeValgMedTekst(String tekst, String... valg) {
        return ui.getUserButtonPressed(tekst, valg);
    }

    @Override
    public void setSpillere(Spiller ... spillereModel) {
        //this.spillere = new GUI_Player[spillereModel.length];
        //Random rand = new Random();
        for (int i = 0; i < spillereModel.length; i++){
            System.out.println(spillereModel[i].getNavn());
            //double r = rand.nextFloat() / 2f + 0.5
            //double g = rand.nextFloat() / 2f + 0.5;
            //double b = rand.nextFloat() / 2f + 0.5;
            //GUI_Car tempcar = new GUI_Car();
            //tempcar.setPrimaryColor(new Color((float)r, (float)g, (float)b));

            GUI_Player tempSpillerGUI = new GUI_Player(spillereModel[i].getNavn(), spillereModel[i].getPenge());

            this.spillere.put(spillereModel[i], tempSpillerGUI);
            ui.addPlayer(this.spillere.get(spillereModel[i]));
        }
    }

    @Override
    public void resetBoard() {
        this.spillere.forEach((spillerModel, spillerBrik) -> this.fields[0].setCar(spillerBrik, true));
    }

    @Override
    public void setSpillerFelt(Spiller spillerModel, int felt) {
        System.out.println(this.fields[0]);
        int feltIndex = (felt % 24) -1;
        GUI_Player spillerGUI = this.spillere.get(spillerModel);

        this.fields[feltIndex].setCar(spillerGUI, true);
    }

    @Override
    public void setSpillerPenge(Spiller spiller, int penge) {
        this.spillere.get(spiller).setBalance(penge);
    }

    @Override
    public void opdaterSpillerData(Spiller spiller) {
        setSpillerFelt(spiller, spiller.getFelt());
        setSpillerPenge(spiller, spiller.getPenge());
    }

    @Override
    public void slutTekst(String tekst) {
        this.ui.getUserButtonPressed(tekst, "");
    }
}
