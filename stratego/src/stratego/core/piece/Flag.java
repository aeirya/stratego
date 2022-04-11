package stratego.core.piece;

import stratego.model.Grid;
import stratego.model.Piece;
import stratego.model.PieceType;
import stratego.model.PlayerColor;

public class Flag extends Piece {

    public Flag(PlayerColor color) {
        super(PieceType.FLAG, color);
    }
    
    @Override
    public boolean canGo(Grid from, Grid to) {
        return false;
    }
}
