package Model.Felter;

import Model.Felt;

public class TilFaengselFelt extends Felt {

    public TilFaengselFelt(String navn, String subText, String beskrivelse) {
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
}