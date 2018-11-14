import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class kontoTest {

    @Test
    void getPengeTest() {
        Konto konto = new Konto();
        assertTrue(konto.getPenge() == 1000);

        Konto customKonto = new Konto(42);
        assertTrue(customKonto.getPenge() == 42);
    }

    @Test
    void setPengeTest() {
        Konto konto = new Konto();
        int testInt = 42;
        konto.setPenge(42);
        assertTrue(konto.getPenge() == testInt);
    }

    @Test
    void indsaetPengeTest(){
        Konto konto = new Konto();
        assertTrue(konto.getPenge() == 1000);

        konto.indsaetpenge(20);
        assertTrue(konto.getPenge() == 1020);

        konto.indsaetpenge(1);
        assertTrue(konto.getPenge() == 1021);

        konto.indsaetpenge(-21);
        assertTrue(konto.getPenge() == 1000);

        konto.setPenge(10);
        konto.indsaetpenge(-42);
        assertTrue(konto.getPenge() == 0);
    }

    @Test
    void customKontoTest() {
        Konto konto = new Konto(42);
        assertTrue(konto.getPenge() == 42);
    }
}
