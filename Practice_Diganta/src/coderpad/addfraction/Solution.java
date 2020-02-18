package coderpad.addfraction;

public class Solution {

    /**
     * Given two fractions passed in as int arrays,
     * returns the fraction which is result of adding the two input fractions.
     */
    public static int[] addFractions( int[] fraction1, int[] fraction2 ) {
        // Write your code here
        // get lcd of two denominator by gcd a*b/gcd , so get gcd first

        int gcd =1;
        int i=2;
        int a=fraction1[1],b=fraction2[1];
        System.out.println("a :"+a+" b: "+b);
        while(a >= i || b >= i){
            if(a%i == 0 && b%i == 0){
                gcd=gcd*i;
                a=a/i;
                b=b/i;

            }
            else {
                i++;
            }
        }
        int lcd = fraction1[1]*fraction2[1]/gcd;
        System.out.println(lcd);

        return ( new int[]{ (lcd/fraction1[1])*fraction1[0]+(lcd/fraction2[1])*fraction2[0],lcd  } );
    }


    public static void main( String[] args ) {
        int[] result = addFractions( new int[]{ 2, 3 }, new int[]{ 1, 6 } );

        if( result[ 0 ] == 5 && result[ 1 ] == 6 ) {
            System.out.println( "Test passed." );

        } else {
            System.out.println( "Test failed." );

        }
    }
}
