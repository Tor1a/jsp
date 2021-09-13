package com.jjang051.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.ReplyDao;
import com.jjang051.model.ReplyDto;
import com.jjang051.utils.ScriptWriterUtil;

@WebServlet("/BoardWrite.do")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardWriteController() {
        super();

    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ReplyDao replyDao = new ReplyDao();
		ReplyDto replyDto = new ReplyDto();
		
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
		String contents = request.getParameter("contents");
		replyDto.setName(userName);
		replyDto.setEmail(email);
		replyDto.setSubject(subject);
		replyDto.setPassword(password);
		replyDto.setContents(contents);
		
		//reGroup, reStep, reLevel
		
		// 경고 , 경고창 띄우고 다음 페이지로 넘기기, 경고창 띄우고 이전 페이지로 돌아가기
		int result = replyDao.insertBoard(replyDto);
		if(result > 0) {
			ScriptWriterUtil.alertAndNext(response, "글이 입력되었습니다.", "BoardList.do");//
		}
	}

}








