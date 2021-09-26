package com.jjang051.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mindrot.bcrypt.BCrypt;

public class MemberDao {
	
	public List<MemberDto> showAllMember() {
		List<MemberDto> memberList = null;
		SqlSession sqlSession =  MybatisConnectionFactory.getSqlSession();
		memberList = sqlSession.selectList("showAllMember"); // MemberMapper  에 있는 id 찾아서 쓰기....
		sqlSession.close();
		return memberList;
	}
	
	public MemberDto getSelectOne(int no) {
		MemberDto memberInfo = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		memberInfo = sqlSession.selectOne("getMemberSelectOne",no);
		sqlSession.close();
		return memberInfo;
	}
	public int insertMember(MemberDto memberDto) {
		int result = 0;
		
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		//SqlSession sqlSession = sqlSessionFactory.openSession(true);true를 적으면 자동 커밋
		result = sqlSession.insert("insertMember",memberDto);
		sqlSession.commit(); // select 빼고는 commit();
		sqlSession.close();
		return result;
	}
	
	public String getPassword(int no) {
		String password = "";
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		password = sqlSession.selectOne("getPassword",no);
		sqlSession.close();
		return password;
	}
	
	public int deleteMember(int no) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteMember",no);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
}




