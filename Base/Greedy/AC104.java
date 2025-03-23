import java.util.*;

public class AC104 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), a[] = new int[n], res = 0;

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        
        Arrays.sort(a);

        for (int i = 0; i < n; i++)
            res += (Math.abs(a[i] - a[n / 2]));

        System.out.println(res);

        sc.close();
    }
}
