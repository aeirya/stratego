package stratego.gui.components.panel;

import stratego.controller.IGuiController;
import stratego.gui.components.button.DropButton;
import stratego.model.PieceType;
import stratego.model.PlayerColor;

import java.awt.GridLayout;
import java.util.stream.IntStream;

public class DropPane extends Panel {
    
    public DropPane(IGuiController controller, PlayerColor color) {
        setLayout(new GridLayout(1, 11));

        IntStream.rangeClosed(0, 10)
            .forEach(
                i -> addComponent(
                    new DropButton(PieceType.of(i), color, controller)
                )
            );      
    }
}
