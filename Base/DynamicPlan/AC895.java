import java.util.*;

public class AC895 {
    final static int N = 1010;
    static int a[] = new int[N];
    static int f[] = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), res = 0;

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            f[i] = 1;

            for (int j = 1; j <= i; j++) {
                if (a[j] < a[i])
                    f[i] = Math.max(f[i], f[j] + 1);
            }
            
            res = Math.max(f[i], res);
        }
            
        System.out.println(res);

        sc.close();
    }
}
