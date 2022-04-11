package stratego.util.board;

import stratego.model.Board;
import stratego.model.Grid;
import stratego.model.Piece;
import stratego.model.PieceType;
import stratego.model.PlayerColor;

public class SampleState1 {
    public Board get() {
        return new BoardBuilder()
        .add(Grid.of(3, 5), PieceType.TILE)
        .setColor(PlayerColor.RED)
        .add(Grid.of(2, 2), PieceType.DIFFUSER)
        .add(Grid.of(2, 3), PieceType.FIVE)
        .add(Grid.of(2, 4), PieceType.BOMB)
        .add(Grid.of(8, 4), PieceType.GENERAL)
        .setColor(PlayerColor.BLUE)
        .add(Grid.of(2, 8), PieceType.DIFFUSER)
        .add(Grid.of(2, 5), PieceType.BOMB)
        .add(Grid.of(4, 4), PieceType.FIVE)
        .add(Grid.of(6, 4), PieceType.SCOUT)
        .add(Grid.of(8, 3), PieceType.SPY)
        .build();
    }
}
