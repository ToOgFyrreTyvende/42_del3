import java.util.ArrayList;
import java.util.List;

public class Spiller {
    private String navn;
    private int penge;
    private List<Felt> properties = new ArrayList<Felt>();
//    private List<Dice> rolledDices = new ArrayList<Dice>();
    private List<Kort> cards = new ArrayList<Kort>();

    public Spiller(String navn) {
        this.navn = navn;
    }


    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getPenge() {
        return penge;
    }
    //void addDice (Dice dice) {
    //    rolledDices.add(dice);
    //}
    public void setPenge(int penge) {
        this.penge = penge;
    }
}
