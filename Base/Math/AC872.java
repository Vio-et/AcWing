package Base.Math;

import java.util.Scanner;

public class AC872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();

            System.out.println(gcd(a, b));
        }

        sc.close();
    }
    // 求最大公约数
    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
