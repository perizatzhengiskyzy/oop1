package problem2;

public class Position {
    private int x; 
    private int y; 
    
    public Position(int x, int y) {
        
        if (x < 1 || x > 8 || y < 1 || y > 8) {
            throw new IllegalArgumentException("Position must be between 1 and 8");
        }
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    @Override
    public String toString() {
        
        char file = (char) ('a' + x - 1);
        return "" + file + y;
    }
    
    
    public boolean sameRow(Position other) {
        return this.y == other.y;
    }
    
    
    public boolean sameColumn(Position other) {
        return this.x == other.x;
    }
    

    public boolean sameDiagonal(Position other) {
        return Math.abs(this.x - other.x) == Math.abs(this.y - other.y);
    }
}