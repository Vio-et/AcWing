import java.util.Scanner;

public class AC839 {
    final static int N = 100010;
    static int size;
    static int heap[] = new int[N];
    static int ph[] = new int[N];
    static int hp[] = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), cnt = 0;
        size = 0;

        while (n-- > 0) {
            String op = scanner.next();

            if (op.equals("I")) {
                int x = scanner.nextInt();
                heap[++size] = x;
                ph[++cnt] = size;
                hp[size] = cnt;
                up(size);
            } else if (op.equals("PM"))
                System.out.println(heap[1]);
            else if (op.equals("DM")) {
                heap_swap(1, size);
                size--;
                down(1);
            } else if (op.equals("D")) {
                int k = scanner.nextInt();
                k = ph[k];
                heap_swap(k, size);
                size--;
                up(k);
                down(k);
            } else if (op.equals("C")) {
                int k = scanner.nextInt(), x = scanner.nextInt();
                k = ph[k];
                heap[k] = x;
                up(k);
                down(k);
            }
        }

        scanner.close();
    }
    
    public static void down(int x) {
        int t = x;

        if (x * 2 <= size && heap[t] > heap[x * 2])
            t = x * 2;

        if (x * 2 + 1 <= size && heap[t] > heap[x * 2 + 1])
            t = x * 2 + 1;

        if (t != x) {
            heap_swap(t, x);
            down(t);
        }
    }
    
    public static void up(int x) {
        while (x / 2 > 0 && heap[x] < heap[x / 2]) {
            heap_swap(x, x / 2);
            x /= 2;
        }
    }

    public static void heap_swap(int a, int b) {
        swap(ph, hp[a], hp[b]);
        swap(hp, a, b);
        swap(heap, a, b);
    }

    public static void swap(int array[], int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
