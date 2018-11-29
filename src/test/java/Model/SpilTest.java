package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpilTest {
    // Variables
    Spil testSpil;
    String[] testNavne;
    Spiller[] testSpillere;

    @BeforeEach
    void setUp() {
        testNavne = new String[2];
        testNavne[0] = "dummyOne";
        testNavne[1] = "dummyTwo";

        testSpillere[0] = new Spiller(testNavne[0]);
        testSpillere[1] = new Spiller(testNavne[1]);



        testSpil = new Spil(testNavne);
    }

    @Test
    void SpillereTest() {
        testSpil.setSpillere(testSpillere);
        assertTrue(testSpil.getSpillere() == testSpillere);
    }
}