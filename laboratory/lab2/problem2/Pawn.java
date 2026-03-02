package problem2;

public class Pawn extends Piece {
    
    public Pawn(Position position, boolean isWhite) {
        super(position, isWhite);
    }
    
    @Override
    public boolean isLegalMove(Position b) {
        int dx = b.getX() - position.getX();
        int dy = b.getY() - position.getY();
        
        // Белые пешки ходят вверх (увеличение y), черные - вниз (уменьшение y)
        if (isWhite) {
            // Первый ход может быть на 2 клетки
            if (position.getY() == 2 && dy == 2 && dx == 0) return true;
            // Обычный ход на 1 клетку вперед
            if (dy == 1 && dx == 0) return true;
            // Взятие фигуры по диагонали
            if (dy == 1 && Math.abs(dx) == 1) return true;
        } else {
            // Черные пешки
            if (position.getY() == 7 && dy == -2 && dx == 0) return true;
            if (dy == -1 && dx == 0) return true;
            if (dy == -1 && Math.abs(dx) == 1) return true;
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return (isWhite ? "White" : "Black") + " Pawn at " + position;
    }
}