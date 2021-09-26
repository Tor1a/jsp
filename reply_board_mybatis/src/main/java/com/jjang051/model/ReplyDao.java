package com.jjang051.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ReplyDao {

	// insert (새글 썼을때....)
	public int insertBoard(ReplyDto replyDto) {
		int result = 0;

		int reGroup = 0;
		int reStep = 1;
		int reLevel = 1;
		reGroup = getMaxRegroup() + 1;
		
		replyDto.setReGroup(reGroup);
		replyDto.setReStep(reStep);
		replyDto.setReLevel(reLevel);
		
		//SqlSession sqlSession = sqlSessionFactory.openSession();
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertBoard",replyDto);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
	
	public int getMaxRegroup() {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("getMaxReGroup");
		sqlSession.close();
		return result;
	}
	public List<ReplyDto> getAllList(int start, int end) {
		//getAllList 라는 Mapper에 있는 id값을 가진 곳에 parameterType이 HashMap일때 
		HashMap<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		
		List<ReplyDto> replyList = null;

		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		replyList = sqlSession.selectList("getAllList",page);
		sqlSession.close();
		return replyList;
	}
	/*
	public List<ReplyDto> getSearchAllList(String field, String searchWord,int start, int end) {
		//getAllList 라는 Mapper에 있는 id값을 가진 곳에 parameterType이 HashMap일때 
		HashMap<String, Object> searchData = new HashMap<String, Object>();
		searchData.put("field", field.toString());
		searchData.put("searchWord", searchWord.toString());
		searchData.put("start", (int)start);
		searchData.put("end", (int)end);
		
		
		List<ReplyDto> replyList = null;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		replyList = sqlSession.selectList("getSearchAllList",searchData);
		sqlSession.close();
		return replyList;
	}
	*/
	
	public List<ReplyDto> getSearchAllList(String field, 
			String searchWord,int start, int end) {
		List<ReplyDto> replyList = null;
		HashMap<String,Object> searchListData = 
				new HashMap<String,Object>(); //객체의 최상위 Object
		searchListData.put("field", field);
		searchListData.put("searchWord", searchWord);
		searchListData.put("start", start);
		searchListData.put("end", end);
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		replyList = 
	sqlSession.selectList("getSearchAllList",searchListData);
		sqlSession.close();
		return replyList;
	}
	
	public List<ReplyDto> getSearchAllList(SearchDto searchDto) {
		List<ReplyDto> replyList = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		replyList = 
	sqlSession.selectList("getSearchAllList",searchDto);
		sqlSession.close();
		return replyList;
	}
	public int getSearchTotal(String field, String searchWord) {
		int result = 0;
		System.out.println("searchWord=="+searchWord);
		HashMap<String, String> searchData = 
				new HashMap<String,String>();
		searchData.put("field", field);
		searchData.put("searchWord", searchWord);
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("getSearchTotal",searchData);
		sqlSession.close();
		return result;
	}
	
	/*
	public int getSearchTotal(String field, String searchWord) {
		HashMap<String, String> searchData = new HashMap<String, String>();
		searchData.put("field", field);
		searchData.put("searchWord", searchWord);
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.selectOne("getSearchTotal",searchData);
		sqlSession.close();
		System.out.println("result==="+result);
		return result;
	}
	*/
	
	public int getTotal() {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("getTotal");
		sqlSession.close();
		return result;
	}
	
	public int updateReadCount(int no) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateReadCount",no);
		sqlSession.commit(); //select 빼고는 전부 commit()을 하면 된다.
		sqlSession.close();
		return result;
	}
	
	public ReplyDto getSelectOne(int no) {
		ReplyDto  replyDto = null;
		updateReadCount(no);
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		replyDto = sqlSession.selectOne("getBoardSelectOne",no);
		sqlSession.close();
		return replyDto;
	}
	/*
	public int insertReplyBoard(ReplyDto replyDto) {
		int result = 0;
		int reGroup = replyDto.getReGroup();
		int reLevel = replyDto.getReLevel();
		updateReLevel(reGroup, reLevel);
		
		replyDto.setReStep(replyDto.getReStep()+1);
		replyDto.setReLevel(replyDto.getReLevel()+1);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		result = sqlSession.insert("insertReplyBoard",replyDto);
		sqlSession.close();
		return result;
	}
	public void updateReLevel(int reGroup, int reLevel) {
		HashMap<String, Integer> replyLevel = new HashMap<String, Integer>();
		replyLevel.put("reGroup", reGroup);
		replyLevel.put("reLevel", reLevel);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.update("updateReLevel",replyLevel);
		sqlSession.close();
	}
	*/
	
	public int updateReLevel(ReplyDto replyDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateReLevel",replyDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public int insertReplyBoard(ReplyDto replyDto) {
		int result = 0;
		
		int reGroup = replyDto.getReGroup();
		int reStep =  replyDto.getReStep();   
		int reLevel = replyDto.getReLevel();
		
		updateReLevel(replyDto);
		replyDto.setReGroup(reGroup);
		replyDto.setReStep(reStep + 1);
		replyDto.setReLevel(reLevel + 1);
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertReplyBoard",replyDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public ReplyDto getSelectPrev(int num) {
		ReplyDto replyDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		replyDto = sqlSession.selectOne("getSelectPrev",num);
		sqlSession.close();
		return replyDto;
	}
	public ReplyDto getSelectNext(int num) {
		ReplyDto replyDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		replyDto = sqlSession.selectOne("getSelectNext",num);
		sqlSession.close();
		return replyDto;
	}
	
}












