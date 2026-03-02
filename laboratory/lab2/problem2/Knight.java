package problem2;

public class Knight extends Piece {
    
    public Knight(Position position, boolean isWhite) {
        super(position, isWhite);
    }
    
    @Override
    public boolean isLegalMove(Position b) {
        // Конь ходит буквой "Г": (2,1) или (1,2)
        int dx = Math.abs(position.getX() - b.getX());
        int dy = Math.abs(position.getY() - b.getY());
        
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
    
    @Override
    public String toString() {
        return (isWhite ? "White" : "Black") + " Knight at " + position;
    }
}