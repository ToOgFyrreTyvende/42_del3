package View;

import gui_main.GUI;

public class GameGUIView extends GameView {
    private GUI ui;

    public GameGUIView() {
        this.ui = new GUI();
    }

    @Override
    public int getAntalSpillere() {
        return ui.getUserInteger("Hvor mange spillere?", 2,4);
    }
}
