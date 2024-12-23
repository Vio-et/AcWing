import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class AC802 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        final int N = 300010;
        int n = scanner.nextInt(), m = scanner.nextInt(), a[] = new int[N], s[] = new int[N];
        ArrayList<Integer> alls = new ArrayList<Integer>();
        ArrayList<Pair> adds = new ArrayList<Pair>(), querys = new ArrayList<Pair>();

        for(int i = 0; i < n; i++){
            int x = scanner.nextInt(), c = scanner.nextInt();

            alls.add(x);
            adds.add(new Pair(x, c));
        }

        for(int i = 0; i < m; i++){
            int l = scanner.nextInt(), r = scanner.nextInt();

            alls.add(l);
            alls.add(r);
            querys.add(new Pair(l, r));
        }

        Collections.sort(alls);
        int unique_num = unique(alls);
        List<Integer> unique_alls = alls.subList(0, unique_num);
        alls = new ArrayList<Integer>(unique_alls);

        for(int i = 0; i < adds.size(); i++){
            int x = adds.get(i).k, c = adds.get(i).v;

            a[find(alls, x)] += c;
        }

        for(int i = 1; i <= alls.size(); i++)
            s[i] = s[i - 1] + a[i];

        for(int i = 0; i < querys.size(); i++){
            int l = find(alls, querys.get(i).k), r = find(alls, querys.get(i).v);

            System.out.println(s[r] - s[l - 1]);
        }

        scanner.close();
    }

    public static int unique(ArrayList<Integer> list){
        int j = 0;

        for(int i = 0; i < list.size(); i++){
            if(i == 0 || list.get(i) != list.get(i - 1))
                list.set(j++, list.get(i));
        }

        return j;
    }

    public static int find(ArrayList<Integer> alls, int x){
        int l = 0, r = alls.size() - 1;

        while(l < r){
            int mid = l + r >> 1;
            if(alls.get(mid) >= x) 
                r = mid;
            else 
                l = mid + 1;
        }

        return r + 1;
    }
}

class Pair {
    int k;
    int v;

    public Pair(int k, int v){
        this.k = k;
        this.v = v;
    }
}
