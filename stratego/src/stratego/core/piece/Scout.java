package stratego.core.piece;

import stratego.model.Grid;
import stratego.model.Piece;
import stratego.model.PieceType;
import stratego.model.PlayerColor;

public class Scout extends Piece {
    public Scout(PlayerColor color) {
        super(PieceType.SCOUT, color);
    }

    @Override
    public boolean canGo(Grid from, Grid to) {
        return from.x == to.x || from.y == to.y;
    }
}
