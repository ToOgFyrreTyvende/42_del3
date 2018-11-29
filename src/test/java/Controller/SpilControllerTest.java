package Controller;

import Model.Spil;
import Model.Spiller;
import View.GameGUIView;
import View.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpilControllerTest {
    // Variables
    Spil testSpil;
    GameView testView;
    SpilController testSpilCtrl;


    @BeforeEach
    void setUp() {
        String[] testSpillerNavne = new String[4];
        testSpillerNavne[0] = "dummyOne";
        testSpillerNavne[1] = "dummyTwo";
        testSpillerNavne[2] = "dummyThree";
        testSpillerNavne[3] = "dummyFour";

        testSpil = new Spil(testSpillerNavne);
        testView = new GameGUIView(); // TODO: Lav en stub klasse for at undgå tests der åbner et GUI
        testSpilCtrl = new SpilController();

    }

    @Test
    void spillerTurTest() {
    }

    @Test
    void spilAktivtTest() { // Fjern // efter stubklassen er blevet lavet
        //assertTrue(!testSpil.isAfsluttet());
    }
}