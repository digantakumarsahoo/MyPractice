package coderpad.mininrotation;

import java.util.*;

public class Solution
{

    /*
     * public static int FindMin(int a[])
     * Returns the smallest number in array that has been rotated
     * For example - Array {3,4,5,6,1,2} returns 1
     */

    public static int FindMin(int a[])
    {
        /*
         ** Your code goes here
         */


        return findMinRec(a,0,a.length-1);
    }
    public static int findMinRec(int a[],int low,int high){
        if(high == low)
            return a[high];
        int mid = low+(high-low)/2;

        if(mid < high && a[mid+1] < a[mid])
            return a[mid+1];
        if(mid > low && a[mid] < a[mid-1])
            return a[mid];

        if(a[mid] > a[high])
            return  findMinRec(a,mid+1,high);
        return findMinRec(a,low,mid-1);
    }

    public static void main(String args[])
    {
        boolean result = true;
        result = result && FindMin(new int[]{3,4,5,6,1,2}) == 1;
        result = result && FindMin(new int[]{2,1}) == 1;
        result = result && FindMin(new int[]{1}) == 1;

        try {
            FindMin(null);
            result = false;
        }
        catch(Exception e)
        {
            result = result && true;
        }

        if(result)
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("There are test failures");
        }
    }
}