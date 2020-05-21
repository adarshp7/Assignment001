import java.time.LocalDate;
import java.util.*;
public class assign
{

    public static void main(String[] args)
    {
       TreeMap<String, Integer> value = new TreeMap<String,Integer>();
       value.put("2019-05-01",106);
       value.put("2019-05-07",115);

       TreeMap<String,Integer> result = new TreeMap<String,Integer>();
       result = operation(value);
       System.out.println(result);
    }
    public static TreeMap<String,Integer> operation(TreeMap<String,Integer> value) {
        List<LocalDate> total_no_dates = new ArrayList<>();
        ArrayList key = new ArrayList<Integer>();
        String q[]=new String[value.size()];
        int w[]=new int[value.size()];
        int i=0;
        for(Map.Entry<String,Integer> entry: value.entrySet())
        {
            q[i]=entry.getKey();
            w[i]=entry.getValue();
            i++;
        }
        int j=0,k=j+1;
        while(k<value.size())
        {
            int h1,h2;
            int st = 0;

            LocalDate start = LocalDate.parse(q[j]);
            LocalDate end = LocalDate.parse(q[k]);
            if(start.plusDays(1).compareTo(end)==0)
            {
                j++;
                k=j+1;
                continue;
            }
                h1 = w[j];
                h2 = w[k];
                int vd = Math.abs(h2-h1);
                int flag = 1;
                start = start.plusDays(1);
                while (!start.isAfter(end)) {
                    if(start.compareTo(end)==0)
                    break;
                    total_no_dates.add(start);
                    start = start.plusDays(1);
                    flag++;
                }
                int kk = h1 + (vd/flag);
                for(;kk<w[w.length-1];kk+=(vd/flag))
                key.add(kk);


            j++;
            k=j+1;
        }
        for(int it = 0;it<total_no_dates.size();it++)
        {
            String mn = ""+total_no_dates.get(it);
            int n =(int) key.get(it);
            value.put(mn,n);
        }
       return value;

    }

}
