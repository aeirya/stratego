package stratego.util.piece;

import stratego.core.piece.Bomb;
import stratego.core.piece.Diffuser;
import stratego.core.piece.Flag;
import stratego.core.piece.Scout;
import stratego.core.piece.Spy;
import stratego.core.piece.Tile;
import stratego.model.Piece;
import stratego.model.PieceType;
import stratego.model.PlayerColor;

public class PieceFactory {

    private PieceFactory() { }
    
    public static Piece createPiece(PieceType type, PlayerColor color) {
        switch (type) {
            case SPY:
            return new Spy(color);

            case DIFFUSER:
            return new Diffuser(color);

            case SCOUT:
            return new Scout(color);

            case BOMB:
            return new Bomb(color);

            case FLAG:
            return new Flag(color);

            case TILE:
            return new Tile();

            default:
            return new Piece(type, color);
        }
    }
}
