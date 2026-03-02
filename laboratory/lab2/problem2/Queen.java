package problem2;

public class Queen extends Piece {
    
    public Queen(Position position, boolean isWhite) {
        super(position, isWhite);
    }
    
    @Override
    public boolean isLegalMove(Position b) {
        // Ферзь ходит как ладья + слон
        return isDifferentPosition(b) && 
               (position.sameRow(b) || position.sameColumn(b) || position.sameDiagonal(b));
    }
    
    @Override
    public String toString() {
        return (isWhite ? "White" : "Black") + " Queen at " + position;
    }
}