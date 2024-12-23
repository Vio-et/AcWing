import java.util.Scanner;

public class AC797 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        final int N = 100010;

        int n = scanner.nextInt(), m = scanner.nextInt(), a[] = new int[N], b[] = new int[N];

        for(int i = 1; i <= n; i++){
            a[i] = scanner.nextInt();
            insert(b, i, i, a[i]);
        }

        while(m > 0){
            int l = scanner.nextInt(), r = scanner.nextInt(), c = scanner.nextInt();

            insert(b, l, r, c);

            m --;
        }
        
        for(int i = 1; i <= n; i++){
            a[i] = a[i - 1] + b[i];
            System.out.print(a[i] + " ");
        }

        scanner.close();
    }

    private static void insert(int[] b, int l, int r, int c){
        b[l] += c;
        b[r + 1] -= c;
    }
}
