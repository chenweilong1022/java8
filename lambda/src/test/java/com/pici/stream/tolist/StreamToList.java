package com.pici.stream.tolist;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java8如何将一个stream转换为list;
 */
public class StreamToList {


    /**
     * 将一个stream转换为list
     */
    @Test
    public void test01() {
        Stream<String> stringStream = Stream.of("java", "python", "node");
        List<String> strings = stringStream.collect(Collectors.toList());
        strings.forEach(s -> System.out.println(s));
    }

    /**
     * 将stream转换为列表并且过滤掉php
     */
    @Test
    public void test02() {
        Stream<String> stringStream = Stream.of("java", "python", "node","php","c#");
        List<String> strings = stringStream.filter(s -> !s.equals("php")).collect(Collectors.toList());
        strings.forEach(System.out::println);
    }


}
