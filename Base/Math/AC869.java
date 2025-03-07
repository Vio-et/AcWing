package Base.Math;

import java.util.*;

public class AC869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            int a = sc.nextInt();

            get_primes(a);
        }

        sc.close();
    }
    
    public static void get_primes(int a) {
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 1; i <= a / i; i++) {
            if (a % i == 0) {
                primes.add(i);

                if (a / i != i)
                    primes.add(a / i);
            }
        }
        
        Collections.sort(primes);

        for(int i = 0; i < primes.size(); i++)
            System.out.print(primes.get(i) + " ");

        System.out.println("");
    }
}