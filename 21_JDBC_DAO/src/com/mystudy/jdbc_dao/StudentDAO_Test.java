package com.mystudy.jdbc_dao;

import java.util.List;

public class StudentDAO_Test {

	public static void main(String[] args) {
		StudentDAO dao= new StudentDAO();
//		List<StudentVO> list =  dao.selectAll();
//		for (StudentVO svo : list) {
//			System.out.println(svo);
//		}
//		System.out.println();

//		System.out.println("---------- 1개 데이터 조회 (ID) ----------");
//		StudentVO vo = dao.selectOne("2021002");
//		System.out.println(vo);
//		System.out.println(vo.getId());
//		System.out.println(vo.getName());
//		System.out.println();
		String id = "2021002";
		StudentVO vo1 = dao.selectOne(id);
		System.out.println(vo1);
		
//		System.out.println("----- 입력(INSERT) -----");
//		vo1 = new StudentVO("2021011", "테스트11", 100, 90, 81);
//		System.out.println(">> 처리된 건수 : " + dao.insert(vo1));
		
//		System.out.println("----- 입력된 데이터 조회 ---- ");
//		StudentVO insertResultVO = dao.selectOne(vo1);
//		System.out.println(insertResultVO);
		
//		System.out.println("----- 수정 (UPDATE) -----");
//		vo = new StudentVO("2021011", "테스트12", 80, 70, 60);
//		int updateResult = dao.update(vo);
//		System.out.println(">> 처리된 수정 건수 : " + updateResult);
//		
//		System.out.println("----- 수정된 데이터 조회 -----");
//		StudentVO updateResultVO = dao.selectOne(vo);
//		System.out.println(updateResultVO);
		
	}

}
