import java.util.Scanner;

public class AC841 {
    final static int N = 100010;
    final static int P = 131;
    static long hash[] = new long[N];       // 存储前缀的哈希值
    static long p[] = new long[N];          // 存储P的次幂

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt();
        String str = scanner.next();

        init();
        // 计算前缀的哈希值和P的次幂
        for (int i = 1; i <= n; i++) {
            hash[i] = hash[i - 1] * P + str.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }

        while (m-- > 0) {
            int l1 = scanner.nextInt(), r1 = scanner.nextInt(), l2 = scanner.nextInt(), r2 = scanner.nextInt();

            if (hashCode(l1, r1) == hashCode(l2, r2))
                System.out.println("Yes");
            else
                System.out.println("No");
        }

        scanner.close();
    }
    // 初始化
    public static void init() {
        hash[0] = 0;
        p[0] = 1;
    }
    // 根据前缀的哈希值计算 任意子串的哈希值
    public static long hashCode(int l, int r) {
        return hash[r] - hash[l - 1] * p[r - l + 1];
    }
}
