package Base.Math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AC871 {
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
        // 求约数之和
        for (Map.Entry<Integer, Integer> entry : primes.entrySet()) {
            int p = entry.getKey(), a = entry.getValue();

            long t = 1;

            for (int i = 1; i <= a; i++)
                t = (t * p + 1) % MOD;

            res = (res * t) % MOD;
        }
        
        System.out.println(res);

        sc.close();
    }
    
    public static void get_approximate_num(int a) {
        for (int i = 2; i <= a / i; i++) {
            while (a % i == 0) {
                a /= i;

                if (primes.get(i) != null)
                    primes.put(i, primes.get(i) + 1);
                else
                    primes.put(i, 1);
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
