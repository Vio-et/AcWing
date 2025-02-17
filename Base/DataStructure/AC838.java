import java.util.Scanner;

public class AC838 {
    final static int N = 100010;
    static int size;
    static int heap[] = new int[N];     // 使用数组存储堆，1号为根节点，2x为左子，2x + 1 为右子

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt();

        size = 0;

        for (int i = 1; i <= n; i++) {
            heap[i] = scanner.nextInt();
            size++;
        }

        for (int i = n / 2; i > 0; i--)
            down(i);

        while (m-- > 0) {
            System.out.print(heap[1] + " ");
            heap[1] = heap[size--];
            down(1);
        }

        scanner.close();
    }
    // 向下调整某个节点
    public static void down(int x) {
        int t = x;
        // 检查是否小于左子
        if (x * 2 <= size && heap[t] > heap[x * 2])
            t = x * 2;
        // 检查是否小于右子
        if (x * 2 + 1 <= size && heap[t] > heap[x * 2 + 1])
            t = x * 2 + 1;
        // 若最小值不是该节点，交换最小值与该节点的值
        if (t != x) {
            swap(t, x);
            // 进一步调整被交换的点
            down(t);
        }
    }
    
    public static void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }
}
