package coderpad.squareroot;

public class Solution {
    /*
     *   double squareRoot( double x )
     *
     */

    public static double squareRoot( double x )
    {
        double start =0,end=x;
        while(start<end){
            double mid = start+(end-start)/2;
            if(mid*mid == x || Math.abs(mid*mid-x) < 0.001)
                return mid;
            else if(mid*mid < x)
                start=mid;
            else
                end=mid;
        }
        if(end*end == x)
            return end;
        return start;
    }

    public static void main( String args[])
    {
        double[] inputs = {2, 4, 100};
        double[] expected_values = { 1.41421, 2, 10 };
        double threshold = 0.001;
        for(int i=0; i < inputs.length; i++)
        {
            if( Math.abs(squareRoot(inputs[i])-expected_values[i])>threshold )
            {
                System.out.printf( "Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], squareRoot(inputs[i]) );
            }
        }
        System.out.println( "All tests passed");
    }
}