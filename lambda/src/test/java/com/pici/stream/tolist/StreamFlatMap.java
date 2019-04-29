package com.pici.stream.tolist;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * stream flatMap示例
 */
public class StreamFlatMap {

    /**
     * 在Java 8中，流可以保存不同的数据类型，
     * 例如:但是，流操作(filter、sum、distinct…)和收集器不支持它
     * ，因此，我们需要flatMap()来执行以下转换:flatMap example
     *
     * 需要使用flatmap转换
     */
    @Test
    public void test01() {
        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        Stream<String[]> stream = Arrays.stream(data);

        Stream<String[]> stream1 = stream.filter(s -> "a".equals(s));
        stream1.forEachOrdered(s-> System.out.println(s));

//        在上面的例子中，我们应该使用flatMap()将流转换为流。此处输出为空

    }

    @Test
    public void test02() {

        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        Stream<String> stringStream = Arrays.stream(data).flatMap(map -> Arrays.stream(map)).filter(s -> s.equals("a"));


        stringStream.forEachOrdered(s -> System.out.println(s));
    }

}
