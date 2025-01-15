package Base.DataStructure;

import java.util.Scanner;

public class AC828 {
    final static int N = 100010;
    static int[] stack = new int[N];
    static int tt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();

        while (m-- > 0) {
            String op = scanner.next();

            if (op.equals("push")) {
                int x = scanner.nextInt();
                push(x);
            }
            else if(op.equals("pop"))
                pop();
            else if (op.equals("empty")) {
                if (isEmpty())
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            else if (op.equals("query")) {
                System.out.println(query());
            }
        }

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

    public static int query() {
        return stack[tt - 1];
    }
}
