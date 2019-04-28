package com.pici.lambda.comparator;

import lombok.Data;
import org.junit.Test;
import org.springframework.util.comparator.ComparableComparator;

public class Comparator {

    /**
     * 传统的排序写法
     */
    @Test
    public void comparator1() {

        java.util.Comparator<Person> comparator = new java.util.Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Person p1= new Person();
        Person p2= new Person();
        p1.setName("chenweilong");
        p2.setName("chenweilong1022");

        int compare = comparator.compare(p1, p2);

        System.out.println(comparator);
        System.out.println(compare);

    }


    @Test
    public void comparator2() {

        java.util.Comparator<Person> comparator = (Person o1,Person o2) ->  o1.getName().compareTo(o2.getName());

        Person p1= new Person();
        Person p2= new Person();
        p1.setName("chenweilong");
        p2.setName("chenweilong1022");

        int compare = comparator.compare(p1, p2);
        System.out.println(compare);
        System.out.println(comparator);


    }

}
@Data
class Person {
    private String name;
    private int age;
    private Double gz;

    public Person(String name, int age, Double gz) {
        this.name = name;
        this.age = age;
        this.gz = gz;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}

@Data
class Datas {
    private String name;
    private int age;
    private Double gz;
}
