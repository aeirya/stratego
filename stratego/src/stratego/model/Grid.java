package stratego.model;

import java.util.stream.Stream;

public class Grid {
    public final int x;
    public final int y;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Grid of(int x, int y) {
        return new Grid(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Grid)) return false;
        Grid g = (Grid) obj;
        return x == g.x && y == g.y;
    }

    @Override
    public int hashCode() {
        return x * 100000 + y;
    }

    private Grid delta(Grid other) {
        return new Grid(other.x - x, other.y - y);
    }

    public boolean isNeighborWith(Grid other) {
        int dx = Math.abs(x - other.x);
        int dy = Math.abs(y - other.y);
        return dx == 1 ^ dy == 1;
    }

    private Grid next(Grid delta) {
        return new Grid(
            (int) (x + Math.signum(delta.x)), 
            (int) (y + Math.signum(delta.y))
            );
    }
    
    public Stream<Grid> to(Grid to) {
        Grid delta = this.delta(to);
        return Stream
            .iterate(this.next(delta), g -> ! g.equals(to), g -> g.next(delta));
    }

    public int dist(Grid to) {
        return Math.abs(x-to.x) + Math.abs(y-to.y);
    }
}
