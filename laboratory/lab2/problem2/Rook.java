package problem2;

public class Rook extends Piece {
    
    public Rook(Position position, boolean isWhite) {
        super(position, isWhite);
    }
    
    @Override
    public boolean isLegalMove(Position b) {
        // Ладья ходит по горизонтали или вертикали
        // и не может оставаться на месте
        return isDifferentPosition(b) && 
               (position.sameRow(b) || position.sameColumn(b));
    }
    
    @Override
    public String toString() {
        return (isWhite ? "White" : "Black") + " Rook at " + position;
    }
}