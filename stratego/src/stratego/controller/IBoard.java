package stratego.controller;

import stratego.model.GameState;
import stratego.model.Grid;
import stratego.model.PieceType;

public interface IBoard {
    boolean play(Grid from, Grid to);
    boolean drop(PieceType type, Grid to);
    GameState getState();
}
