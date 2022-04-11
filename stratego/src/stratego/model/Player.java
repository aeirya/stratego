package stratego.model;

public class Player {
    private final PlayerColor color;

    public Player(PlayerColor color) {
        this.color = color;
    }

    public boolean owns(Piece piece) {
        return piece.hasColor(color);
    }

    public PlayerColor getColor() {
        return color;
    }

}
