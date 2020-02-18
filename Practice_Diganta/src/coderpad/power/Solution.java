package coderpad.power;

public class Solution {

    /* Given base and integer exponent, compute value of base raised to the power of exponent.
     */
    public static double power(double base, int exp) {
        //Your code goes here
        if(base == 0)
            return 0;
        double result=1;
        int temp ;
        if(exp < 0)
            temp=Math.abs(exp);
        else
            temp=exp;
        for(int i=1;i<=temp;i++){
            result=result*base;
        }
        if(exp < 0)
            result=1/result;
        return result;
    }

    public static boolean doTestPass() {
        boolean testsPass = true;
        double result = power(2,-2);
        return testsPass && result==0.25;
    }

    public static void main( String[] args ) {
        if(doTestPass()){
            System.out.println("Pass");
        }
        else{
            System.out.println("There are failures");
        }
    }
}