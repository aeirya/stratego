package stratego.model;

public class Piece {
    private PieceType type;
    private PlayerColor color;
    
    public Piece(PieceType type, PlayerColor color) {
        this.type = type;
        this.color = color;
    }

    public boolean canGo(Grid from, Grid to) {
        return from.isNeighborWith(to);
    }

    public boolean canHit(Piece other) {
        if (other == null) return false;
        if (other.color == this.color) return false;
        return this.getPower() >= other.getPower();
    }
    
    public boolean ifDies(Piece other) {
        if (other == null) return false;
        if (other.color == this.color) return false;
        return 
            !canHit(other) ||
            other.getPower() == this.getPower();
    }

    public int getId() {
        return type.id;
    }

    private int getPower() {
        return getId();
    }

    public boolean hasType(PieceType type) {
        return type.equals(this.type);
    }

    public boolean isFlag() {
        return hasType(PieceType.FLAG);
    }

    public boolean hasColor(PlayerColor color) {
        return this.color == color;
    }

    public PlayerColor getColor() {
        return color;
    }

    public PieceType getType() {
        return type;
    }
}
