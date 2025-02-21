import java.util.Scanner;

public class AC840 {
    final static int N = 100003;
    static int hash[] = new int[N];     // 哈希表拉链法，每个位置保存链表，-1代表空指针
    static int e[] = new int[N];        // 保存值
    static int ne[] = new int[N];       // 保存链表的下一个指针
    static int idx;                     // 链表中当前待使用的位置

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        init();

        while (n-- > 0) {
            String op = scanner.next();
            int x = scanner.nextInt();

            if (op.equals("I"))
                insert(x);
            else if (op.equals("Q")) {
                if (find(x))
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }

        scanner.close();
    }
    // 初始化，哈希表每个位置均为空
    public static void init() {
        for (int i = 0; i < N; i++)
            hash[i] = -1;
    }
    // 向哈希表中插入一个值
    public static void insert(int x) {
        int k = (x % N + N) % N;

        e[idx] = x;
        ne[idx] = hash[k];
        hash[k] = idx++;
    }
    // 在哈希表中查找一个值
    public static boolean find(int x) {
        int k = (x % N + N) % N;
        boolean isInMap = false;

        for (int i = hash[k]; i != -1 && !isInMap; i = ne[i]) {
            if (e[i] == x)
                isInMap = true;
        }
        
        return isInMap;
    }
}
