package stratego.model;

public class GameState {
    public final Board board;

    public GameState(Board board) {
        this.board = board;
    }

    public PieceType getPieceType(Grid g) {
        if (board.get(g) == null) return null;
        return board.get(g).getType();
    }
}
