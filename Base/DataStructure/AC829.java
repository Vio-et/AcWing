package Base.DataStructure;

import java.util.Scanner;

public class AC829{
    final static int N = 100010;
    static int tt;
    static int hh;
    static int queue[] = new int[N];

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();

        init();

        while(m-- > 0){
            String op = scanner.next();

            if(op.equals("push")){
                int x = scanner.nextInt();

                push(x);
            }
            else if(op.equals("pop")){
                pop();
            }
            else if(op.equals("empty")){
                if(isEmpty())
                    System.out.println("YES");
                else 
                    System.out.println("NO");
            }
            else if(op.equals("query"))
                System.out.println(query());
        }

        scanner.close();
    }

    public static void init(){
        tt = -1;
        hh = 0;
    }

    public static void push(int x){
        queue[++ tt] = x;  
    }

    public static void pop(){
        hh++;
    }

    public static boolean isEmpty(){
        return (tt < hh);
    }

    public static int query(){
        return queue[hh];
    }
}
