/**
 * ------------------------------------------------------------/
 * Denne klasse holder styr på pengebeholdningen for
 * den spiller der kaldte denne klasse.
 * ------------------------------------------------------------/
 */

public class Konto {
    private int pengebeholdning;

    // #----------Constructor----------#
    Konto(){
        // Default pengebeholdning: 1000.
        pengebeholdning = 1000;
    }
    Konto(int pengebeholdning){
        // Vælg pengebeholdning selv.
        this.pengebeholdning = pengebeholdning;
    }

    // #--------------Get--------------#
    int getPenge(){
        // Returner pengebeholdning.
        return (pengebeholdning);
    }

    // #--------------Set--------------#
    void setPenge(int penge){
        this.pengebeholdning = penge; 
    }

    // #-------------Other-------------#
    int indsaetpenge(int penge){
        // Tilføj et antal penge til pengebeholdningen.
        if((pengebeholdning +  penge) > 0){
            pengebeholdning += penge;
            return (pengebeholdning);
        }else{
            return (pengebeholdning = 0);
        }
    }
}


