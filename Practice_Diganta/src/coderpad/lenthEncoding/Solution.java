package coderpad.lenthEncoding;

import java.util.*;

/*
 * Implement a run length encoding function.
 * For a string input the function returns output encoded as follows:
 *
 * "a"     -> "a1"
 * "aa"    -> "a2"
 * "aabbb" -> "a2b3"
 */
public class Solution {

    public static String rle(String input) {
        // Your code goes here
        StringBuilder result = new StringBuilder();
        if(input !=null || input.length() >= 1){
            Map<String,Integer> map = new HashMap<String,Integer>();
            for(int i=0;i<input.length();i++){
                if(map.containsKey(input.charAt(i)+"")){
                    map.put(input.charAt(i)+"",map.get(input.charAt(i)+"")+1);
                }else{
                    map.put(input.charAt(i)+"",1);
                }
            }
            for(String key :map.keySet()){
                result.append(key+(map.get(key)));
            }

        }
        return result.toString();
    }


    public static void main(String[] args)  {

        if("".equals(rle("")) &&
                "a1".equals(rle("a")) &&
                "a3".equals(rle("aaa"))){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
    }
}
