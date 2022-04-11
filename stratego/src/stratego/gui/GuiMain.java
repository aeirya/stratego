package stratego.gui;

import stratego.controller.GuiController;
import stratego.model.Board;
import stratego.model.GameState;
import stratego.util.board.SampleState1;

public class GuiMain {
    public static void main(String[] args) {
        GuiController controller = new GuiController();
        Window window = new Window(controller);
        
        Board board = new SampleState1().get();
        
        controller.setCore(board);

        window.update(new GameState(board));
    }
}
