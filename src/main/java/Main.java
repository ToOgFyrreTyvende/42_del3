import Controller.SpilController;
import Model.*;
/**
 * ------------------------------------------------------------/ 
 * Dette er hovedklassen som starter spillet.
 * ------------------------------------------------------------/
 */

public class Main {
    public static void main(String[] args) {
        SpilController spil = new SpilController();

        Terning terning = new Terning();
        
        System.out.println(terning.getResultat());        
    }

}
