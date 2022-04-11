package stratego.gui;

import javax.swing.JFrame;

import stratego.model.GameState;
import stratego.controller.IGuiController;
import stratego.controller.Updatable;
import stratego.gui.components.panel.WindowPane;

public class Window extends JFrame implements Updatable {
    private final WindowPane pane;
    
    public Window(IGuiController controller) {
        controller.setGui(this);

        this.setVisible(true);
        this.setSize(new java.awt.Dimension(500, 500));

        this.setLayout(null);

        pane = new WindowPane(controller);
        this.setContentPane(pane);
    }

    @Override
    public void update(GameState state) {
        pane.update(state);
    }
}