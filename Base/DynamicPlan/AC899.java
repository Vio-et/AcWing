import java.util.*;

public class AC899 {
    final static int N = 1010;
    static String strs[] = new String[N];
    static int f[][] = new int[N][N];
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            strs[i] = sc.next();

        while(m-- > 0){
            String targetStr = sc.next();
            int cnt = 0, limitDistance = sc.nextInt();

            for(int i = 0; i < n; i++){
                if(getDistance(i, targetStr) <= limitDistance)
                    cnt++;
            }

            System.out.println(cnt);
        }

        sc.close();
    }

    public static int getDistance(int idx, String targetStr){
        String originStr = strs[idx];
        int n = originStr.length(), m = targetStr.length();

        for(int i = 1; i <= n; i++)
            f[i][0] = i;
            
        for(int j = 1; j <= m; j++)
            f[0][j] = j;
            
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(originStr.charAt(i - 1)!= targetStr.charAt(j - 1))
                    f[i][j] = f[i - 1][j - 1] + 1;
                else
                    f[i][j] = f[i - 1][j - 1];

                f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
                f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
            }
        }

        return f[n][m];
    }
}
