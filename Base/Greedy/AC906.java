import java.util.*;

public class AC906 {
    final static int N = 100010;
    static Range ranges[] = new Range[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new PriorityQueue<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();

            ranges[i] = new Range(a, b);
        }

        Arrays.sort(ranges, 0, n);

        for (int i = 0; i < n; i++) {
            Range t = ranges[i];

            if (queue.size() == 0 || t.l <= queue.peek())
                queue.add(t.r);
            else {
                queue.remove();
                queue.add(t.r);
            }
        }
        
        System.out.println(queue.size());

        sc.close();
    }
    
    static class Range implements Comparable<Range>{
        int l;
        int r;

        public Range(int l, int r) {
            this.l = l;
            this.r = r;
        }
        
        @Override
        public int compareTo(Range M) {
            return Integer.compare(this.l, M.l);
        }
    }
}