package coderpad.firstNonRepeating;

import java.util.*;
public class Solution {

    /**
     * Finds the first character that does not repeat anywhere in the input string
     * Given "apple", the answer is "a"
     * Given "racecars", the answer is "e"
     **/
    public static char findFirst(String input)
    {
        // code goes here
        if(input != null && input.length() >= 1){
            Map<String,Integer> map = new HashMap<String,Integer>();
            for(int i=0;i<input.length();i++){
                if(map.containsKey(input.charAt(i)+"")){
                    map.put(input.charAt(i)+"",map.get(input.charAt(i)+"")+1);
                }else {
                    map.put(input.charAt(i)+"",1);
                }
            }
            for(int i=0;i<input.length();i++){
                if(map.get(input.charAt(i)+"") == 1)
                    return input.charAt(i);
            }
        }
        return '\u0000';
    }

    public static void main(String args[])
    {

        String[] inputs = {"apple","racecars", "ababdc"};
        char[] outputs = {'a', 'e', 'd' };

        boolean result = true;
        for(int i = 0; i < inputs.length; i++ )
        {
            result = result && findFirst(inputs[i]) == outputs[i];
            if(!result)
                System.out.println("Test failed for: " + inputs[i]);
            else
                System.out.println("Test passed for: " + inputs[i]);
        }
    }

}

