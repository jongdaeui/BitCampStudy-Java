package com.mystudy.jdbc2_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Insert {

	public static void main(String[] args) {
		// 0. JDBC 라이브러리 개발환경 설정 (빌드경로에 등록)
		// 1 .JDBC 드라이버 로딩
		// 2. DB 연결 - Connection 객체 생성 <- DriverManager
		// 3. Statement 문 실행 (SQL 문 실행)
		// 4. SQL 실행 결과에 대한 처리
		// - SELECT : 조회 (검색) 데이터 결과 값에 대한 처리
		// - INSERT, UPDATE, DELETE : int 값(건수) 처리
		// 5. 클로징 처리에 의한 자원 반납
		Connection conn = null;
		Statement stmt = null;
		
		try {
			// 1 .JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 2. DB 연결 - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"mystudy", "mystudypw");
			
			// 3. Statement 문 실행 (SQL 문 실행)
			// 3-1. Connection 객체로부터 Statement 객체 생성
			stmt =  conn.createStatement();

			String id = "2021007";
			String name = "홍경래2";
			int kor = 95;
			int eng = 85;
			int math = 70;
			
			String sql = "";
			sql += "INSERT INTO STUDENT";
			sql += "	   (ID, NAME, KOR, ENG, MATH) ";
			sql += "VALUES ('" + id + "', '" + name + "', " 
							+ kor + ", " + eng + ", " + math + ") ";
			System.out.println("sql : " + sql);
			
			// 3-2. Statement 객체를 이용해서 SQL 문 실행
			int result = stmt.executeUpdate(sql);
			
			// 4. SQL 실행결과에 대한 처리
			System.out.println(">> 처리건수 : " + result);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}

}
