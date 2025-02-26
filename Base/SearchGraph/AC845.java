import java.util.Scanner;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class AC845 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = "";

        for (int i = 0; i < 9; i++)
            str += scanner.next();

        System.out.println(bfs(str));

        scanner.close();
    }

    public static int bfs(String str) {
        boolean isFind = false;
        int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 }, res = -1;
        String end = "12345678x";

        Queue<String> queue = new LinkedList<>();           // 利用字符串来保存每种情况，利用队列来宽搜
        Map<String, Integer> distance = new HashMap<>();    // 利用字典来保存距离

        // 将起始情况加入队列
        queue.add(str);
        distance.put(str, 0);

        // 当队列不为空
        while (!queue.isEmpty() && !isFind) {
            // 获取队头元素
            String top = queue.peek();
            queue.remove();
            // 扩展队头
            int loc = top.indexOf('x'), x = loc / 3, y = loc % 3;

            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];

                if (a >= 0 && a < 3 && b >= 0 && b < 3) {
                    String tmp = swap(top, loc, a * 3 + b);
                    if (!distance.containsKey(tmp)) {
                        // 扩展成功，加入队列，更新距离
                        queue.add(tmp);
                        distance.put(tmp, distance.get(top) + 1);
                    }
                    // 恢复现场（新开的tmp，所以不用恢复）
                }
            }

            if (top.equals(end)) {
                isFind = true;
                res = distance.get(top);
            }
        }

        return res;
    }
    
    public static String swap(String str, int a, int b) {
        StringBuilder sb = new StringBuilder(str);

        char t = sb.charAt(a);
        sb.setCharAt(a, sb.charAt(b));
        sb.setCharAt(b, t);

        return sb.toString();
    }
}
