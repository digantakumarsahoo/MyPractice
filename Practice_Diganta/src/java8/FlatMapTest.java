package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("1", "2", "3");
        List<Integer> collect1 = l1.stream().map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(collect1);
        List<String> l2 = Arrays.asList("4", "5", "6");
        List<String> l3 = Arrays.asList("7", "8", "9");
        List<List<String>> lists = Arrays.asList(l1, l2, l3);
        System.out.println(lists);
        List<String> collect = lists.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println(collect);




    }
}
