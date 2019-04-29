package com.pici.lambda.comparator;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamGroup {

    /**
     * 对list进行分组
     */
    @Test
    public void streamGroup1() {

        List<String> list = Arrays.asList("a", "a", "b", "b", "c", "c", "c", "d");

        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

    }

    /**
     * 对list进行分组
     */
    @Test
    public void streamGroup2() {

        List<String> list = Arrays.asList("a", "a", "b", "b", "c", "c", "c", "d");

        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        Map<String, Long> map = new LinkedHashMap();

        collect.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed()).forEachOrdered(e->map.put(e.getKey(),e.getValue()));

        System.out.println(map);

    }


    /**
     * 对list进行分组
     */
    @Test
    public void streamGroup3() {

        List<Person> people = Arrays.asList(
                new Person("a",10),
                new Person("a",10),
                new Person("b",20),
                new Person("b",20),
                new Person("b",20),
                new Person("c",30)
        );

        Map<String, Long> collect = people.stream().collect(Collectors.groupingBy(Person::getName, Collectors.summingLong(Person::getAge)));
        System.out.println(collect);

        people.stream();

    }

    /**
     * 对list进行分组
     */
    @Test
    public void streamGroup4() {

        List<Person> personList = new ArrayList<>();

        personList.add(new Person("xiaoming",15,1000.00));
        personList.add(new Person("xiaohong",20,8000.00));
        personList.add(new Person("xiaohong",30,8000.00));
        personList.add(new Person("xiaolv",22,5000.02));
        personList.add(new Person("xiaolan",11,7000.03));

        Map<Double, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(Person::getGz));
        System.out.println(collect);

        Map<Double, List<String>> collect1 = personList.stream().collect(Collectors.groupingBy(Person::getGz, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println(collect1);

    }




}
