package Base.Math;

import java.util.HashMap;
import java.util.Scanner;

public class AC870 {
    final static int MOD = 1000000007;
    static HashMap<Integer, Integer> primes = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long res = 1;

        while (n-- > 0) {
            int a = sc.nextInt();

            get_approximate_num(a);
        }
        // 约数个数 = (a1+1)(a2+1)...(ak+1)
        for (Integer a : primes.values()) {

            res = (res * (a + 1)) % MOD;
        }

        System.out.println(res);

        sc.close();
    }
    // 分解质因数
    public static void get_approximate_num(int a) {
        for (int i = 2; i <= a / i; i++) {
            if (a % i == 0) {
                while (a % i == 0) {
                    a /= i;

                    if (primes.get(i) != null)
                        primes.put(i, primes.get(i) + 1);
                    else
                        primes.put(i, 1);
                }
            }
        }
        
        if (a > 1) {
            if(primes.get(a) != null)
                primes.put(a, primes.get(a) + 1);
            else 
                primes.put(a, 1);
        }
    }
}
