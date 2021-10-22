package com.mystudy.jdbc_member.dao;

import java.sql.Connection;
import java.util.List;

import com.mystudy.jdbc_member.common.CommonUtil;
import com.mystudy.jdbc_member.vo.MemberVO;

public class MemberDAO {
	//SELECT : 테이블 전체 데이터 조회 - selectAll : List<MemberVO>
	//SELECT : 하나의 데이터 조회(ID) - selectOne : MemberVO
	//SELECT : 하나의 데이터 조회(VO) - selectOne : MemberVO
	//SELECT : 로그인(id, password) - checkIdPassword : boolean
	//SELECT : 전체 인원수 확인 - getCountAll() : int
	
	//INSERT : VO 객체를 받아서 입력 - insert : int
	
	//UPDATE : 이름 수정 - updateName(vo) : boolean
	//UPDATE : 이름 수정 - updateName(id,name) : boolean
	//UPDATE : 패스워드 수정 - updatePassword : boolean
	//UPDATE : 전화번호 수정 - updatePhone : boolean
	//UPDATE : 주소 수정 - updateAddress : boolean
	
	//DELETE : VO 객체를 받아서 삭제 - delete : int
	//DELETE : 키값(ID) 받아서 삭제 - delete : int
	
	public List<MemberVO> selectAll() {
		List<MemberVO> list = null;
		
		Connection conn = CommonUtil.getConnection();
		if (conn == null) return null;
		
		
		return list;
	}
}








