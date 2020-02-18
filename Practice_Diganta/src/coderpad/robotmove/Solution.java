package coderpad.robotmove;

import java.io.*;
import java.util.*;


//Implement the 'walk' method.
//Assume robot inital position is (0,0).
//walk method take path where each character corresponds to a movement of the robot.
// The robot moves up, down, left, and right represented by the characters 'U', 'D', 'L', and 'R'
// Ignore other characters.


public class Solution{

    // your code
    public static Integer[] walk( String path ) {
        int currentX=0,currentY =0;
        for(int i=0;i<path.length();i++){
            char move=path.charAt(i);
            if(move == 'U'){
                currentY++;
            }
            if(move == 'D'){
                currentY--;
            }
            if(move == 'L'){
                currentX--;
            }
            if(move == 'R') {
                currentX++;
            }
        }
        return new Integer[] {currentX, currentY};
    }

    public static boolean isEqual(Integer[] a, Integer[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean pass() {
        boolean res = true;

        {
            String test = "UUU";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[]{0, 3});
        }

        {
            String test = "ULDR";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[]{0, 0});
        }

        {
            String test = "ULLLDUDUURLRLR";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[]{-2, 2});
        }


        return res;
    }

    public static void main(String[] args) {
        if(pass()){
            System.out.println("Pass");
        } else {
            System.out.println("Test failures");
        }
    }
}