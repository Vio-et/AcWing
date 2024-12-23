import java.util.Scanner;
import java.util.Vector;

public class AC793 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> A = new Vector<Integer>();
        
        String a = scanner.nextLine();
        int b = scanner.nextInt();
        
        for(int i = 0; i < a.length(); i++)
            A.add(a.charAt(i) - '0');

        Vector<Integer> B = multiply(A, b);

        for(int i = B.size() - 1; i >= 0; i--)
            System.out.print(B.get(i));
        
        scanner.close();
    }

    private static Vector<Integer> multiply(Vector<Integer> A, int b){
        Vector<Integer> B = new Vector<Integer>();
        int t = 0;

        for(int i = A.size() - 1; i >= 0 || t != 0; i--){
            if(i >= 0)
                t += (A.get(i) * b);

            B.add(t % 10);
            t /= 10;
        }

        while(B.size() != 1 && B.lastElement() == 0)
            B.removeElementAt(B.size() - 1);

        return B;
    }
}
