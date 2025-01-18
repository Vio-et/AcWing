import java.util.Scanner;

public class AC826{
    static int head;
    static int idx;
    final static int N = 100010;
    static int e[] = new int[N];
    static int ne[] = new int[N];

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();

        init();

        while(m > 0){
            String s = scanner.next();
            char op = s.charAt(0);

            if(op == 'H'){
                int x = scanner.nextInt();
                add_to_head(x);
            } 
            else if(op == 'D'){
                int k = scanner.nextInt();
                if(k == 0)
                    head = ne[head];
                else delete(k - 1);
            }
            else if(op == 'I'){
                int k = scanner.nextInt();
                int x = scanner.nextInt();
                add(k - 1, x);
            }
            
            m --;
        }

        for(int i = head; i != -1; i = ne[i]){
            System.out.print(e[i] + " ");
        }
            
        scanner.close();
    }

    public static void init(){
        head = -1;
        idx = 0;
    }

    public static void add_to_head(int x){
        e[idx] = x;
        ne[idx] = head;
        head = idx ++;
    }

    public static void add(int k, int x){
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx ++;
    }

    public static void delete(int k){
        ne[k] = ne[ne[k]];
    }
}