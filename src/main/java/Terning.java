/**
 * ------------------------------------------------------------/
 * Denne klasse bruges til at kaste 'x' antal terninger
 * med 'x' antal sider på hver
 * 
 * Klassen kaldes uden nogle parametre, eller med to parametre
 * fx. Terning() eller Terning(antalSider, antal)
 * hvor 'antalSider' er antallet af sider på terningen
 * og 'antal' er antallet af terninger der kastes.
 * ------------------------------------------------------------/
 */

public class Terning {
    private int resultat;
    private int antalSider, antal;

    // #----------Constructor----------#
    Terning() {
        this.antalSider = 6;
        this.antal = 2;
    }
    Terning(int antalSider, int antal) {
        this.antalSider = antalSider;
        this.antal = antal;
    }
    
    // #--------------Get--------------#
    int[] getResultat(){ // Returner en værdi af terningen.
        int[] kast = new int[antal+1];
        int sum = 0;
        for (int i = 0 ; i < antal ; i++){
            float _random1 = (float) Math.random();         // 0-1 float
            int _random2 = (int) (_random1 * antalSider);   // 0-5 integer
            int random = _random2 + 1;                      // 1-6 integer
            kast[i] = random;
            sum += random;
        }
        kast[kast.length-1] = sum;
        return kast;
    }

    public int getAntalSider() {
        return antalSider;
    }

    public int getAntal() {
        return antal;
    }
}
