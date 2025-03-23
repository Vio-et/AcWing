import java.util.*;

public class AC913 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), t[] = new int[n];
        long res = 0;

        for (int i = 0; i < n; i++)
            t[i] = sc.nextInt();

        Arrays.sort(t);

        for (int i = 0; i < n; i++)
            res += (t[i] * (n - i - 1));

        System.out.println(res);

        sc.close();
    }
}
