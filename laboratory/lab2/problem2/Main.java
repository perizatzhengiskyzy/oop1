package problem2;

public class Main {
    public static void main(String[] args) {
      
        Position pos1 = new Position(1, 1); // a1
        Position pos2 = new Position(1, 3); // a3
        Position pos3 = new Position(3, 3); // c3
        Position pos4 = new Position(4, 4); // d4
        Position pos5 = new Position(2, 1); // b1
    
        
       
        Rook rook = new Rook(pos1, true);
        Bishop bishop = new Bishop(pos2, true);
        Queen queen = new Queen(pos4, true);
        King king = new King(pos4, false);
        Knight knight = new Knight(pos5, true);
        Pawn pawn = new Pawn(new Position(2, 2), true); // b2
        
        System.out.println("=== Тестирование шахматных фигур ===\n");
        
        // Тест ладьи
        System.out.println(rook);
        System.out.println("  может ли пойти на a3? " + rook.isLegalMove(pos2)); // true (вертикаль)
        System.out.println("  может ли пойти на c3? " + rook.isLegalMove(pos3)); // false (диагональ)
        
        // Тест слона
        System.out.println("\n" + bishop);
        System.out.println("  может ли пойти на c3? " + bishop.isLegalMove(pos3)); // true (диагональ)
        System.out.println("  может ли пойти на a1? " + bishop.isLegalMove(pos1)); // false (не диагональ)
        
        // Тест ферзя
        System.out.println("\n" + queen);
        System.out.println("  может ли пойти на a1? " + queen.isLegalMove(pos1)); // true (диагональ)
        System.out.println("  может ли пойти на d1? " + queen.isLegalMove(new Position(4, 1))); // true (вертикаль)
        
        // Тест короля
        System.out.println("\n" + king);
        System.out.println("  может ли пойти на d5? " + king.isLegalMove(new Position(4, 5))); // true (на 1)
        System.out.println("  может ли пойти на d6? " + king.isLegalMove(new Position(4, 6))); // false (на 2)
        
        // Тест коня
        System.out.println("\n" + knight);
        System.out.println("  может ли пойти на c3? " + knight.isLegalMove(pos3)); // true (2,1)
        System.out.println("  может ли пойти на a3? " + knight.isLegalMove(pos2)); // false (0,2)
        
        // Тест пешки
        System.out.println("\n" + pawn);
        System.out.println("  может ли пойти на b3? " + pawn.isLegalMove(new Position(2, 3))); // true (на 1)
        System.out.println("  может ли пойти на b4? " + pawn.isLegalMove(new Position(2, 4))); // true (первый ход на 2)
        System.out.println("  может ли пойти на c3? " + pawn.isLegalMove(new Position(3, 3))); // true (взятие)
        System.out.println("  может ли пойти на a3? " + pawn.isLegalMove(new Position(1, 3))); // true (взятие)
    }
}