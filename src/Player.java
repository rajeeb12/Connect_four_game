public class Player {
    private String name;
    private GridPosition piece;

    public Player(String _n,GridPosition piece)
    {
        this.name = _n;
        this.piece = piece;
    }

    public String getName()
    {
        return this.name;
    }
    public GridPosition getPiece()
    {
        return this.piece;
    }

}
