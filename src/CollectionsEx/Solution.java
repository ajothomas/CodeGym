package CollectionsEx;
import java.util.*;
/**
 * Created by ajothomas on 9/28/17.
 */
public class Solution {
    static void customSort(int[] arr) {
        TreeMap<Integer, Integer> sorted = new TreeMap<>();
        for(int i=0; i<arr.length; i++) {
            if(sorted.containsKey(arr[i])) {
                sorted.put(arr[i], sorted.get(arr[i])+1);
            }
            else {
                sorted.put(arr[i], 1);
            }
        }

        TreeMap<Integer, ArrayList<Integer>> x = new TreeMap<>();

        Set set = sorted.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            int occ = (Integer)entry.getValue();
            int num = (Integer)entry.getKey();

            if(x.containsKey(occ)) {
                ArrayList<Integer> temp = (ArrayList<Integer>)x.get(occ);
                temp.add(num);
                x.put(occ, temp);
            }
            else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(num);
                x.put(occ, temp);
            }
        }

        Set set2 = x.entrySet();
        Iterator it2 = set2.iterator();

        while(it2.hasNext()){
            Map.Entry entry = (Map.Entry)it2.next();
            int occ = (Integer)entry.getKey();
            ArrayList<Integer> temp = (ArrayList<Integer>)entry.getValue();
            for(int number:temp) {
                for(int i=0;i<occ;i++) {
                    System.out.println(number);
                }
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {1,1,1,2,2,3};
        customSort(arr);
    }
}
