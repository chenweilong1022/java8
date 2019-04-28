package com.pici.lambda.comparator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 过滤
 */
public class Filter {


    /**
     * 传统过滤掉list
     */
    @Test
    public void filter1() {

        List<String> list = Arrays.asList("1", "2", "3");

        List<String> filter = getFilter(list, "2");
        for (String s : filter) {
            System.out.println(s);
        }

    }

    /**
     * stream过滤掉list
     */
    @Test
    public void filter2() {
        List<String> list = Arrays.asList("1", "2", "3");

        List<String> collect = list.stream().filter(s -> s.equals("2")).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }
    }

    /**
     * 传统过滤对象
     */
    @Test
    public void filterObj1() {

        List<Person> people = Arrays.asList(
                new Person("a",10),
                new Person("b",20),
                new Person("c",30)
        );
        List<Person> b = getPersonByName(people, "b");
        b.forEach(System.out::println);
    }

    @Test
    public void filterObj2() {
        List<Person> people = Arrays.asList(
                new Person("a",10),
                new Person("b",20),
                new Person("c",30)
        );

        Person person1 = people.stream().filter(person -> person.getName().equals("b")).findAny().orElse(null);
        System.out.println(person1);
        Person person2 = people.stream().filter(person -> person.getName().equals("e")).findAny().orElse(null);
        System.out.println(person2);

        Person person3 = people.stream().filter(person -> person.getName().equals("b") && person.getAge() == 20).findAny().orElse(null);
        System.out.println(person3);

        Person person4 = people.stream().filter(person -> {
            if (person.getName().equals("b") && person.getAge() == 20) {
                return true;
            }
            return false;
        }).findAny().orElse(null);
        System.out.println(person4);

    }


    @Test
    public void filterMap() {

        List<Person> people = Arrays.asList(
                new Person("a",10),
                new Person("b",20),
                new Person("c",30)
        );

        List<Integer> collect = people.stream().filter(person -> person.getName().equals("a")).map(Person::getAge).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }

    public List<Person> getPersonByName(List<Person> list,String filter) {
        List<Person> list1 = new ArrayList<>();
        for (Person s : list) {
            if (s.getName().equals(filter)) {
                list1.add(s);
            }
        }
        return list1;
    }




    public List<String> getFilter(List<String> list,String filter) {
        List<String> list1 = new ArrayList<>();
        for (String s : list) {
            if (!s.equals(filter)) {
                list1.add(s);
            }
        }
        return list1;
    }


}
