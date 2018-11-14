import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class spillerTest {
    Spiller spiller = new Spiller("Test");

    @Test
    void spillerInitTest(){
        String testTekst = "kontrolNavn";
        spiller = new Spiller(testTekst);
        assertEquals(testTekst, spiller.getNavn());
    }

    @Test
    void spillerFeltTest(){
        int testFelt = 3;
        spiller.setFelt(testFelt);
        assertEquals(testFelt, spiller.getFelt());
    }

    @Test
    void spillerKontoTest(){
        int testEkstraPenge = 100;
        spiller.addPenge(testEkstraPenge);
        // Vi tilføjer 1000 til ekstra pengene, siden en spiller starter med 1000 guld
        assertEquals(testEkstraPenge + 1000, spiller.getPenge());
    }

}
