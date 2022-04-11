package stratego.gui.components.panel;

import stratego.controller.IGuiController;
import stratego.gui.GuiConfig;
import stratego.gui.components.button.PieceButton;

import java.awt.GridLayout;
import java.util.stream.IntStream;

public class MainPanel extends Panel {

    public MainPanel(IGuiController controller) {
        setLayout(new GridLayout(GuiConfig.boardWidth, GuiConfig.boardHeight));
        setBackground(new java.awt.Color(100,50,200));

        IntStream.iterate(GuiConfig.boardHeight, i->i-1)
            .limit(GuiConfig.boardHeight)
            .forEach(j -> 
                IntStream.rangeClosed(1, GuiConfig.boardWidth)
                    .forEach(i ->
                        addComponent(new PieceButton(controller, i, j))
                    )
            );
    }
}
