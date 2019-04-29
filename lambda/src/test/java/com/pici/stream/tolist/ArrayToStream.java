package com.pici.stream.tolist;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * java8中将数组转化为stream
 * 实际操作中推荐使用Arrays.stream
 */
public class ArrayToStream {


    /**
     * 对象数组两种方式返回结果一样
     */
    @Test
    public void test01() {

        String[] array = {"a","b","c","d","e","f","g","h"};

        Stream<String> array1 = Stream.of(array);
        array1.forEach(s -> System.out.println(s + "--------Stream.of"));

        Stream<String> stream = Arrays.stream(array);
        stream.forEach(s -> System.out.println(s + "--------Arrays.stream"));

    }

    /**
     * 原始类型数组返回结果不一样
     */
    @Test
    public void test02() {
        int[] array = {1,2,3,4,5,6,7};

        Stream<int[]> array1 = Stream.of(array);

        IntStream intStream = array1.flatMapToInt(x -> Arrays.stream(x));
        intStream.forEach(i-> System.out.println(i));


        IntStream stream = Arrays.stream(array);

        stream.forEach(i-> System.out.println(i));

    }
}
