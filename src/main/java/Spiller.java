public class Spiller implements SpilFase {
    private String navn;
    private int penge;

    public Spiller(String navn) {
        this.navn = navn;
    }

    @Override
    public void naeste() {

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

    public void setPenge(int penge) {
        this.penge = penge;
    }
}
