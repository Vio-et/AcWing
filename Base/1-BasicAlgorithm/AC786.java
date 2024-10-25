import java.util.Scanner;

public class AC786 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), k = scanner.nextInt(), array[] = new int[n];

        for(int i = 0; i < n; i ++)
            array[i] = scanner.nextInt();

        quick_sort(array, 0, n - 1);

        System.out.println(array[k - 1]);

        scanner.close();
    }

    private static void quick_sort(int[] array, int l, int r){
        if(l >= r)
            return;
        
        int x = array[l + r >> 1], i = l - 1, j = r + 1;

        while(i < j){
            do i++; while(array[i] < x);
            do j--; while(array[j] > x);
            if(i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        quick_sort(array, l, j);
        quick_sort(array, j + 1, r);
    }
}
