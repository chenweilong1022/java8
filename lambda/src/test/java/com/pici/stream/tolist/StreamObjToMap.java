package com.pici.stream.tolist;

import com.pici.entity.Hosting;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * stream将数组对象转换为map
 */
public class StreamObjToMap {


    /**
     * 将一个数组对象转换为map
     */
    @Test
    public void test01() {
        List<Hosting> hostings = Hosting.hostings();
        Map<Integer, Hosting> collect = hostings.stream().collect(Collectors.toMap(Hosting::getId, x->x));
        System.out.println(collect);
        Map<Integer, Hosting> collect1 = hostings.stream().collect(Collectors.toMap(x -> x.getId(), x -> x));
        System.out.println(collect1);
    }


}
