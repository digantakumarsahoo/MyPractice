package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamType {
    public static void main(String[] args) {
        List<Integer> ss = Arrays.asList(1,2,3,4,5,6);
        List<Integer> result = new ArrayList<Integer>();

        Stream<Integer> stream = ss.parallelStream();
        final int[] sum = {0};
        stream.map(s -> {
            synchronized (result) {
                sum[0] = sum[0] +s;
                if (result.size() < 2) {
                    result.add(s);
                }
            }
            return s;
        }).forEach( e -> {});
        System.out.println(sum[0]);
    }
}
