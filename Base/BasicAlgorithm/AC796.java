import java.util.Scanner;

public class AC796 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
        int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
        int a[][] = new int[n + 1][m + 1], s[][] = new int[n + 1][m + 1];

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                a[i][j] = scanner.nextInt();
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + a[i][j];
            }
        }

        while(q > 0){
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();

            System.out.println(s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1]);
            
            q --;
        }

        scanner.close();
    } 
}
