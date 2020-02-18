package java8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SumIterator {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,5,10,13,43,5,12,4);
        int sum = getSumWOJava8(list);
        System.out.println(sum);
        System.out.println(getSumWJava8(list));
    }

    private static int getSumWOJava8(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        int sum = 0;
        while (it.hasNext()) {
            int num = it.next();
            if (num > 10) {
                sum += num;
            }
        }
        return sum;
    }
    private static int getSumWJava8(List<Integer> list){
        return list.stream().filter(x-> x>10).mapToInt(x->x).sum();
    }
}
