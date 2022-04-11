package stratego.gui;

public class GuiConfig {
    private static GuiConfig instance = new GuiConfig();

    private GuiConfig() { }

    public static GuiConfig getInstance() {
        return instance;
    }

    public static final int boardWidth = 10;
    public static final int boardHeight = 10;
}
