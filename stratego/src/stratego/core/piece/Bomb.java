package stratego.core.piece;

import stratego.model.Grid;
import stratego.model.Piece;
import stratego.model.PieceType;
import stratego.model.PlayerColor;

public class Bomb extends Piece {

    public Bomb(PlayerColor color) {
        super(PieceType.BOMB, color);
    }

    @Override
    public boolean canGo(Grid from, Grid to) {
        return false;
    }
}
