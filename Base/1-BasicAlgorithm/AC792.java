import java.util.Scanner;
import java.util.Vector;

public class AC792 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Vector<Integer> A = new Vector<Integer>(), B = new Vector<Integer>(), C = new Vector<Integer>();
        String a = scanner.nextLine(), b = scanner.nextLine();
        boolean isNeg = judgeSymbol(a, b), isZero = true;

        for(int i = a.length() - 1; i >= 0; i--)
            A.add(a.charAt(i) - '0');

        for(int i = b.length() - 1; i >= 0; i--)
            B.add(b.charAt(i) - '0');
        
        if(isNeg)
            C = minus(B, A);
        else C = minus(A, B);

        if(isNeg)
            System.out.print('-');
        
        for(int i = C.size() - 1; i >= 0; i--){
            if(C.get(i) != 0 || !isZero || i == 0){
                System.out.print(C.get(i));
                isZero = false;
            }
        }

        scanner.close();
    }

    private static Vector<Integer> minus(Vector<Integer> A, Vector<Integer> B){
        Vector<Integer> C = new Vector<Integer>();

        int t = 0;

        for(int i = 0; i < A.size(); i++){
            if(i < B.size())
                t += (A.get(i) - B.get(i));
            else t += A.get(i);
 
            C.add((t + 10) % 10);
            
            if(t < 0)
                t = -1;
            else t = 0;
        }

        if(t != 0)
            C.add((t + 10) % 10);

        return C;
    }

    private static boolean judgeSymbol(String a, String b){
        boolean isNeg = false;

        if(a.length() < b.length())
            isNeg = true;
        else if(a.length() == b.length()){
            for(int i = 0; !isNeg && i < a.length(); i++){
                if(a.charAt(i) < b.charAt(i))
                    isNeg = true;
                else if(a.charAt(i) > b.charAt(i))
                    break;
            }
        }

        return isNeg;
    }
}