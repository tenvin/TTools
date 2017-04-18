package com.twg.ttools.functional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by twg on 2017/4/10.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        //long count = strings.stream().filter(string->string.isEmpty()).count();
        long count = strings.stream().filter(String::isEmpty).count();
        System.out.println("空字符串数量为: " + count);

    }
}
