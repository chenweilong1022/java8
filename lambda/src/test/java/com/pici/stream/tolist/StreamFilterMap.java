package com.pici.stream.tolist;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 过滤map示例
 */
public class StreamFilterMap {

    @Test
    public void test01() {

        /**
         * java8以前过滤一个map示例
         */
        String result = "";
        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");

        for (Map.Entry<Integer, String> entry : HOSTING.entrySet()) {
            if ("linode.com".equals(entry.getValue())){
                result = entry.getValue();
            }
        }
        System.out.println(result);
        /**
         * java8之后过滤一个map的示例
         */

        String collect = HOSTING.entrySet().stream().filter(h -> "linode.com".equals(h.getValue())).map(h -> h.getValue()).collect(Collectors.joining());
        System.out.println(collect);
        Map<Integer, String> collect1 = HOSTING.entrySet().stream().filter(h -> 2 == h.getKey()).collect(Collectors.toMap(h -> h.getKey(), h -> h.getValue()));
        System.out.println(collect1);

    }

}
