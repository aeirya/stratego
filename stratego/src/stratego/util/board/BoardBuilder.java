package stratego.util.board;

import java.util.HashMap;
import java.util.Map;

import stratego.model.Board;
import stratego.model.Grid;
import stratego.model.Piece;
import stratego.model.PieceType;
import stratego.model.PlayerColor;
import stratego.util.piece.PieceFactory;

public class BoardBuilder {
    private final Map<Grid, Piece> pieces;
    private PlayerColor color;

    public BoardBuilder() {
        pieces = new HashMap<>();
        color = PlayerColor.RED;
    }

    public BoardBuilder setColor(PlayerColor color) {
        this.color = color;
        return this;
    }

    public BoardBuilder add(Grid g, PieceType type) {
        pieces.put(g, PieceFactory.createPiece(type, color));
        return this;
    }

    public Board build() {
        return new Board(pieces);
    }
}
