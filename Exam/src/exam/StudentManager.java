package exam;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentManager {
	public static void main(String[] args) {
		StudentVO student1 = new StudentVO("홍길동", 100, 90, 81);
		StudentVO student2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO student3 = new StudentVO("김유신", 90, 87, 77);
		StudentVO student4 = new StudentVO("종대의", 88, 95, 76);
		StudentVO student5 = new StudentVO("김지니", 98, 100, 85);

		Map<String, StudentVO> map = new HashMap<>();
		map.put(student1.getName(), student1);
		map.put(student2.getName(), student2);
		map.put(student3.getName(), student3);
		map.put(student4.getName(), student4);
		map.put(student5.getName(), student5);

		Collection<StudentVO> values = map.values();
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("---------------------------------------------");
		for (StudentVO student : values) {
			student.printData();	
		}
		
		System.out.println();

		if (map.containsKey("홍길동")) {
			StudentVO student = map.get("홍길동");
			student.setEng(95);
			student.setMath(85);
			System.out.println("홍길동 학생 성적 수정");
			System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
			System.out.println("---------------------------------------------");
			student.printData();
		}

		System.out.println();

		System.out.println("     ======== 학생 최종 성적 ========");
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("---------------------------------------------");
		for (StudentVO student : values) {
			student.printData();
		}
		System.out.println();

		System.out.println("성명\t총점\t평균");
		System.out.println("---------------------");

		for (StudentVO student : values) {
			System.out.println(student.getName() + "\t" + student.getTot() + "\t" + student.getAvg());
		}
	}
}
