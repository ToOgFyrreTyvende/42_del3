package Model.Felter;

import Model.Felt;
import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;

import java.awt.*;

public class FaengselFelt extends Felt {

    public FaengselFelt(String navn, String subText, String beskrivelse) {
        super(navn, subText, beskrivelse);
    }

    // #--------------Get--------------#
    @Override
    public String getNavn() {
        return super.getNavn();
    }

    @Override
    public String getSubText() {
        return super.getSubText();
    }

    @Override
    public String getBeskrivelse() {
        return super.getBeskrivelse();
    }

    @Override
    public GUI_Field lavGUIFelt() {
        return new GUI_Jail("default", this.getNavn(), this.getSubText(),
                this.getBeskrivelse(), Color.white, Color.BLACK);
    }
}
