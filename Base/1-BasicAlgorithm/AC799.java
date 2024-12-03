import java.util.Scanner;

public class AC799 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = 100010;

        int n = scanner.nextInt(), a[] = new int[n], s[] = new int[N], ans = 0;

        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();

        for (int i = 0, j = 0; i < n; i++) {
            s[a[i]]++;

            while (s[a[i]] > 1) {
                s[a[j]]--;
                j++;
            }

            ans = ans > (i - j + 1) ? ans : (i - j + 1);
        }

        System.out.println(ans);

        scanner.close();
    }
}
