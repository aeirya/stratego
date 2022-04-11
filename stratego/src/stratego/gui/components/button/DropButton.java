package stratego.gui.components.button;

import stratego.controller.IGuiController;
import stratego.model.GameState;
import stratego.model.PieceType;
import stratego.model.PlayerColor;
import java.awt.Color;

public class DropButton extends PieceButton {
    
    public DropButton(PieceType pieceType, PlayerColor color, IGuiController controller) {
        super(controller, 0, 0);
        this.pieceType = pieceType;
        this.color = color;

        setForeground(color.equals(PlayerColor.RED)? new Color(200, 0, 0) : new Color(0, 0, 200));
    }

    @Override
    public void update(GameState state) {
        setText(findText(pieceType));
    }
}
