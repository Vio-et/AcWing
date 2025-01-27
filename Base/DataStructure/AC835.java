import java.util.Scanner;

public class AC835 {
    final static int N = 100010;
    // son的第一维表示Tire树的节点编号，第二维表示英文字母，值表示子节点的编号
     static int son[][] = new int[N][26];
    // cnt表示某个节点为止的字符串出现的次数
    static int cnt[] = new int[N];
    // idx表示最新的未使用节点的编号，0节点表示根节点
    static int idx;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        while (n-- > 0) {
            String op = scanner.next(), str = scanner.next();

            if (op.equals("I"))
                insert(str);
            else if (op.equals("Q"))
                System.out.println(query(str));
        }

        scanner.close();
    }

    // 向Tire树中插入字符串
    public static void insert(String str) {
        int p = 0;

        for (int i = 0; i < str.length(); i++) {
            int a = str.charAt(i) - 'a';
            // 若子节点为空，则创建新的子节点
            if (son[p][a] == 0)
                son[p][a] = ++idx;
            // 将序号更新为子节点序号，即在树中走到子节点上去
            p = son[p][a];
        }

        cnt[p]++;
    }

    // 在Tire树中查询字符串
    public static int query(String str) {
        int num = -1, p = 0;

        for (int i = 0; i < str.length() && num == -1; i++) {
            int a = str.charAt(i) - 'a';

            if (son[p][a] == 0)
                num = 0;

            p = son[p][a];
        }
        
        if (num == -1)
            num = cnt[p];

        return num;
    }
}
