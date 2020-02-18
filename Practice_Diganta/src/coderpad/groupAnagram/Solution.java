package coderpad.groupAnagram;

import java.io.*;
import java.util.*;

/*
 * This program prints set of anagrams together in given string
 *
 * eg.
 * setOfAnagrams("cat dog tac sat tas god dog") should print "cat tac dog god dog sat tas"
 *
 */

class Solution {

    static String input = "cat dog tac sat tas god dog";

    static void setOfAnagrams(String inputString){

        //your code goes here
        String [] words =inputString.split(" ");
        int size = words.length;

        String [] tempArray =inputString.split(" ");
        for(int i=0;i<size;i++){
            char [] temp=tempArray[i].toCharArray();
            Arrays.sort(temp);

            tempArray[i]=new StringBuilder().append(temp).toString();
        }
        Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
        for(int i=0;i<size;i++){
            if(map.containsKey(tempArray[i])){
                map.get(tempArray[i]).add(i);
            }else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(tempArray[i],list);

            }
        }

        for(String key :map.keySet()){

            List<Integer> indexList = map.get(key);
            indexList.stream().forEach(x->{System.out.print(words[x]+" ");
            });
        }



    }


    public static void main(String[] args) {

        String input = "cat dog tac sat tas god dog";
        setOfAnagrams(input);

    }
}
