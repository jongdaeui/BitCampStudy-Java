package com.mystudy.map2_vo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentMapManager {
	public static void main(String[] args) {
		// 3명의 학생데이터(성명,국어,영어,수학)를
		// StudentVO 클래스를 이용해서 만들고(저장하고)
		// "홍길동", 100, 90, 81
		// "이순신", 95, 88, 92
		// "김유신", 90, 87, 77
		// ---------------------
		// Map<String, Integer> 타입의 변수(map)에 저장하고
		// mpa에 있는 데이터를 사용해서 화면출력
		// 성명 국어 영어 수학 총점 평균
		// --------------------------
		// 홍길동 100 90 81 270 90.33
		// ...
		// -----------------------------
		// 저장된 mpa에 있는 김유신 학생의 국어 점수를 95점으로 수정
		// "김유신" 학생의 성적만 화면 출력
		// "김유신" 학생의 성명, 총점, 평균 화면 출력
		// -----------------------------------------------
		StudentVO student1 = new StudentVO("홍길동", 100, 90, 81);
		StudentVO student2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO student3 = new StudentVO("김유신", 90, 87, 77);
		
		
		
		Map<String, StudentVO> map = new HashMap<>();
		map.put(student1.getName(), student1);
		map.put(student2.getName(), student2);
		map.put(student3.getName(), student3);
		System.out.println(map);
		
		Collection<StudentVO> values = map.values();
		for (StudentVO student : values) {
			student.printData();
		}
		
		System.out.println(map.containsKey("김유신"));
		StudentVO vo = map.get("김유신");
		System.out.println(">> 변경전 : " + vo.getName() + " - " + vo.getKor());
		vo.setKor(95);
		System.out.println(">> 변경후 : " + vo.getName() + " - " + vo.getKor());
		
		
		
		
		
	}
}
