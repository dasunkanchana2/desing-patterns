package com.dasun.core.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapFetcher {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);

        for(Map.Entry<String, Integer> entry:map.entrySet()){
            System.out.println(entry.getValue());
        }

    }
}
