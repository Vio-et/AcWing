import java.util.*;

public class AC897 {
    final static int N = 1010;
    static char a[] = new char[N];
    static char b[] = new char[N];
    static int f[][] = new int[N][N];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        String t = sc.nextLine(), A = sc.nextLine(), B = sc.nextLine();

        for (int i = 1; i <= n; i++)
            a[i] = A.charAt(i - 1);

        for (int j = 1; j <= m; j++)
            b[j] = B.charAt(j - 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);

                if (a[i] == b[j])
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
            }
        }
        
        System.out.println(f[n][m]);

        sc.close();
    }    
}
