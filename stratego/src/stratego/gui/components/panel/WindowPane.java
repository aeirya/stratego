package stratego.gui.components.panel;

import stratego.controller.IGuiController;
import stratego.model.PlayerColor;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class WindowPane extends Panel {
    
    private final MainPanel mainPanel;

    public WindowPane(IGuiController controller) {
        mainPanel = new MainPanel(controller);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.weightx = 10;

        gbc.gridy = 0;
        gbc.weighty = 1;
        addComponent(new DropPane(controller, PlayerColor.BLUE), gbc);
        
        gbc.gridy = 1;
        gbc.weighty = 10;
        addComponent(mainPanel, gbc);
        
        gbc.gridy = 11;
        gbc.weighty = 1;
        addComponent(new DropPane(controller, PlayerColor.RED), gbc);
    }

    
}
