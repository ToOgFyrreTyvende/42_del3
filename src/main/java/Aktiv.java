public abstract class Aktiv implements Felt{
    private String navn;
    private int koebPris;
    private int lejPris;
    final private int position;
    private Spiller ejer;

    public Aktiv (int position) {
        this.position = position;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getKoebPris() {
        return koebPris;
    }

    public void setKoebPris(int koebPris) {
        this.koebPris = koebPris;
    }

    public int getLejPris() {
        return lejPris;
    }

    public void setLejPris(int lejPris) {
        this.lejPris = lejPris;
    }

    @Override
    public int getPosition() {
        return position;
    }

    public Spiller getEjer() {
        return ejer;
    }

    public void setEjer(Spiller ejer) {
        this.ejer = ejer;
    }
}
