package com.mystudy.set1_hashset;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSetLotto {
	public static void main(String[] args) {
		// Set을 이용한 로또 만들기 : 1 ~ 45 랜덤 숫자 6개를 Set에 저장
		// 로또 번호 6개를 추첨하고, 작은 숫자부터 순서대로 화면 출력
		// Math.random() : (int)(Math.random() * 45 + 1)
		// 출력은 작은 숫자부터 큰 숫자 형태로
		// 예) 금주의 로또 번호 : 5, 8, 10, 25, 33, 41
		// ---------------------------------------
		Set<Integer> set = new HashSet<>();
	
		while(set.size() < 6) {
			set.add((int) (Math.random() * 45 + 1));
		}
		System.out.println("---------- 랜덤 번호 ---------");
		System.out.println(set);
		
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		
		System.out.println("------- 오름차순 정렬 후 -------");
		System.out.println(list);
		
	}
}
