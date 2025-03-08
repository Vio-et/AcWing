package Base.Math;

import java.util.Scanner;

public class AC875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), p = sc.nextInt();

            System.out.println(qmi(a, b, p));
        }

        sc.close();
    }

    public static long qmi(int a, int b, int p) {
        long res = 1, t = a;

        while (b != 0) {
            if ((b & 1) == 1) 
                res = res * t % p;
                
            t = t * t % p;
            b = b >> 1;
        }

        return res;
    }
}
