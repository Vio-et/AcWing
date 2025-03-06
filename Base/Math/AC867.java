package Base.Math;

import java.util.Scanner;

public class AC867 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        while (n-- > 0) {
            int a = scanner.nextInt();

            divide(a);
        }

        scanner.close();
    }

    public static void divide(int a) {
        for (int i = 2; i <= a / i; i++) {
            if (a % i == 0) {
                int cnt = 0;

                while (a % i == 0) {
                    a /= i;
                    cnt++;
                }

                System.out.println(i + " " + cnt);
            }
        }
        // a最后剩余的部分即为最后一个质因子
        if(a > 1)
            System.out.println(a + " " + 1);

        System.out.println("");
    }
}
