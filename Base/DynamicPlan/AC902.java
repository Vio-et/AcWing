import java.util.*;

public class AC902 {
    final static int N = 1010;
    static int f[][] = new int[N][N];
    static char a[] = new char[N];
    static char b[] = new char[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String t = sc.nextLine(), A = sc.nextLine();
        int m = sc.nextInt();
        t = sc.nextLine();
        String B = sc.nextLine();

        for (int i = 1; i <= n; i++) {
            a[i] = A.charAt(i - 1);
            f[i][0] = i;
        }
        
        for (int j = 1; j <= m; j++) {
            b[j] = B.charAt(j - 1);
            f[0][j] = j;
        }
            
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i] != b[j])
                    f[i][j] = f[i - 1][j - 1] + 1;
                else
                    f[i][j] = f[i - 1][j - 1];

                f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
                f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
            }
        }
        
        System.out.println(f[n][m]);

        sc.close();
    }
}
