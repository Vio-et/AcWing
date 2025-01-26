import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AC831 {
    public static void main(String[] args) throws IOException{
        final int N = 100010;
        int next[] = new int[N];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String p = " " + reader.readLine();
        int m = Integer.parseInt(reader.readLine());
        String s = " " + reader.readLine();

        // 计算next数组 next[1] == 0
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && p.charAt(i) != p.charAt(j + 1))
                j = next[j];

            if (p.charAt(i) == p.charAt(j + 1))
                j++;

            next[i] = j;
        }
        
        for (int i = 1, j = 0; i <= m; i++) {
            while (j != 0 && s.charAt(i) != p.charAt(j + 1))
                j = next[j];

            if (s.charAt(i) == p.charAt(j + 1))
                j++;

            if (j == n) {
                writer.write(i - n + " ");
                j = next[j];
            }
        }
        
        writer.flush();
    }
}
