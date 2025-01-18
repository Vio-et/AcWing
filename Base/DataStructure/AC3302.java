import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


public class AC3302 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        
        Map<Character,Integer> priorty = new HashMap<>();
        priorty.put('+', 1);
        priorty.put('-', 1);
        priorty.put('*', 2);
        priorty.put('/', 2);
        priorty.put('(', 0);

        Stack<Character> op = new Stack<>();
        Stack<Integer> num = new Stack<>();

        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);

            if(Character.isDigit(c)){
                int j = i + 1;
                String str = new String();
                str += c;

                while(j < expression.length() && Character.isDigit(expression.charAt(j))){
                    str += expression.charAt(j);
                    j++;
                }

                i = j - 1;
                num.push(Integer.parseInt(str));
            }
            else if(c == '(')
                op.push(c);
            else if(c == ')'){
                while(op.peek() != '(')
                    eval(op, num);
                
                op.pop();
            }
            else {
                while(!op.isEmpty() && priorty.get(c) <= priorty.get(op.peek()))
                    eval(op, num);
                
                op.push(c);
            }
        }

        while(!op.isEmpty())
            eval(op, num);

        System.out.println(num.pop());

        scanner.close();
    }

    public static void eval(Stack<Character> op, Stack<Integer> num){
        int b = num.pop();
        int a = num.pop();
        int res = 0;

        char c = op.pop();

        if(c == '+')
            res = a + b;
        else if(c == '-')
            res = a - b;
        else if(c == '*')
            res = a * b;
        else if(c == '/')
            res = a / b;

        num.push(res);
    }
}