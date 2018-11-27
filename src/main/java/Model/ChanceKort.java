package Model;
import java.util.Random;

public class ChanceKort {
    public static void main(String[] args) {
        String chanceString = null;
        Random r = new Random();
        int chanceKort = r.nextInt(14);

        switch (chanceKort) {
            case 1: chanceString = "Ryk frem til START. Modtag 2M.";
                break;
            case 2: chanceString = "Du har spist for meget slik. BETAL 2M til baken.";
                break;
            case 3: chanceString = "Du løslades uden omkostninger. " +
                    "Behold dette kort, indtil du får brug for det";
                break;
            case 4: chanceString = "Ryk frem til STRANDPROMENADEN";
                break;
            case 5: chanceString = "Det er din fødselsdag! Alle giver dig 1M. " +
                    "TILLYKKE MED FØDSELSDAGEN!";
                break;
            case 6: chanceString = "Du har lavet alle dine lektier. " +
                    "MODTAG 2M fra banken.";
                break;
            case 7: chanceString = "GRATIS FELT! Ryk frem til et ORANGE felt. " +
                    "Hvis det er ledig, får du det GRATIS! Ellers skal du BETALE leje til ejeren.";
                break;
            case 8: chanceString = "GRATIS FELT! Ryk frem til et GRØNT felt. " +
                    "Hvis det er ledig, får du det GRATIS! Ellers skal du BETALE leje til ejeren.";
                break;
            case 9: chanceString = "GRATIS FELT! Ryk frem til et LYSEBLÅT felt. " +
                    "Hvis det er ledig, får du det GRATIS! Ellers skal du BETALE leje til ejeren.";
                break;
            case 10: chanceString = "GRATIS FELT! Ryk frem til et PINK felt. " +
                    "Hvis det er ledig, får du det GRATIS! Ellers skal du BETALE leje til ejeren.";
                break;
            case 11: chanceString = "GRATIS FELT! Ryk frem til et MØRKEBLÅ felt. " +
                    "Hvis det er ledig, får du det GRATIS! Ellers skal du BETALE leje til ejeren.";
                break;
            case 12: chanceString = "GRATIS FELT! Ryk frem til et RØDT felt. " +
                    "Hvis det er ledig, får du det GRATIS! Ellers skal du BETALE leje til ejeren.";
                break;
            case 13: chanceString = "GRATIS FELT! Ryk frem til et BRUNT felt. " +
                    "Hvis det er ledig, får du det GRATIS! Ellers skal du BETALE leje til ejeren.";
                break;
            case 14: chanceString = "GRATIS FELT! Ryk frem til et GULT felt. " +
                    "Hvis det er ledig, får du det GRATIS! Ellers skal du BETALE leje til ejeren.";
                break;
        }


        System.out.println(chanceString);
    }
}