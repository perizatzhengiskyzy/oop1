package oop1.practice.p2;

public class prog1_lab2 {

    private int count;

    public prog1_lab2(int cnt) {
        this.count = cnt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= i; j++) {
                sb.append("[*]");
            }
            if (i < count) sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	prog1_lab2 small = new prog1_lab2(3);
        System.out.println(small);
    }
}
