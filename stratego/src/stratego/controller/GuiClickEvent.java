package stratego.controller;

import stratego.model.PieceType;

public class GuiClickEvent {
    public final int x;
    public final int y;
    public final PieceType piece;

    public GuiClickEvent(int x, int y, PieceType piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }
}
