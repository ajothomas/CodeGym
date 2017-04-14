package src.Strings;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by ajothomas on 3/27/17.
 */
class MyStringCompare implements Comparator<String>{
    @Override
    public int compare(String a, String b){
        return a.compareTo(b);
    }
}


public class TimeDifference {
    public static int ComputeTimeDifference(String t1, String t2){
        String t1Arr[] = t1.split(":");
        String t2Arr[] = t2.split(":");
        int h1 = Integer.parseInt(t1Arr[0]);
        int m1 = Integer.parseInt(t1Arr[1]);
        int h2 = Integer.parseInt(t2Arr[0]);
        int m2 = Integer.parseInt(t2Arr[1]);
        if(h1==h2)
            return (m1-m2);
        else
            return (h1-h2)*60 + (m1-m2);
    }

    public static void main(String args[]){
        TreeSet ts = new TreeSet(new MyStringCompare());
        String arr[] = {"00:23","23:59","12:00","23:10","12:15"};
        for(String element:arr){
            ts.add(element);
        }

        Iterator it=ts.iterator();
        int minDifference = Integer.MAX_VALUE;
        String firstValue = (String)it.next();
        while(it.hasNext()){
            String secondValue = (String)it.next();
            int currentDifference = ComputeTimeDifference(secondValue,firstValue);
            if(currentDifference<minDifference)
                minDifference = currentDifference;
            firstValue = secondValue;
        }
        System.out.println(minDifference);
    }
}
