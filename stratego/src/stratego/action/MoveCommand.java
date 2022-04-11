package stratego.action;

import stratego.controller.IBoard;
import stratego.model.Grid;
import stratego.model.PieceType;

public class MoveCommand {
    private final PieceType piece;
    private final Grid from;
    private final Grid to;
    
    public MoveCommand(PieceType piece, Grid from, Grid to) {
        this.piece = piece;
        this.from = from;
        this.to = to;
    }

    public boolean play(IBoard board) {
        if(from.x == 0 && from.y == 0) return board.drop(piece, to);
        return board.play(from, to);
    }
}