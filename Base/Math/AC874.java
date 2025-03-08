package Base.Math;

import java.util.Arrays;
import java.util.Scanner;

public class AC874 {
    final static int N = 1000010;
    static int primes[] = new int[N];
    static int phi[] = new int[N];
    static boolean st[] = new boolean[N];
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(get_euler(n));

        sc.close();
    }
    // 筛法求欧拉函数
    public static long get_euler(int n) {
        long euler = 0;

        Arrays.fill(st, true);
        phi[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (st[i]) {
                phi[i] = i - 1;
                primes[cnt++] = i;
            }

            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = false;

                if (i % primes[j] == 0) {
                    phi[primes[j] * i] = primes[j] * phi[i];
                    break;
                } 
                else
                    phi[primes[j] * i] = phi[i] * (primes[j] - 1);
            }
        }
        
        for(int i = 1; i <= n; i++)
            euler += phi[i];

        return euler;
    }
}
