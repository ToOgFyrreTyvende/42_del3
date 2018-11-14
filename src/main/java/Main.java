import java.util.Arrays;
import java.util.Scanner;

/**
 * ------------------------------------------------------------/ 
 * Dette er hovedklassen som starter spillet.
 * ------------------------------------------------------------/
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SpilController spilCont;
        String spiller1;
        String spiller2;

        System.out.println(Feltliste.feltTekst.getString("WelcomePlayer"));

        System.out.print(Feltliste.feltTekst.getString("Player1"));
        spiller1 = scanner.nextLine();

        System.out.print(Feltliste.feltTekst.getString("Player2"));
        spiller2 = scanner.nextLine();

        spilCont = new SpilController(spiller1, spiller2);
        inputLoop(scanner, spilCont);
    }

    public static void inputLoop(Scanner scanner, SpilController spil){
        boolean aktivt = spil.spilAktivt();
        boolean afsluttet = false;
        System.out.println(Feltliste.feltTekst.getString("GameBegin"));

        do {
            String aktivSpillerNavn = spil.getAktivSpiller();
            
            if(aktivt){
                System.out.println(aktivSpillerNavn + Feltliste.feltTekst.getString("PlayerTurn"));
            }

            if(scanner.hasNextLine()){
                if(!aktivt){
                    System.out.println(spil.getSlutTekst());
                    afsluttet = true;
                }else{
                    String spilTekst = spil.kastTerning();
                    System.out.println(spilTekst);
                }

                aktivt = spil.spilAktivt();
                scanner.nextLine();
            }else{
                scanner.nextLine();
                // Vi bruger \r, eller carriage return, for at overskrive
                // samme linje hvis funktionskaldet bliver kaldt flere gange uden brugerinput
                System.out.print(Feltliste.feltTekst.getString("CorrectInput"));
            }
        }while (aktivt || !afsluttet);
    }

}
