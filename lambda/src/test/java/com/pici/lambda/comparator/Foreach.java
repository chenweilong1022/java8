package com.pici.lambda.comparator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * foreach遍历
 */
public class Foreach {


    /**
     * 传统方法foreach
     */
    @Test
    public void foreach1() {
        Map<String, Integer> maps = getMaps();

        for (Map.Entry<String, Integer> e : maps.entrySet()) {
            System.out.println(e.getKey() + e.getValue());
        }

    }

    /**
     * lambda + foreach遍历map
     */
    @Test
    public void foreach2() {

        Map<String, Integer> maps = getMaps();
        maps.forEach((k,v)->{
            System.out.println("key:" + k + "---value:" + v);
        });

    }

    /**
     * 传统方法遍历list
     */
    @Test
    public void foreach3() {
        List<String> lists = getLists();
        for (String list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void foreach4() {
        List<String> lists = getLists();

//        lists.forEach(s-> System.out.println(s));
//        lists.forEach(s-> {
//            if (s.equals("b")) {
//                System.out.println(s);
//            }
//        });

//        lists.forEach(System.out::println);

        lists.stream().filter(s->!s.contains("b")).forEach(System.out::println);
    }








    public Map<String,Integer> getMaps() {
        Map map = new HashMap();
        map.put("a",10);
        map.put("b",20);
        map.put("c",30);
        map.put("d",40);
        map.put("e",50);
        map.put("f",60);
        return map;
    }


    public List<String> getLists() {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        strings.add("f");
        strings.add("g");
        strings.add("h");
        return strings;
    }


}
