package com.pici.stream.tolist;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * map排序
 */
public class StreamSortMap {

    /**
     * 根据key排序
     */
    @Test
    public void test01() {

        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("j", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        System.out.println("排序之前");
        System.out.println(unsortMap);
        Map map = new LinkedHashMap();
        /**
         * sorted排序
         *
         * forEachOrdered和forEach功能相同区别在于一个并行处理
         * 一个根据顺序输出
         */
        unsortMap.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByKey()).forEachOrdered(s-> map.put(s.getKey(),s.getValue()));
        System.out.println("排序之后");
        System.out.println(map);
    }

    /**
     * 根据value排序
     */
    @Test
    public void test02() {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("j", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
        System.out.println("排序之前");
        System.out.println(unsortMap);
        Map map = new LinkedHashMap();
        unsortMap.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue()).forEachOrdered(s->map.put(s.getKey(),s.getValue()));
        System.out.println("排序之后");
        System.out.println(map);
    }

    /**
     * 创建一个排序工具类
     * map key value 排序工具类
     */
    @Test
    public void test03() {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("j", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
        System.out.println("排序之前");
        System.out.println(unsortMap);

        Map<String, Integer> stringIntegerMap = comparingByKey(unsortMap);
        System.out.println("排序之后");
        System.out.println(stringIntegerMap);

        Map<String, Integer> stringIntegerMap1 = comparingByValue(unsortMap);
        System.out.println("排序之后---value");
        System.out.println(stringIntegerMap1);
    }


    public <K extends Comparable<? super K>,V extends Comparable<? super V>> Map<K,V> comparingByKey(Map<K,V> map) {
        Map<K,V> retMap = new LinkedHashMap();
        Stream<Map.Entry<K, V>> stream = map.entrySet().stream();
        stream.sorted(Map.Entry.comparingByKey()).forEachOrdered(s->retMap.put(s.getKey(),s.getValue()));
        return retMap;
    }

    public <K extends Comparable<? super K>,V extends Comparable<? super V>> Map<K,V> comparingByValue(Map<K,V> map) {
        Map<K,V> retMap = new LinkedHashMap();
        Stream<Map.Entry<K, V>> stream = map.entrySet().stream();
        stream.sorted(Map.Entry.comparingByValue()).forEachOrdered(s->retMap.put(s.getKey(),s.getValue()));
        return retMap;
    }




}
