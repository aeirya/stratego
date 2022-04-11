package stratego.controller;

import stratego.action.MoveCommand;
import stratego.model.GameState;
import stratego.model.Grid;
import stratego.model.PieceType;

public class GuiController implements IGuiController, Updatable {

    private Updatable gui;
    private IBoard board;

    private PieceType piece;
    
    private Grid first;
    private Grid second;

    private static final boolean DEBUG = true;

    /* main panel pieces */
    public void onPieceButtonClicked(GuiClickEvent event) {
        if (first == null) {
            if (event.piece == null
             && !(event.x == 0 && event.y == 0)
            ) return;

            first = new Grid(event.x, event.y);
            piece = event.piece;

            if (DEBUG)
                System.out.println(event.piece);
        }
        else {
            if (DEBUG)
                System.out.println(event.piece);

            second = new Grid(event.x, event.y);

            if (second.equals(first)) {
                second = null;
                return;
            }

            new MoveCommand(piece, first, second).play(board);

            first = null;
            second = null;
        }

        this.update(board.getState());
    }


    public void setGui(Updatable gui) {
        this.gui = gui;
    }

    @Override
    public void update(GameState state) {
        gui.update(state);
    }

    public void setCore(IBoard board) {
        this.board = board;
    }
}
