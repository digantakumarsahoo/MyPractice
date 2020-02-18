package coderpad.bestAvg;

import java.io.*;
import java.util.*;

//  Find the best average grade.
//  Given a list of student test scores
//  Each student may have more than one test score in the list.


class Solution
{
    public static Integer bestAvgGrade(String[][] scores)
    {
        // write your code goes here
        int bestAvg=0;
        Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();

        for(int i=0;i<scores.length;i++){

            if(map.containsKey(scores[i][0])){
                map.get(scores[i][0]).add(Integer.parseInt(scores[i][1]));
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(Integer.parseInt(scores[i][1]));
                map.put(scores[i][0],list);
            }
        }
        for(List<Integer> list : map.values()){
            double avg=list.stream().mapToInt(x->x).average().getAsDouble();
            if(avg > bestAvg)
                bestAvg=(int)avg;
        }
        return bestAvg;
    }

    public static boolean pass()
    {
        String[][] s1 = { { "Rohan", "84" },
                { "Sachin", "102" },
                { "Ishan", "55" },
                { "Sachin", "18" } };

        return bestAvgGrade(s1) == 84;
    }

    public static void main(String[] args)
    {
        if(pass())
        {
            System.out.println("Pass");
        }
        else
        {
            System.out.println("Some Fail");
        }
    }
}


