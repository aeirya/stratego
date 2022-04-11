package stratego.gui.components.panel;

import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

import stratego.controller.Updatable;
import stratego.model.GameState;

public abstract class Panel extends JPanel implements Updatable {
    private final List<Updatable> children;

    protected Panel() {
        children = new ArrayList<>();
    }

    protected void addComponent(Updatable comp) {
        // be careful for the force convert
        this.add((Component) comp);
        children.add(comp);
    }
    
    public void addComponent(Updatable comp, Object constraints) {
        // be careful for the force convert
        this.add((Component) comp, constraints);
        children.add(comp);
    }

    @Override
    public void update(GameState state) {
        children.forEach(panel -> panel.update(state));
    }
}
