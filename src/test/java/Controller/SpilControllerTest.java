package Controller;

import Model.GameBoard;
import Model.Spil;
import Model.Spiller;
import View.GameGUIView;
import View.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stub.TerningStub;

import static org.junit.jupiter.api.Assertions.*;

class SpilControllerTest {
    // Variables
    Spil testSpil;
    String[] testNavne;
    GameView testView;
    GameBoard testBoard;
    TerningStub testTerning;
    SpilController testSpilCtrl;


    @BeforeEach
    void setUp() {
        testNavne = new String[2];
        testNavne[0] = "dummyOne";
        testNavne[1] = "dummyTwo";

        testBoard = new GameBoard();
        testSpil = new Spil(testBoard, testNavne);
        //testView = new GameGUIView(); // TODO: Lav en stub klasse for at undgå tests der åbner et GUI

    }

    @Test
    void spillerTurTest() {
    }

    @Test
    void spilAktivtTest() { // Fjern // efter stubklassen er blevet lavet
        //assertTrue(!testSpil.isAfsluttet());
    }
}