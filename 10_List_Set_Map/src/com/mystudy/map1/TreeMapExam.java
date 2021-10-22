package com.mystudy.map1;

import java.util.TreeMap;

public class TreeMapExam {
	public static void main(String[] args) {
		TreeMap<String, Integer> map = new TreeMap<>();
		map.put("홍길동", 100);
		map.put("김유신", 100);
		map.put("강감찬", 88);
		map.put("100", 93);
		map.put("20", 93);
		map.put("10", 93);
		map.put("a", 93);
		map.put("A", 93);
		
		System.out.println("map : " + map);
		
		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		
		
		
		
		
	}
}
