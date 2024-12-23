import java.util.Scanner;

public class AC801 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), a[] = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
            System.out.print(get_binary_one(a[i]) + " ");
        }
            
        scanner.close();
    }

    public static int get_binary_one(int a){
        int cnt = 0;

        while(a != 0){
            if((a & 1) == 1)
                cnt++;
            
            a = a >> 1;
        }

        return cnt;
    }
}
