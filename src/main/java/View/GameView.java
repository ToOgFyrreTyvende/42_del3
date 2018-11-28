package View;

import Model.Spil;
import Model.Spiller;

public abstract class GameView {


    public abstract void setSpillere(Spiller[] spillere);
    public abstract int getAntalSpillere();
    public abstract String getSpillerNavn(int nr);
    public abstract String getRundeValg(String ... valg);
    public abstract String getRundeValgMedTekst(String tekst, String ... valg);
    public abstract void resetBoard();
    public abstract void setSpillerFelt(Spiller spiller, int felt);
    public abstract void setSpillerPenge(Spiller spiller, int penge);
    public abstract void opdaterSpillerData(Spiller spiller);
    public abstract void slutTekst(String tekst);

}
