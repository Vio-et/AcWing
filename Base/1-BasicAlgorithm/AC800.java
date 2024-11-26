import java.util.Scanner;

public class AC800 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt(), x = scanner.nextInt();
        int a[] = new int[n], b[] = new int[m];
        boolean isFound = false;

        for(int i = 0; i < n; i++)
            a[i] = scanner.nextInt();

        for(int i = 0; i < m; i++)
            b[i] = scanner.nextInt();

        for (int i = 0, j = m - 1; i < n && !isFound; i++) {

            while (j >= 0 && a[i] + b[j] > x)
                j--;

            if (a[i] + b[j] == x) {
                isFound = true;
                System.out.printf("%d %d\n", i, j);
            }
        }
        
        scanner.close();
    }
}
