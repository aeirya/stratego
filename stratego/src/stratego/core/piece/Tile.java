package stratego.core.piece;

import stratego.model.Grid;
import stratego.model.Piece;
import stratego.model.PieceType;
import stratego.model.PlayerColor;

public class Tile extends Piece {

    public Tile() {
        super(PieceType.TILE, PlayerColor.BLUE);
    }

    @Override
    public boolean canGo(Grid from, Grid to) {
        return false;
    }
}
