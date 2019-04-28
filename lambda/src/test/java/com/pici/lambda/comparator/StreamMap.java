package com.pici.lambda.comparator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {

    /**
     * java操作数组内改变大小 操作数组内数字
     */
    @Test
    public void streamMap1() {

        /**
         * java8以前将数组内的字母大写
         */
        List<String> smallList = Arrays.asList("a", "b", "c", "d", "e");
        List<String> upList = new ArrayList<>();
        for (String s : smallList) {
            upList.add(s.toUpperCase());
        }
        System.out.println(smallList);
        System.out.println(upList);


        List<String> collect = smallList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);

        List<String> collect1 = smallList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect1);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> collect2 = list.stream().map(integer -> integer * 10).collect(Collectors.toList());
        System.out.println(collect2);

    }


    /**
     * 获取一个对象中所有 name的值
     */
    @Test
    public void streamMap2() {

        List<Person> people = Arrays.asList(
                new Person("a",10),
                new Person("b",20),
                new Person("c",30)
        );

        List<String> result = new ArrayList<>();

        for (Person person : people) {
            result.add(person.getName());
        }

        System.out.println(result);


        List<String> collect = people.stream().map(person -> person.getName()).collect(Collectors.toList());
        System.out.println(collect);


    }

    /**
     * list对象转换为其他的list对象
     */
    @Test
    public void streamMap3() {

        List<Person> people = Arrays.asList(
                new Person("a",10),
                new Person("b",20),
                new Person("c",30)
        );

        List<Datas> list = personToDatas(people);
        System.out.println(people);
        System.out.println(list);

        List<Datas> collect = people.stream().map(person -> {
            Datas datas = new Datas();
            datas.setName(person.getName());
            datas.setAge(person.getAge());
            datas.setGz(person.getGz());
            return datas;
        }).collect(Collectors.toList());

        System.out.println(collect);


    }

    public List<Datas> personToDatas(List<Person> people) {
        List<Datas> list = new ArrayList<>();
        for (Person person : people) {
            Datas datas = new Datas();
            datas.setName(person.getName());
            datas.setAge(person.getAge());
            datas.setGz(person.getGz());
            list.add(datas);
        }
        return list;
    }

}
