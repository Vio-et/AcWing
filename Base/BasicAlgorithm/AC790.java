import java.util.Scanner;

public class AC790 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double n = scanner.nextDouble(), l = 0, r = n;

        if(Math.abs(n) < 1){
            if(n < 0)
                r = -1;
            else r = 1;
        }

        while(Math.abs(r - l) > 1e-8){
            double mid = (l + r) / 2;

            if(Math.abs(Math.pow(mid, 3)) < Math.abs(n))
                l = mid;
            else r = mid;
        }

        System.out.printf("%.6f\n", l);

        scanner.close();
    }
}
