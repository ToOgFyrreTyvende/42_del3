import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author andersm
 *
 * Tester Feltliste udfra den danske oversættelse
 */

public class FeltlisteTest {

    @Test
    void getFeltPengeTest() {
        // Vi tester om getFeltPenge får den korrekte værdi på 2 forskellige felter
        int testPenge = 250;
        int testPenge2 = -50;
        assertEquals(testPenge, Feltliste.getFeltPenge(0));
        assertEquals(testPenge2, Feltliste.getFeltPenge(9));
    }

    @Test
    void getFeltTekstTest() {
        // Vi tjekker at getFeltTekst finder den korrekte string i et arbitrært felt
        String testTekst = "Du snubler og taber 80 guld ned i Hullet.";
        assertEquals(testTekst, Feltliste.getFeltTekst(9));
    }

    @Test
    void getEkstraTurTest() {
        // Vi tester om getEkstraTur kun returnerer 'true' ved felt 10 (8 i arrayet)
        assertEquals(true, Feltliste.getEkstraTur(8));
        assertEquals(false, Feltliste.getEkstraTur(2));
    }
}
