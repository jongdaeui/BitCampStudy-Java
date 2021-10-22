package com.boardproject.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.boardproject.dto.MemberDTO;
import com.boardproject.util.CommonUtil;

public class MemberDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuilder sql;

	public MemberDAO() {
	}

	// 입력된 계정이 관리자 여부 확인 (MEMBER 테이블의 MEMBER_ID 값은 UK 지정되어 유일한 값임)
	public int checkAdmin(MemberDTO memberDTO) {
		int result = 0;
		try {
			conn = CommonUtil.getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MEMBER_NO, MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_PHONE, MEMBER_EMAIL ");
			sql.append("  FROM MEMBER ");
			sql.append(" WHERE MEMBER_ID = 'admin' ");
			sql.append("   AND MEMBER_PW = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, memberDTO.getMemberPw());

			rs = pstmt.executeQuery();

			if (rs.next())
				return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}

	// 로그인 요청 정보 검증 메소드 (Read)
	public int checkAccount(MemberDTO memberDTO) {
		int result = 0;
		conn = CommonUtil.getConnection();

		try {
			
			if (checkAdmin(memberDTO) == 1) return 2;
			
			sql = new StringBuilder();
			sql.append("SELECT MEMBER_NO, MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_PHONE, MEMBER_EMAIL ");
			sql.append("  FROM MEMBER ");
			sql.append(" WHERE MEMBER_ID = ? ");
			sql.append("   AND MEMBER_PW = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, memberDTO.getMemberId());
			pstmt.setString(2, memberDTO.getMemberPw());

			rs = pstmt.executeQuery();

			if (rs.next())
				return 1;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			CommonUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	// 중복된 아이디 검증 메소드
	public int findById(String userInputInfo) {
		int result = 0;
		conn = CommonUtil.getConnection();

		try {
			
			sql = new StringBuilder();
			sql.append("SELECT MEMBER_ID ");
			sql.append("  FROM MEMBER ");
			sql.append(" WHERE MEMBER_ID = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, userInputInfo);

			rs = pstmt.executeQuery();

			if (rs.next())
				return 1;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			CommonUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public int insert(MemberDTO userInfo) {
		int result = 0;
		conn = CommonUtil.getConnection();
		
		try {
			sql = new StringBuilder();
			sql.append("INSERT INTO MEMBER ");
			sql.append("VALUES (SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, userInfo.getMemberId());
			pstmt.setString(2, userInfo.getMemberPw());
			pstmt.setString(3, userInfo.getMemberName());
			pstmt.setString(4, userInfo.getMemberPhone());
			pstmt.setString(5, userInfo.getMemberEmail());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CommonUtil.close(conn, pstmt);
		}
		return result;
	}
}
