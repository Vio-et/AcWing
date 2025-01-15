package Base.DataStructure;

import java.util.Scanner;

public class AC3302 {
    final static int N = 100010;
    static int[] stack = new int[N];
    static int tt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.close();
    }

    public static void push(int x) {
        stack[tt++] = x;
    }

    public static void pop() {
        tt--;
    }

    public static boolean isEmpty() {
        return (tt == 0);
    }
}
