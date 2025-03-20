import java.util.*;

public class AC905 {
    final static int N = 100010;
    final static int MAX_INF = 0x3f3f3f3f;
    static Range ranges[] = new Range[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), res = 0, rightEndPoint = -MAX_INF;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();

            ranges[i] = new Range(a, b);
        }

        Arrays.sort(ranges, 0, n);

        for (int i = 0; i < n; i++) {
            Range t = ranges[i];

            if (t.l > rightEndPoint) {
                rightEndPoint = t.r;
                res++;
            }
        }

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
            return Integer.compare(this.r, M.r);
        }
    }
}

    