import java.util.Scanner;
import java.util.Vector;

public class AC791 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vector<Integer> A = new Vector<Integer>(), B = new Vector<Integer>();
        String a = scanner.nextLine(), b = scanner.nextLine();

        for (int i = a.length() - 1; i >= 0; i--)
            A.add((int) (a.charAt(i) - '0'));

        for (int i = b.length() - 1; i >= 0; i--)
            B.add((int) (b.charAt(i) - '0'));

        Vector<Integer> C = add(A, B);

        for(int i = C.size() - 1; i >= 0; i --)
            System.out.print(C.get(i));

        scanner.close();
    }
    
    private static Vector<Integer> add(Vector<Integer> A, Vector<Integer> B) {
        Vector<Integer> C = new Vector<Integer>();
        int t = 0;

        for (int i = 0; i < A.size() || i < B.size(); i++) {
            if (i < A.size())
                t += A.get(i);
            if (i < B.size())
                t += B.get(i);

            C.add(t % 10);
            t /= 10;
        }
        
        if (t != 0)
            C.add(t);

        return C;
    }
}
