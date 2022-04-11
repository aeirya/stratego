package stratego.gui.components;

import java.awt.Component;

import javax.swing.JComponent;

import stratego.controller.Updatable;
import stratego.gui.components.button.Button;
import stratego.model.GameState;

public class MyComponent extends Component implements Updatable {
    
    public MyComponent(Button button) {
        this(button, button);
    }
    
    public MyComponent(JComponent comp, Updatable updatable) {

    }

    @Override
    public void update(GameState state) {
        
    }
}
