package View;

import gui_codebehind.GUI_FieldFactory;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class GameGUIView extends GameView {
    private GUI ui;

    public GameGUIView() {
        this.ui = new GUI(makeFields());
        ui.setDice(3,2);

        //System.out.println((GUI_Street)this.ui.getFields()[2]);


    }
    public static GUI_Field[] makeFields() {
        GUI_Field[] fields = new GUI_Field[24];
        int i = 0;
        int var2 = i + 1;
        // Der er GUI_Street, GUI_Chance, GUI_Tax, GUI_Shipping, GUI_Jail, GUI_brewery
        fields[i] = new GUI_Start("Start", "Modtag: 2 M", "Modtag 2M,-\n når de passerer start", Color.RED, Color.BLACK);
        fields[var2++] = new GUI_Street("Burgerbaren", "Pris:  1M", "Burgerbaren", "Leje:  1M", new Color(75, 155, 225), Color.BLACK);
        fields[var2++] = new GUI_Street("Pizzahuset","Pris: 1M","", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[var2++] = new GUI_Tax("Chance","","", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "Øresund", "Pris:  200", "Øresundsredderiet", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Street("Roskildevej", "Pris:  100", "Roskildevej", "Leje:  40", new Color(255, 135, 120), Color.BLACK);
        fields[var2++] = new GUI_Street("Valby\nLanggade", "Pris:  100", "Valby Langgade", "Leje:  40", new Color(255, 135, 120), Color.BLACK);
        fields[var2++] = new GUI_Street("Allégade", "Pris:  120", "Allégade", "Leje:  45", new Color(255, 135, 120), Color.BLACK);
        fields[var2++] = new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg i fængslet", new Color(125, 125, 125), Color.BLACK);
        fields[var2++] = new GUI_Street("Frederiks-\nberg Allé", "Pris:  140", "Frederiksberg Allé", "Leje:  50", new Color(102, 204, 0), Color.BLACK);
        fields[var2++] = new GUI_Brewery("default", "Tuborg", "Pris:  150", "Tuborg bryggeri", "10 x [Terningslag]", Color.BLACK, Color.WHITE);
        fields[var2++] = new GUI_Street("Bülowsvej", "Pris:  140", "Bülowsvej", "Leje:  50", new Color(102, 204, 0), Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Street("Gammel Kongevej", "Pris:  140", "Gammel Kongevej", "Leje:  50", new Color(102, 204, 0), Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
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
}
