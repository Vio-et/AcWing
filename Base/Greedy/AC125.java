import java.util.*;

public class AC125 {
    final static int N = 50010;
    final static int MAX_INF = 0x3f3f3f3f;
    static Cow cows[] = new Cow[N];
    static int s[] = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), res = -MAX_INF;

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt(), s = sc.nextInt();

            cows[i] = new Cow(w, s);
        }

        Arrays.sort(cows, 0, n);

        for (int i = 1; i < n; i++)
            s[i] = s[i - 1] + cows[i - 1].weight;

        for (int i = 0; i < n; i++)
            res = Math.max(res, s[i] - cows[i].strength);

        System.out.println(res);

        sc.close();
    }
    
    static class Cow implements Comparable<Cow>{
        int weight;
        int strength;

        public Cow(int weight, int strength) {
            this.weight = weight;
            this.strength = strength;
        }

        @Override
        public int compareTo(Cow cow) {
            return Integer.compare(this.weight + this.strength, cow.weight + cow.strength);
        }
    }
}
