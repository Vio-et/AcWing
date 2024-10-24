import java.util.Scanner;

public class AC785 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), p[] = new int[n];

        for(int i = 0; i < n; i++)
            p[i] = scanner.nextInt();
        
        quick_sort(p, 0, n - 1);

        for(int i = 0; i < n; i++)
            System.out.print(p[i] + " ");

        scanner.close();
    }

    public static void quick_sort(int[] p, int l, int r){
        if(l >= r)
            return;
        
        int x = p[l + r >> 1], i = l - 1, j = r + 1;

        while(i < j){
            do i++; while(p[i] < x);
            do j--; while(p[j] > x);
            if (i < j){
                int temp = p[i];
                p[i] = p[j];
                p[j] = temp;
            }
        }

        quick_sort(p, l, j);
        quick_sort(p, j + 1, r);
    }
}