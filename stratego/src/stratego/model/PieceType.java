package stratego.model;

import java.util.Arrays;

public enum PieceType {
    SPY(1),
    SCOUT(2),
    DIFFUSER(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    GENERAL(10),
    BOMB(11),
    FLAG(0),
    TILE(12);
    
    public final int id;

    PieceType(int id) {
        this.id = id;
    }

    public static PieceType of(int id) {
        return Arrays.asList(values()).stream().filter(p -> p.id == id).findFirst().get();
    }
}
