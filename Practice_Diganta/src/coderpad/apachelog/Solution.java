package coderpad.apachelog;

import java.util.*;
public class Solution {

    /**
     * Given a log file, return IP address(es) which accesses the site most often.
     */

    public static String findTopIpaddress(String[] lines) {
        // Your code goes here
        int len=lines.length;
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<len;i++){
            String line = lines[i];
            String ip=line.split(" - ")[0];
            if(map.containsKey(ip)){
                map.put(ip,map.get(ip)+1);
            }else{
                map.put(ip,1);
            }
        }
        int max=0;
        String result="";
        for(String key : map.keySet()){
            int count = map.get(key);
            if(max < count){
                max=count;
                result=key;
            }
        }
        return result;
    }


    public static boolean doTestsPass() {

        return true;
    }

    public static void main(String[] args) {

        String lines[] = new String[] {
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132" };
        String result = findTopIpaddress(lines);

        if (result.equals("10.0.0.1")) {
            System.out.println("Test passed");

        } else {
            System.out.println("Test failed");

        }

    }

}
