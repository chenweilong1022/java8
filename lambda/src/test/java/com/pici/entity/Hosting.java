package com.pici.entity;
import java.util.ArrayList;

import lombok.Data;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
public class Hosting {
    private int Id;
    private String name;
    private Date createdDate;


    public Hosting(int id, String name, Date createdDate) {
        Id = id;
        this.name = name;
        this.createdDate = createdDate;
    }

    public static List<Hosting> hostings(){
        List<Hosting> hostinglist=new ArrayList<>();
        hostinglist.add(new Hosting(1,"qq",new Date()));
        hostinglist.add(new Hosting(2,"baidu",new Date()));
        hostinglist.add(new Hosting(3,"ali",new Date()));
        hostinglist.add(new Hosting(4,"xinlang",new Date()));
        hostinglist.add(new Hosting(5,"huxiu",new Date()));
        return hostinglist;
    }
}
