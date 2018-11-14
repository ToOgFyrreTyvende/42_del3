public class Spil {
    private Spiller[] spillere;
    private Board board;
    private Kort[] kort;

    public Spil() { }

    public Spil(Spiller[] spillere, Kort[] kort, Felt[] felter) {
        this.spillere = spillere;
        this.kort = kort;
        this.board = new Board(felter);
    }

}
