import java.util.Scanner;

public class AC2816 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt(), a[] = new int[n], b[] = new int[m];
        int j = 0;
        
        for(int i = 0; i < n; i++)
            a[i] = scanner.nextInt();

        for(int i = 0; i < m; i++)
            b[i] = scanner.nextInt();

        for(int i = 0; i < m && j < n; i++){
            if(a[j] == b[i])
                j++;
        }

        if(j == n)
            System.out.print("Yes");
        else
            System.out.print("No");

        scanner.close();
    }
}
