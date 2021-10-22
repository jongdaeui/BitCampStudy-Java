package com.mystudy.set2_hashset_vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StudentSetManeger {
	public static void main(String[] args) {
		// 3명의 학생데이터(성명,국어,영어,수학)를
		// StudentVO 클래스를 이용해서 만들고(저장하고)
		// "홍길동", 100, 90, 81
		// "이순신", 95, 88, 92
		// "김유신", 90, 87, 77
		// ---------------------
		// HashSet<StudentVO> 타입의 변수(set)에 저장하고
		// set에 있는 데이터를 사용해서 화면출력
		// 성명 국어 영어 수학 총점 평균
		// --------------------------
		// 홍길동 100 90 81 270 90.33
		// ...
		// -----------------------------
		// 저장된 set에 있는 김유신 학생의 국어 점수를 90점으로 수정
		// "김유신" 학생의 성적만 화면 출력
		// -----------------------------------------------
		StudentVO student1 = new StudentVO("홍길동", 100, 90, 81);
		StudentVO student2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO student3 = new StudentVO("김유신", 90, 87, 77);
		Set<StudentVO> set = new HashSet<>();
		set.add(student1);
		set.add(student2);
		set.add(student3);

		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------");
		for (StudentVO vo : set) {
			vo.printData();
		}
		System.out.println("------------------------------------------------");
		System.out.println();
		Iterator<StudentVO> ite = set.iterator();
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------");
		while (ite.hasNext()) {
			StudentVO student = ite.next();
			student.printData();
		}
		System.out.println("------------------------------------------------");
		System.out.println();

		for (StudentVO student : set) {
			if ("김유신".equals(student.getName())) {
				student.setKor(95);
				break;
			} 
		}

		for (StudentVO vo : set) {
			if (vo.getName().contains("김유신")) {
				System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
				System.out.println("------------------------------------------------");
				vo.printData();
				System.out.println("------------------------------------------------");
				System.out.println();

			}
		}
	}
}
