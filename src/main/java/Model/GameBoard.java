package Model;
import Model.Felter.*;
import gui_fields.*;

import java.awt.*;
import java.util.*;

public class GameBoard {

    private Felt[] felterModel;
    private GUI_Field[] felterGUI;

    public GameBoard() {
        this.felterModel = new Felt[24];
        this.felterGUI = new GUI_Field[24];

        this.felterModel = lavFelter();

        for (int i = 0; i < felterGUI.length; i++) {
            GUI_Field temp = GUIfeltFraFelt(felterModel[i]);
            felterGUI[i] = temp;
        }
    }

    private GUI_Field GUIfeltFraFelt(Felt felt) {
        if (felt instanceof EjendomFelt){
            return new GUI_Street(felt.getNavn(), felt.getSubText(),
                        felt.getBeskrivelse(), ((EjendomFelt) felt).getPris() + "M", Color.blue, Color.black);
        }
        else if (felt instanceof ChanceFelt){
            return new GUI_Chance(felt.getNavn(), felt.getSubText(), felt.getBeskrivelse(), Color.white, Color.white);
        }
        else if (felt instanceof FaengselFelt){
            return new GUI_Refuge();

        }
        else if (felt instanceof TilFaengselFelt) {
            return new GUI_Jail();
        }
        else if (felt instanceof StartFelt) {
            return new GUI_Start();
        }
        else{
            return new GUI_Empty(Color.white, Color.white, felt.getNavn(),
                    felt.getSubText(), felt.getBeskrivelse());
        }
    }

    private Felt[] lavFelter() {
        Felt[] tempFelter = {
                new StartFelt("Start", "2M", "Få 2M når du passerer!"),
                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),
                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),

                new ChanceFelt("Chance", "Chance", "Tag et chancekort"),

                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),
                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),

                new FaengselFelt("Fængsel", "Eller på besøg", "Enten er du endt i fængsel, ellers er du på besøg"),

                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),
                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),

                new ChanceFelt("Chance", "Chance", "Tag et chancekort"),

                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),
                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),

                new GratisParkeringFelt("Gratis", "Parkering", "Hold en fridag"),

                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),
                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),

                new ChanceFelt("Chance", "Chance", "Tag et chancekort"),

                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),
                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),

                new TilFaengselFelt("Fængsel", "Gå til fængsel", "Øv, du skal til fængsel"),

                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),
                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),

                new ChanceFelt("Chance", "Chance", "Tag et chancekort"),

                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1),
                new EjendomFelt("Burgerbaren", "Pris: 1M", "", 1)
        };

        return tempFelter;


    }

    private static void lavBoard(String s, Object o) {
        System.out.println(o);
    }

    public int getFeltPenge(int felt){
        return 2;
    }

    public Felt[] getFelterModel(){
        return felterModel;
    }

    public GUI_Field[] getFelterGUI() {
        return felterGUI;
    }
}
