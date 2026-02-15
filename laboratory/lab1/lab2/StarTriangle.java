package lab1.lab2;

import java.util.Scanner;

public class StarTriangle {
    private int width;
    public StarTriangle(int width) {
        this.width = width;
    }
    public void star() {
        for (int i = 1; i <= width; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("[*]");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter width of triangle: ");
        int w = sc.nextInt();

        StarTriangle triangle = new StarTriangle(w);
        triangle.star();
    }
}