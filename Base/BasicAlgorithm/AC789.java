import java.util.Scanner;

public class AC789 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), q = scanner.nextInt(), array[] = new int[n];

        for(int i = 0; i < n; i++)
            array[i] = scanner.nextInt();

        while(q > 0){
            int k = scanner.nextInt(), l = 0, r = n - 1;
            int start = -1, end = -1;

            while(l < r){
                int mid = l + r >> 1;

                if(array[mid] < k)
                    l = mid + 1;
                else r = mid;
            }
            
            if(array[l] == k)
                start = l;

            l = 0;
            r = n - 1;
            while(l < r){
                int mid = l + r + 1 >> 1;

                if(array[mid] > k)
                    r = mid - 1;
                else l = mid;
            }

            if(array[l] == k)
                end = l;

            System.out.printf("%d %d\n", start, end);
            q--;
        }

        scanner.close();
    }
}
