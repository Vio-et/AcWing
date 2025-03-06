package Base.Math;

import java.util.Scanner;

public class AC866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        while (n-- > 0) {
            int a = scanner.nextInt();

            if (isPrime(a))
                System.out.println("Yes");
            else
                System.out.println("No");
        }

        scanner.close();
    }
    
    public static boolean isPrime(int a) {
        boolean isTarget = true;

        if (a < 2)
            isTarget = false;

        for (int i = 2; i <= a / i && isTarget; i++) {
            if (a % i == 0)
                isTarget = false;
        }
        
        return isTarget;
    }
}   
