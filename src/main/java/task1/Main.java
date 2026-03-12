package task1;

import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi");
        var reversed = Lists.reverse(fruits);
        reversed.forEach(System.out::println);

        Multimap<String,String> map = MultimapBuilder.hashKeys().arrayListValues().build();
        map.put("fruit", "apple");
        map.put("fruit", "Apple");
        System.out.println(map.get("fruit"));
    }
}
