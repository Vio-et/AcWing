import java.util.Scanner;

public class AC798 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        final int N = 1010;

        int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt(), a[][] = new int[N][N], b[][] = new int[N][N];

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++){
                a[i][j] = scanner.nextInt();

                insert(b, i, j, i, j, a[i][j]);
            }
        
        while(q > 0){
            int x1 = scanner.nextInt(), y1 = scanner.nextInt(), x2 = scanner.nextInt(), y2 = scanner.nextInt(), c = scanner.nextInt();

            insert(b, x1, y1, x2, y2, c);

            q --;
        }
                
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                 a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + b[i][j];
                 System.out.print(a[i][j] + " ");
            }
            System.out.print('\n');
        }
        
        scanner.close();
    }

    private static void insert(int[][] b, int x1, int y1, int x2, int y2, int c){
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c; 
    }
}
