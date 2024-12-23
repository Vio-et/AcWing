import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class AC803{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), res = 0;
        List<PIIs> segments = new ArrayList<PIIs>();

        for(int i = 0; i < n; i++){
            int l = scanner.nextInt(), r = scanner.nextInt();

            segments.add(new PIIs(l, r));
        }
        Collections.sort(segments);

        res = merge(segments);

        System.out.println(res);

        scanner.close();
    }

    public static int merge(List<PIIs> segments){
        List<PIIs> res = new ArrayList<PIIs>();

        int st = (int)-2e9, end = (int)-2e9;

        for(int i = 0; i < segments.size(); i++){
            if(segments.get(i).first > end){
                if(end != (int)-2e9)
                    res.add(new PIIs(st, end));
                st = segments.get(i).first;
                end = segments.get(i).last;
            }
            else end = Math.max(end, segments.get(i).last);
        }
        
        if(end != (int)-2e9)
            res.add(new PIIs(st, end));

        return res.size();
    }
}

class PIIs implements Comparable<PIIs>{
    int first;
    int last;

    public PIIs(int first, int last){
        this.first = first;
        this.last = last;
    }

    public int compareTo(PIIs other){
        return Integer.compare(this.first, other.first);
    }
}