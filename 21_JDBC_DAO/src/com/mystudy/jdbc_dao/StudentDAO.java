package com.mystudy.jdbc_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Data Access Object / Database Access Object
// 데이터 베이스 (DB)와 연동해서 CRUD를 구현하는 클래스
public class StudentDAO {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "mystudy";
	private final String PASSWORD = "mystudypw";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// static 초기화 구문
	static {
		// 1 .JDBC 드라이버 로딩
		try {
			Class.forName(DRIVER);
			System.out.println(">> JDBC 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("[예외발생] 드라이버 로딩 실패 !!");
		}
	}
	// SELECT : 테이블 전체 데이터 조회 - selectAll : List<StudentVO>
	// SELECT : 한개의 데이터 조회(ID) - selectOne : StudentVO
	// SELECT : 한개의 데이터 조회(VO) - selectOne : StudentVO
	// INSERT : VO 객체를 받아서 입력처리 - insertOne : int
	// UPDATE : VO 객체를 받아서 수정처리 - updateOne : int
	// DELETE : VO 객체를 받아서 삭제처리 - deleteOne : int
	// DELETE : 키값 (ID)를 받아서 삭제 - deleteOne : int
	///////////////////////////////////////////////////
	
	// SELECT : 테이블 전체 데이터 조회 - selectAll : List<StudentVO>
	public List<StudentVO> selectAll() {
		List<StudentVO> list = null;
		
		try {
			// 2. DB연결 - Connection 객체 생성
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. SQL문 실행 결과에 대한 처리
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sb.append("  FROM STUDENT ");
			sb.append(" ORDER BY ID");
			
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			// 4. SQL문 실행
			list  = new ArrayList<StudentVO>();	
			while (rs.next()) {
				// DB 데이터 하나를 StudentVO에 저장 + 리스트에 추가
				StudentVO vo = new StudentVO(
						rs.getString("ID"),
						rs.getString("NAME"),
						rs.getInt("KOR"),
						rs.getInt("ENG"),
						rs.getInt("MATH"),
						rs.getInt("TOT"),
						rs.getDouble("AVG"));
				// 리스트에 추가
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	
	// SELECT : 한개의 데이터 조회(ID) - selectOne : StudentVO
	public StudentVO selectOne(String id) {
		StudentVO vo = null;
		// (할일) DB연결, SQL문 실행해서 결과값을 vo변수에 저장하고 리턴
		try {
			// 2. DB 연결
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. SQL문 실행 결과에 대한 처리
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sb.append("  FROM STUDENT ");
			sb.append(" WHERE ID = ? ");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			// 4. SQL 실행 결과에 대한 처리
			if (rs.next()) {
					vo = new StudentVO(
					rs.getString("ID"),
					rs.getString("NAME"),
					rs.getInt("KOR"),
					rs.getInt("ENG"),
					rs.getInt("MATH"),
					rs.getInt("TOT"),
					rs.getDouble("AVG"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 사용객체 close
			close(conn, pstmt, rs);
		}
		return vo;
	}
	
	// SELECT : 한개의 데이터 조회(VO) - selectOne : StudentVO
	public StudentVO selectOne(StudentVO vo) {
		return selectOne(vo.getId());
	}
	
	// SELECT : 한개의 데이터 조회(name) - selectOne : List<StudentVO>

	// INSERT : VO 객체를 받아서 입력처리 - insertOne : int
	public int insert(StudentVO vo) {
		int result = 0;
		try {
			// 2. DB연결
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. SQL문 실행 결과에 대한 처리
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO STUDENT ");
			sb.append("   	  (ID, NAME, KOR, ENG, MATH, TOT, AVG)  ");
			sb.append("VALUES (?, ?, ?, ?, ?, ?, ? )");
			
			pstmt = conn.prepareStatement(sb.toString());
			
			// ? 값 설정
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5, vo.getMath());
			pstmt.setInt(6, vo.getTot());
			pstmt.setDouble(7, vo.getAvg());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return result;
	}
	
	// UPDATE : VO 객체를 받아서 수정처리 - updateOne : int
	public int update(StudentVO vo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE STUDENT ");
			sb.append("		  SET NAME = ? ");
			sb.append("		  	, KOR = ? ");
			sb.append("		    , ENG = ? ");
			sb.append("		    , MATH = ? ");
			sb.append(" WHERE ID = ? ");
			
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMath());
			pstmt.setString(5, vo.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return result;
	}
	
	// UPDATE : 이름수정 (id, name) - update : int
	
	
	// DELETE : VO 객체를 받아서 삭제처리 - deleteOne : int
	// DELETE : 키값 (ID)를 받아서 삭제 - deleteOne : int
	public int delete(String id) {
		int result = 0;
		
		return result;
	}
	
	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null) pstmt.close();
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
