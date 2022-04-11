package stratego.gui.components.button;

import java.awt.Color;

import stratego.controller.IGuiController;
import stratego.controller.IPieceButton;
import stratego.controller.PieceButtonMouseAdapter;
import stratego.model.GameState;
import stratego.model.Grid;
import stratego.model.PieceType;
import stratego.model.PlayerColor;

public class PieceButton extends Button implements IPieceButton {

    private final Grid g;
    protected PieceType pieceType;
    protected PlayerColor color;

    public PieceButton(IGuiController controller, int x, int y) {
        pieceType = null;

        g = new Grid(x, y);
        addMouseListener(new PieceButtonMouseAdapter(x, y, this, controller));
        setFocusable(false);
    }

    @Override
    public void update(GameState state) {
        pieceType = state.getPieceType(g);
        if (pieceType != null) {
            color = state.board.getPieceColor(g);
            setForeground(color == PlayerColor.RED ? new Color(200, 0, 0) : new Color(0, 0, 200));
            setText(findText(pieceType));
        }
        else 
            setText("");
    }

    protected String findText(PieceType piece) {
        switch(piece) {
            case BOMB:
            return "BOMB";
            case TILE:
            case FLAG:
            return piece.toString();
            default:
            return piece.id + "";
        }
    }

    public boolean isFree() {
        return pieceType == null;
    }

    @Override
    public PieceType getPiece() {
        return pieceType;
    }
}
