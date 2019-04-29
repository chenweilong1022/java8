package com.pici.stream.tolist;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream关闭
 */
public class StreamClosed {


    /**
     * stream只能使用一次 使用之后关闭 如果再次调用会抛出异常
     */
    @Test
    public void test01() {
        String[] array = {"a","b","c","d","e","f","g","h"};
        Stream<String> stream = Arrays.stream(array);
        stream.forEach(System.out::println);
//        java.lang.IllegalStateException: stream has already been operated upon or closed
//        第二次调用会出现 stream 已经关闭
        List<String> b = stream.filter(s -> !s.equals("b")).collect(Collectors.toList());
        System.out.println(b);
    }

    /**
     * 将stream转换为Supplier<Stream<String>>可以多次使用
     */
    @Test
    public void test02() {

        String[] array = {"a","b","c","d","e","f","g","h"};
        Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);
        streamSupplier.get().forEach(s -> System.out.println(s));
        System.out.println("-------------------");
        streamSupplier.get().filter(s -> !s.equals("b")).forEach(s -> System.out.println(s));

    }
}
