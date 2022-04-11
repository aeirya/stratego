package stratego.model;

public enum PlayerColor {
    BLUE, RED;

    public PlayerColor flip() {
        switch (this) {
            case RED:
            return BLUE;
            case BLUE:
            return RED;
            default:
            return null;
        }
    }
}