import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AC844 {
    final static int N = 110;
    static int graph[][] = new int[N][N];       
    static int distance[][] = new int[N][N];    // 标识点是否走过
    static Pair queue[] = new Pair[N * N];      // BFS队列
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        for(int i = 0; i < n; i++){
            str = reader.readLine().split(" ");
            for(int j = 0; j < m; j++){
                graph[i][j] = Integer.parseInt(str[j]);
                distance[i][j] = -1;
            }
        }

        System.out.println(bfs());
        writer.close();
    }

    public static int bfs(){
        int hh = 0, tt = -1;
        // 首个节点加入队列
        distance[0][0] = 0;
        queue[++ tt] = new Pair(0, 0);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 当队列不为空
        while(hh <= tt){
            // 取出当前节点
            Pair temp = queue[hh++];
            // 扩展当前节点
            for(int i = 0; i < 4; i++){
                int x = temp.first + dx[i];
                int y = temp.second + dy[i];

                if(x >= 0 && x < n && y >= 0 && y < m && graph[x][y] == 0 && distance[x][y] == -1){
                    queue[++ tt] = new Pair(x, y);
                    distance[x][y] = distance[temp.first][temp.second] + 1;
                }
            }
        }

        return distance[n - 1][m - 1];
    }

    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}