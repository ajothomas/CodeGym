package Misc;

/**
 * Created by ajothomas on 9/30/17.
 */
public class CupCakes {
    static void maximumCupcakes(String[] trips) {
        for(String trip:trips) {
            String tripArr[] = trip.split(" ");
            int n = Integer.parseInt(tripArr[0]);
            int c = Integer.parseInt(tripArr[1]);
            int m = Integer.parseInt(tripArr[2]);

            int numWrappers = n/c;
            int numCupcakes = numWrappers;
            while(numWrappers>=m) {
                int numC = numWrappers/m;
                numCupcakes +=numC;
                numWrappers = numC+(numWrappers%m);
            }
            System.out.println(numCupcakes);
        }
    }
    public static void main(String args[]) {
        String input[]={"10 2 5","12 4 4","6 2 2"};
        maximumCupcakes(input);
    }
}

