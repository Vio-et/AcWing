import java.util.Scanner;

public class AC787 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), array[] = new int[n];

        for(int i = 0; i < n; i++)
            array[i] = scanner.nextInt();

        merge_sort(array, 0, n - 1);

        for(int i = 0; i < n; i++)
            System.out.print(array[i] + " ");

        scanner.close();
    }

    private static void merge_sort(int[] array, int l, int r){
        if(l >= r)
            return;
        
        int mid = l + r >> 1, tmp[] = new int[r - l + 1], i = l, j = mid + 1, k = 0;

        merge_sort(array, l, mid);
        merge_sort(array, mid + 1, r);

        while (i <= mid && j <= r) {
            if (array[i] <= array[j])
                tmp[k++] = array[i++];
            else
                tmp[k++] = array[j++];
        }
        
        while(i <= mid)
            tmp[k++] = array[i++];
        
        while(j <= r)
            tmp[k++] = array[j++];

        for(int c = 0; c < r - l + 1; c++)
            array[l + c] = tmp[c];
    }
}
