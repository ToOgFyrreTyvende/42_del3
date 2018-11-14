import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpilTest {
    Spil spil = new Spil("test1", "test2");

    @Test
    void getAktivSpillerTest() {
        Spiller spillerKontrol = spil.getSpillere()[0];
        Spiller aktivSpiller = spil.getAktivSpiller();

        assertEquals(spillerKontrol, aktivSpiller);
    }

    @Test
    void vindTest(){
        // Vi tester efter, at spiller 1 vinder med 3000 guld, mens
        // spiller 2 har 2800
        Spiller[] spillere = spil.getSpillere();
        spillere[0].setPenge(3000);
        spillere[1].setPenge(2800);

        // Vi lader som om, at spiller 2 lige har færdiggjort sin tur, og tjekket efter
        // en vinder
        spil.checkRunde(1);

        // Hvis vinderen er ens med spiller 1, er testen fuldendt
        assertEquals(spillere[0], spil.getVinder());
        // I øvrigt skal spillet selvfølelig være afsluttet
        assertEquals(spil.spilAktivt(), false);
    }

    @Test
    void ekstraTur(){
        // Vi indstiller spilllet, således at spiller 1 får en ekstra tur
        // (spiller 1 lander på felt 8)
        int ekstraFelt = 8;
        Spiller[] spillere = spil.getSpillere();
        spillere[0].setFelt(ekstraFelt);
        boolean ekstraTur = Feltliste.getEkstraTur(ekstraFelt);

        // ekstraTur boolean skal være tur for, at spiller 1 har fået en ekstra runde
        assertEquals(true, ekstraTur);
    }

    @Test
    void fuldSpil(){
        // Vi gennemgår hele spillet til, at det afslutter helt
        boolean aktivt = true;
        do {
            // vi gennemgår en tur og tjekker om spillet stadigvæk er aktivt
            spil.spilTur();
            aktivt = spil.spilAktivt();
        }while (aktivt);

        Spiller[] s = spil.getSpillere();

        // Testen er successfuld hvis én af de to spillere har en pengebeholding
        // lig med eller større end mængden for at vinde.
        assertTrue(s[0].getPenge() >= spil.getVinderPenge()
                || s[1].getPenge() >= spil.getVinderPenge());
    }

}
