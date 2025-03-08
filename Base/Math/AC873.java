package Base.Math;

import java.util.Scanner;

public class AC873 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            int a = sc.nextInt();

            System.out.println(get_euler(a));
        }

        sc.close();
    }
    // 公式法求欧拉函数
    public static long get_euler(int a) {
        long euler = a;

        for (int i = 2; i <= a / i; i++) {
            if (a % i == 0) {
                euler = (euler * (i - 1)) / i;

                while (a % i == 0)
                    a /= i;
            }
        }
        
        if(a > 1)
            euler = (euler * (a - 1)) / a;

        return euler;
    }
}
