import java.util.*;

public class AC148 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), res = 0;
        Queue<Integer> queue = new PriorityQueue<>();

        while (n-- > 0) {
            int a = sc.nextInt();
            queue.add(a);
        }

        while (queue.size() >= 2) {
            int a = queue.poll();
            int b = queue.poll();
            res += (a + b);

            queue.add(a + b);
        }

        System.out.println(res);

        sc.close();
    }
}
