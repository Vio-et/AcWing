import java.util.Scanner;

public class AC840F2 {
    final static int N = 200003;            
    final static int NULL = 0x3f3f3f3f;     // 标志空位
    static int hash[] = new int[N];         // 哈希表，开放寻址法

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        init();

        while (n-- > 0) {
            String op = scanner.next();
            int x = scanner.nextInt();
            int k = find(x);

            if (op.equals("I")) {
                hash[k] = x;
            } else if (op.equals("Q")) {
                if (hash[k] != NULL)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }

        scanner.close();
    }
    
    public static void init() {
        for (int i = 0; i < N; i++)
            hash[i] = NULL;
    }
    // 寻找X的位置或X应该存储的位置
    public static int find(int x) {
        int t = (x % N + N) % N;

        while (hash[t] != NULL && hash[t] != x) {
            t++;
            if(t == N)
                t = 0;
        }

        return t;
    }
}
