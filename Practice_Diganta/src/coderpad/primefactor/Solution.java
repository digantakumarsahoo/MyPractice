package coderpad.primefactor;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    /**
     * Return an array containing prime numbers whose product is x
     * Examples:
     * primeFactorization( 6 ) == [2,3]
     * primeFactorization( 5 ) == [5]
     */
    public static ArrayList<Integer> primeFactorization(int x)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(x%2 == 0){
            list.add(2);
            x=x/2;
        }
        for(int i=3;i<=Math.sqrt(x);i=i+2){
            if(x%i == 0){
                list.add(i);
                x=x/i;
            }

        }
        if(x>2)
            list.add(x);
        return list;
    }

    public static void main(String args[])
    {

        System.out.println(primeFactorization(6) + " " + primeFactorization(5));
        if(primeFactorization(6).equals(Arrays.asList(2,3))
                &&
                primeFactorization(5).equals(Arrays.asList(5))
        ) {
            System.out.println("All passed");
        }else {
            System.out.println("Failed");
        }

    }
}
