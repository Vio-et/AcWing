import java.util.Scanner;

public class AC795 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt(), a[] = new int[n + 1], s[] = new int[n + 1];
        int l = -1, r = -1;

        for(int i = 1; i < n + 1; i++){
            a[i] = scanner.nextInt();
            s[i] = s[i - 1] + a[i];
        }
            
        while(m > 0){
            l = scanner.nextInt();
            r = scanner.nextInt();

            System.out.println(s[r] - s[l - 1]);

            m --;
        }

        scanner.close();
    }
}
