import java.util.Scanner;

public class AC827 {
    final static int N = 100010;
    static int idx;
    static int e[] = new int[N];
    static int l[] = new int[N];
    static int r[] = new int[N];

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();

        init();

        while(m -- > 0){
            String op = scanner.next();
            
            if(op.equals("L")){
                int x = scanner.nextInt();
                add(0, x);
            }
            else if(op.equals("R")){
                int x = scanner.nextInt();
                add(l[1], x);
            }
            else if(op.equals("D")){
                int k = scanner.nextInt();
                remove(k + 1);
            }
            else if(op.equals("IL")){
                int k = scanner.nextInt(), x = scanner.nextInt();
                add(l[k + 1], x);
            }
            else if(op.equals("IR")){
                int k = scanner.nextInt(), x = scanner.nextInt();
                add(k + 1, x);
            }
        }

        for(int i = r[0]; i != 1; i = r[i])
            System.out.print(e[i] + " ");

        scanner.close();
    }

    public static void init(){
        idx = 2;
        r[0] = 1;
        l[0] = -1;
        l[1] = 0;
        r[1] = -1;
    }

    public static void add(int k, int x){
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx ++;
    }

    public static void remove(int k){
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }
}
