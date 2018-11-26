package Model;

/**
 * ------------------------------------------------------------/
 * Denne klasse bruges til at kaste 'x' antal terninger
 * med 'x' antal sider på hver
 * 
 * Klassen kaldes uden nogle parametre, eller med to parametre
 * fx. Model.Terning() eller Model.Terning(antalSider, antal)
 * hvor 'antalSider' er antallet af sider på terningen
 * og 'antal' er antallet af terninger der kastes.
 * ------------------------------------------------------------/
 */

public class Terning {
    private int antalSider, antal;

    // #----------Constructor----------#
    public Terning() {
        this.antalSider = 6;
        this.antal = 1;
    }
    public Terning(int antalSider, int antal) {
        this.antalSider = antalSider;
        this.antal = antal;
    }

    // #--------------Get--------------#
    public int getResultat(){
        int sum = 0;
            float _random1 = (float) Math.random();         // 0-1 float
            int _random2 = (int) (_random1 * antalSider);   // 0-5 integer
            sum = _random2 + 1;                      // 1-6 integer
        return sum;
    }
    public int getAntalSider() {
        return antalSider;
    }

/*    public int[] getResultat(){ // Returner en værdi af terningen.
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
    }   */

    public int getAntal() {
        return antal;
    }
}
