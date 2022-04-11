package stratego.model;

import java.util.EnumMap;
import java.util.Map;

import stratego.controller.IBoard;
import stratego.util.piece.PieceFactory;

public class Board implements IBoard {
    private final Map<Grid, Piece> pieces;
    private final EnumMap<PlayerColor, Player> players;
    private PlayerColor turn;

    private static boolean isDebug = true;

    public Board(Map<Grid, Piece> pieces) {
        this.pieces = pieces;
        
        players = new EnumMap<>(PlayerColor.class);
        players.put(PlayerColor.RED, new Player(PlayerColor.RED));
        players.put(PlayerColor.BLUE, new Player(PlayerColor.BLUE));

        turn = PlayerColor.RED;
    }

    public Piece get(Grid g) {
        return pieces.getOrDefault(g, null);
    }

    public int getPieceID(Grid g) {
        Piece piece = get(g);
        if (piece == null) return 0;
        return piece.getId();
    }

    public PlayerColor getPieceColor(Grid g) {
        return get(g).getColor();
    }

    private Player getPlayer(PlayerColor color) {
        return players.get(color);
    }

    public boolean drop(PieceType piece, Grid to) {
        if (!isFree(to)) return false;
        set(to, PieceFactory.createPiece(piece, turn));
        
        turn = turn.flip();
        return true;
    }

    @Override
    public boolean play(Grid from, Grid to) {
        if (!play(turn, from, to)) return false;

        turn = turn.flip();
        return true;
    }

    private boolean play(PlayerColor playerType, Grid from, Grid to) {
        Piece piece = get(from);
        
        if (piece == null) return false;
    
        Piece toHit = get(to);
        Player player = getPlayer(playerType);
    
        if (!player.owns(piece)) {
            if (isDebug) System.out.println("wrong player turn");
            return false;
        }

        if (!piece.canGo(from, to)) {
            if (isDebug) System.out.println("can't go");
            return false;
        }

        if (from.to(to).anyMatch(g -> !isFree(g))) {
            return false;
        }
        
        if (toHit != null) {
            if (toHit.hasColor(playerType)) {
                if (isDebug) System.out.println("can't hit");
                return false;
            }
            if (toHit.hasType(PieceType.TILE))
                return false;
        }

        play(player, from, to, piece, toHit);

        return true;
    }

    private void play(Player player, Grid from, Grid to, Piece piece, Piece toHit) {
        if (piece.canHit(toHit)) {
            capture(player, to);
            set(to, piece);
        }

        if (piece.ifDies(toHit)) {
            capture(getPlayer(player.getColor().flip()), from);
        }

        set(from, null);

        if (isDebug) System.out.println("play done");
    }

    private boolean isFree(Grid g) {
        return get(g) == null;
    }

    private void capture(Player player, Grid g) {
        // do nothing
    }

    private void set(Grid g, Piece piece) {
        pieces.put(g, piece);
    }

    public GameState getState() {
        return new GameState(this);
    }
}
