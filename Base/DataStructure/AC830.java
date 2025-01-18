import java.util.Scanner;
import java.util.Stack;

public class AC830{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        
        int n = scanner.nextInt();

        for(int i = 0; i < n; i++){
            int x = scanner.nextInt();

            while(!stack.empty() && stack.peek() >= x)
                stack.pop();
            
            if(!stack.empty())
                System.out.print(stack.peek() + " ");
            else System.out.print("-1 ");

            stack.push(x);
        }

        scanner.close();
    }
}