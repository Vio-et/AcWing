import java.util.*;

public class AC900 {
    final static int N = 1010;
    final static int MOD = 1000000007;
    static int f[] = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        f[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                f[j] = (f[j] + f[j - i]) % MOD;
            }
        }
        
        System.out.println(f[n] % MOD);

        sc.close();
    }
}
