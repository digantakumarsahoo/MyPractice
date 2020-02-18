package coderpad.secondSmallest;

public class Solution {
    /**
     * int secondSmallest(int[] x)
     */
    public static int secondSmallest(int[] x) {
        // Your code
        if(x.length == 1)
            return x[0];
        int min =Integer.MAX_VALUE;
        int secondMin=Integer.MAX_VALUE;
        for(int val :x){
            if(min > val){
                secondMin=min;
                min=val;

            }
            else if(val < secondMin && val != min)
                secondMin=val;

        }
        return secondMin;
    }

    public static void main(String args[]) {

        int[] a = { 0 };
        int[] b = { 0, 1 };
        int[] c = { 12, 13, 1, 10, 34, 1 };

        boolean result = true;
        result &= secondSmallest(a) == 0;
        result &= secondSmallest(b) == 1;
        result &= secondSmallest(c) == 10;

        if (result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }
}
