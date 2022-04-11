package stratego.core.piece;

import stratego.model.Piece;
import stratego.model.PieceType;
import stratego.model.PlayerColor;

public class Diffuser extends Piece {

    public Diffuser(PlayerColor color) {
        super(PieceType.DIFFUSER, color);
    }

    @Override
    public boolean canHit(Piece other) {
        return super.canHit(other) || (other != null && other.hasType(PieceType.BOMB));
    }
}