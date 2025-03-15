import java.util.*;

public class AC338 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isFinish = false;

        while (!isFinish) {
            int a = sc.nextInt(), b = sc.nextInt();

            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }

            if (a == 0 && b == 0)
                isFinish = true;
            else {
                for (int i = 0; i < 10; i++) 
                    System.out.print(count(b, i) - count(a - 1, i) + " ");
                
                System.out.println("");
            }
        }

        sc.close();
    }
    
    public static int count(int n, int x) {
        int cnt = 0;

        if (n != 0) {
            List<Integer> nums = new ArrayList<>();

            while (n != 0) {
                nums.add(n % 10);
                n /= 10;
            }
            
            n = nums.size();

            for (int i = n - 1; i >= 0; i--) {
                if (i != n - 1) {
                    cnt += (get(nums, i + 1, n - 1) * Math.pow(10, i));

                    if (x == 0)
                        cnt -= Math.pow(10, i);
                }
                
                if (x != 0 || i != n - 1) {
                    if (nums.get(i) == x)
                        cnt += (get(nums, 0, i - 1) + 1);
                    else if (nums.get(i) > x)
                        cnt += Math.pow(10, i);
                }
            }
        }

        return cnt;
    }
    
    public static int get(List<Integer> nums, int l, int r) {
        int res = 0;
        
        for(int i = r; i >= l; i--)
            res = res * 10 + nums.get(i);
            
        return res;
    }
}
