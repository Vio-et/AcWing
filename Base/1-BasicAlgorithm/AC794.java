import java.util.Scanner;
import java.util.Vector;

public class AC794 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> A = new Vector<Integer>();

        String a = scanner.nextLine();
        int b = scanner.nextInt();
        Integer c = -1;

        for (int i = a.length() - 1; i >= 0; i--)
            A.add(a.charAt(i) - '0');
            
        divide(A, b, c);

        scanner.close();
    }
    
    private static void divide(Vector<Integer> A, int b, Integer c) {
        Vector<Integer> B = new Vector<Integer>();
        int t = 0;

        for (int i = A.size() - 1; i >= 0; i--) {
            t = t * 10 + A.get(i);

            if (t / b >= 0)
                B.add(t / b);

            t %= b;
        }
        
        while (B.size() != 1 && B.get(0) == 0)
            B.removeElementAt(0);
        
        for (int i = 0; i < B.size(); i++)
            System.out.print(B.get(i));
        
        System.out.printf("\n%d\n", t);
    }
}