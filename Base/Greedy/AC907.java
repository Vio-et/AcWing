import java.util.*;

public class AC907 {
    final static int N = 100010;
    final static int MAX_INF = 0x3f3f3f3f;
    static Range ranges[] = new Range[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt(), end = sc.nextInt(), n = sc.nextInt(), res = 0;
        boolean isFinish = false;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();

            ranges[i] = new Range(a, b);
        }

        Arrays.sort(ranges, 0, n);

        for (int i = 0; i < n && !isFinish; i++) {
            int j = i, rightPoint = -MAX_INF;

            while (j < n && ranges[j].l <= start) {
                rightPoint = Math.max(rightPoint, ranges[j].r);
                j++;
            }

            res++;
            start = rightPoint;
            i = j - 1;

            if (rightPoint >= end)
                isFinish = true;
            else if (j < n && ranges[j].l > rightPoint) {
                res = -1;
                isFinish = true;
            }
        }
        
        if (!isFinish && start < end)
            res = -1;
        
        System.out.println(res);

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
