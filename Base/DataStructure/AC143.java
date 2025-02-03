import java.util.Scanner;

public class AC143{
    final static int N = 100010;
    static int son[][] = new int[N][2];
    static int cnt[] = new int[N];
    static int idx;
    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);

        int n = scanner.nextInt(), ans = 0, array[] = new int[N];

        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
            insert(array[i]);
        }

        for(int i = 0; i < n; i++){
            int tmp = xor(array[i]);
            ans = ans > tmp ? ans : tmp;
        }

        System.out.println(ans);

        scanner.close();
    }
    // 向Tire树中添加二进制数
    public static void insert(int x){
        int p = 0;

        for(int i = 31; i >= 0; i--){
            int bit = (x >> i) & 1;

            if(son[p][bit] == 0)
                son[p][bit] = ++ idx;
        
            p = son[p][bit];
        }

        cnt[p] ++;
    }
    // 从Tire树中从高位选择与当前数相反的分支
    public static int xor(int x){
        int p = 0, ans = 0;

        for(int i = 31; i >= 0; i--){
            int bit = (x >> i) & 1;

            if(son[p][bit ^ 1] == 0){
                ans = ans | (bit << i); 
                p = son[p][bit];
            }
            else if(son[p][bit ^ 1] != 0){
                ans = ans | ((bit ^ 1) << i);
                p = son[p][bit ^ 1]; 
            }
        }

        return ans ^ x;
    }
}