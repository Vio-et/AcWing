package Base.Math;

import java.util.Arrays;
import java.util.Scanner;

public class AC868 {
    final static int N = 1000010;
    static int prime[] = new int[N];
    static boolean st[] = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(line_get_primes(n));

        sc.close();
    }
    // 线性筛法 筛质数
    public static int line_get_primes(int n) {
        int cnt = 0;
        
        Arrays.fill(st, true);

        for (int i = 2; i <= n; i++) {
            if (st[i]) 
                prime[cnt++] = i;
            // 边界为 prime[j] * i <= n
            for (int j = 0; prime[j] <= n / i; j++) {
                st[prime[j] * i] = false;

                if(i % prime[j] == 0)
                    break;
            }
        }

        return cnt;
    }
}
