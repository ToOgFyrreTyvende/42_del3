package View;

import gui_codebehind.GUI_FieldFactory;
import gui_main.GUI;

public class GameGUIView extends GameView {
    private GUI ui;

    public GameGUIView() {
        this.ui = new GUI();
        ui.setDice(3,2);
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
