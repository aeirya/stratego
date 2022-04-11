package stratego.core.piece;

import stratego.model.Piece;
import stratego.model.PieceType;
import stratego.model.PlayerColor;

public class Spy extends Piece {
    public Spy(PlayerColor color) {
        super(PieceType.SPY, color);
    }
    
    @Override
    public boolean canHit(Piece other) {
        return super.canHit(other) || other.hasType(PieceType.GENERAL);
    }
}
