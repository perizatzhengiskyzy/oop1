package problem2;

public class Bishop extends Piece {
    
    public Bishop(Position position, boolean isWhite) {
        super(position, isWhite);
    }
    
    @Override
    public boolean isLegalMove(Position b) {
       
        return isDifferentPosition(b) && position.sameDiagonal(b);
    }
    
    @Override
    public String toString() {
        return (isWhite ? "White" : "Black") + " Bishop at " + position;
    }
}