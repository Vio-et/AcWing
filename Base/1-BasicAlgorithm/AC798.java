import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class AC798 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");

        final int N = 1010;

        int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]), q = Integer.parseInt(str[2]), a[][] = new int[N][N], b[][] = new int[N][N];

        for(int i = 1; i <= n; i++){
            str = reader.readLine().split(" ");
            for(int j = 1; j <= m; j++){
                a[i][j] = Integer.parseInt(str[j - 1]);

                insert(b, i, j, i, j, a[i][j]);
            }
        }
            
        
        while(q > 0){
            str = reader.readLine().split(" ");
            int x1 = Integer.parseInt(str[0]), y1 = Integer.parseInt(str[1]), x2 = Integer.parseInt(str[2]), y2 = Integer.parseInt(str[3]), c = Integer.parseInt(str[4]);

            insert(b, x1, y1, x2, y2, c);

            q --;
        }
                
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + b[i][j];
                
                writer.write(a[i][j] + " ");
            }
            writer.write('\n');
        }

        writer.flush();
        reader.close();
        writer.close();
    }

    private static void insert(int[][] b, int x1, int y1, int x2, int y2, int c){
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c; 
    }
}
