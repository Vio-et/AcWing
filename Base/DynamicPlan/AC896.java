import java.util.*;

public class AC896 {
    final static int N = 100010;
    static int a[] = new int[N];
    static int q[] = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), len = 0;

        for (int i = 1; i <= n; i++) 
            a[i] = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int l = 0, r = len;

            while (l < r) {
                int mid = l + r + 1 >> 1;

                if (q[mid] >= a[i])
                    r = mid - 1;
                else
                    l = mid;
            }

            len = Math.max(len, l + 1);
            q[l + 1] = a[i];
        }

        System.out.println(len);

        sc.close();
    }
}
