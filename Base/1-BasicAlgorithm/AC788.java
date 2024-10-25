import java.util.Scanner;

public class AC788 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), array[] = new int[n];
        double cnt = 0;

        for(int i = 0; i < n; i ++)
            array[i] = scanner.nextInt();

        cnt = merge_sort(array, 0, n - 1);

        System.out.printf("%.0f\n", cnt);

        scanner.close();
    }

    private static double merge_sort(int[] array, int l, int r){
        if (l >= r)
            return 0;

        int mid = l + r >> 1, temp[] = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        double cnt = 0;

        cnt = merge_sort(array, l, mid);
        cnt += merge_sort(array, mid + 1, r);

        while(i <= mid && j <= r){
            if(array[i] <= array[j])
                temp[k++] = array[i++];
            else {
                temp[k++] = array[j++];  
                cnt += (mid - i + 1);
            }
        }

        while(i <= mid) temp[k++] = array[i++];
        while(j <= r) temp[k++] = array[j++];

        for(int m = l, n = 0; m <= r; m++, n++)
            array[m] = temp[n];

        return cnt;
    }
}
