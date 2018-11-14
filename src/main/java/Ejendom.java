public class Ejendom extends Aktiv implements Felt {
    private int leje;

    public Ejendom (int position) {
        super(position);
    }


    @Override
    public void spillerLandet(Spiller s) {

    }


    public int getLeje() {
        return leje;
    }

    public void setLeje(int leje) {
        this.leje = leje;
    }
}
