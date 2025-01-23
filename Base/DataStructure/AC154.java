import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;

public class AC154 {
    final static int N = 1000010;
    static int hh;
    static int tt;
    static int[] queue = new int[N];

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        String[] str = buffer.readLine().split(" ");
        int n = Integer.parseInt(str[0]), k = Integer.parseInt(str[1]), array[] = new int[n];

        str = buffer.readLine().split(" ");

        init();
            
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(str[i]);
            // 队列长度固定，队头不能超出队列区间
            if (!isEmpty() && i - k + 1 > query())
                pop();
            // 当前数值 小于 队尾数值时，队尾数值永远不会成为最小值，应该弹出
            while (!isEmpty() && array[queryTail()] > array[i])
                popTail();

            push(i);

            if (i >= k - 1)
                writer.print(array[query()] + " ");
        }

        writer.print('\n');
        init();
        
        for (int i = 0; i < n; i++) {
            // 队列长度固定，队头不能超出队列区间
            if (!isEmpty() && i - k + 1 > query())
                pop();
            // 当前数值 大于 队尾数值时，队尾数值永远不会成为最大值，应该弹出
            while (!isEmpty() && array[queryTail()] < array[i])
                popTail();

            push(i);

            if (i >= k - 1)
                writer.print(array[query()] + " ");
        }
        
        writer.flush();
    }
    
    public static void init() {
        hh = 0;
        tt = -1;
    }

    public static void push(int x) {
        queue[++tt] = x;
    }

    public static void pop() {
        hh++;
    }

    public static boolean isEmpty() {
        return (tt < hh);
    }

    public static int query() {
        return queue[hh];
    }

    public static int queryTail() {
        return queue[tt];
    }

    public static void popTail() {
        tt--;
    }
}
