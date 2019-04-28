package com.pici.lambda.comparator;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {


    /**
     * 传统排序方式
     */
    @Test
    public void sort1() {

        List<Person> list = getList();

        System.out.println("befor sort--排序之前");
        for (Person person : list) {
            System.out.println(person);
        }

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println("after sort--排序之后");

        for (Person person : list) {
            System.out.println(person);
        }


    }

    /**
     * lambda排序方式
     */
    @Test
    public void sort2() {

        List<Person> list = getList();
        System.out.println("befor sort--排序之前");
        for (Person person : list) {
            System.out.println(person);
        }


//        Collections.sort(list,(o1,o2)->{return o1.getAge() - o2.getAge();});

        list.sort((o1,o2)->{return o1.getAge() - o2.getAge();});
        System.out.println("after sort--排序之后");

        list.forEach(System.out::println);

    }

    /**
     * lambda排序方式 --其他
     */
    @Test
    public void sort3() {

        List<Person> list1 = getList1();

        System.out.println("after sort -排序之前");

        list1.forEach( s->{
            System.out.println(s);
        });

        list1.sort((o1,o2)->{return o1.getGz().compareTo(o2.getGz());});

        System.out.println("after sort -排序之后");

        list1.forEach( s->{
            System.out.println(s);
        });

        Comparator<Person> c = (o1,o2)->{return o1.getGz().compareTo(o2.getGz());};

        list1.sort(c.reversed());
        System.out.println("after sort -颠倒排序之后");

        list1.forEach( s->{
            System.out.println(s);
        });

    }




    public List<Person> getList() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("xiaoming",15));
        personList.add(new Person("xiaohong",20));
        personList.add(new Person("xiaolv",22));
        personList.add(new Person("xiaolan",11));
        return personList;
    }

    public List<Person> getList1() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("xiaoming",15,1000.00));
        personList.add(new Person("xiaohong",20,8000.00));
        personList.add(new Person("xiaolv",22,5000.02));
        personList.add(new Person("xiaolan",11,7000.03));
        return personList;
    }

}


