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
            GUI_Field temp = felterModel[i].lavGUIFelt();
            felterGUI[i] = temp;
        }
    }

    private Felt[] lavFelter() {
        Felt[] tempFelter = {
                new StartFelt("Start", "2M", "Få 2M når du passerer!"),
                new EjendomFelt("Burgerbaren", "Pris: 1M", "Burgerbaren", 1, Color.gray),
                new EjendomFelt("Pizzahuset", "Pris: 1M", "Pizzahuset", 1, Color.gray),

                new ChanceFelt("Chance", "Chance", "Tag et chancekort"),

                new EjendomFelt("Slikbutikken", "Pris: 1M", "Slikbutikken", 1, Color.blue),
                new EjendomFelt("Iskiosken", "Pris: 1M", "Iskiosken", 1, Color.blue),

                new FaengselFelt("Fængsel", "På besøg", "Enten er du endt i fængsel, eller er du på besøg."),

                new EjendomFelt("Museet", "Pris: 2M", "Museet", 2, Color.pink),
                new EjendomFelt("Biblioteket", "Pris: 2M", "Biblioteket", 2, Color.pink),

                new ChanceFelt("Chance", "Chance", "Tag et chancekort"),

                new EjendomFelt("Skaterparken", "Pris: 2M", "Skaterparken", 2, Color.yellow),
                new EjendomFelt("Swimmingpoolen", "Pris: 2M", "Swimmingpoolen", 2, Color.yellow),

                new GratisParkeringFelt("Fri", "Gratis Parkering", "Hold en fridag"),

                new EjendomFelt("Spillehallen", "Pris: 3M", "Spillehallen", 3, Color.red),
                new EjendomFelt("Biograf", "Pris: 3M", "Biograf", 3, Color.red),

                new ChanceFelt("Chance", "Chance", "Tag et chancekort"),

                new EjendomFelt("Legetøjsbutik", "Pris: 3M", "Legetøjsbutik", 3, Color.orange),
                new EjendomFelt("Dyrehandel", "Pris: 3M", "Dyrehandel", 3, Color.orange),

                new TilFaengselFelt("Fængsel", "Gå til fængsel", "Øv, du skal til fængsel"),

                new EjendomFelt("Bowlinghallen", "Pris: 4M", "Bowlinghallen", 4, Color.green),
                new EjendomFelt("Zoo", "Pris: 4M", "Zoo", 4, Color.green),

                new ChanceFelt("Chance", "Chance", "Tag et chancekort"),

                new EjendomFelt("Vandlandet", "Pris: 5M", "Vandlandet", 5, Color.cyan),
                new EjendomFelt("Strandpromenaden", "Pris: 5M", "Strandpromenaden", 5, Color.cyan)
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

    public Felt getFeltModel(int index){
        return felterModel[index % 24];
    }

    public GUI_Field[] getFelterGUI() {
        return felterGUI;
    }

    public boolean erEjet(int index){
        Felt felt = this.getFelterModel()[index % 24];
        if (felt instanceof EjendomFelt){
            return ((EjendomFelt) felt).getEjer() == null;
        }
        return false;
    }


}
