package problem2;

public class King extends Piece {
    
    public King(Position position, boolean isWhite) {
        super(position, isWhite);
    }
    
    @Override
    public boolean isLegalMove(Position b) {
       
        int dx = Math.abs(position.getX() - b.getX());
        int dy = Math.abs(position.getY() - b.getY());
        
        return isDifferentPosition(b) && dx <= 1 && dy <= 1;
    }
    
    @Override
    public String toString() {
        return (isWhite ? "White" : "Black") + " King at " + position;
    }
}