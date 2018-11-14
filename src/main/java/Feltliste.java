import java.util.Locale;
import java.util.ResourceBundle;

public class Feltliste{
    public static String locale_l = "da";
    public static String locale_s = "DK";

    public static Locale locale = new Locale(locale_l, locale_s);

    // Dette er en resource bundle, hvilket er en måde at hente tekst
    // ud fra et udgangpsunkt i forskellige sprog. Sproget er defineret ved
    // et "locale" der eksempelvis er da-DK (dansk, Danmark)
    public static ResourceBundle feltTekst =
            ResourceBundle.getBundle("Translation", locale);


    /*
    * FeltListen er defineret således, at:
    * 1. element: Resource bundlens udgangspunkt så oversættelser kan findes.
    * 2. element: Forskellen der tilføjes på pengebeholdningen.
    * 3. element: Hvor vidt der gives en ekstra tur eller ej.
    * */
    static private String[][] feltliste = {
        {"Tower", "250","false"},
        {"Crater", "-100","false"},
        {"PalaceGates","100","false"},
        {"ColdDesert","-20","false"},
        {"WalledCity","180","false"},
        {"Monastery","0","false"},
        {"Blackcave","-70","false"},
        {"HutsMountain","60","false"},
        {"Werewall","-80","true"},
        {"Pit","-50","false"},
        {"Goldmine","650","false"}
    };

    // #--------------Get--------------#
    static int getFeltPenge(int felt){
        int penge = Integer.parseInt(feltliste[felt][1]);
        return penge;
    }

    static String getFeltTekst(int felt){
        return feltTekst.getString(feltliste[felt][0]);
    }

    static boolean getEkstraTur(int felt){
        return Boolean.parseBoolean(feltliste[felt][2]);
    }

}