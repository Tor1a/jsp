package com.jjang051.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.ReplyDao;
import com.jjang051.model.ReplyDto;

@WebServlet("/ReplyWrite.do")
public class ReplyWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReplyWriteController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // 요청 받을때 한글 깨짐 방지...
		response.setContentType("text/html; charset=UTF-8");  // 내보낼때 html, 한글처리를 위해 utf-8
				
		String userName = request.getParameter("userName");  // String
		String subject = request.getParameter("subject");  // String
		String email = request.getParameter("email");  // String
		String password = request.getParameter("password");  // String
		String contents = request.getParameter("contents");  // String
		
		ReplyDto replyDto = new ReplyDto();
		replyDto.setName(userName);
		replyDto.setSubject(subject);
		replyDto.setEmail(email);
		replyDto.setPassword(password);
		replyDto.setContents(contents);
		
		ReplyDao replyDao = new ReplyDao();
		int result = replyDao.insertBoard(replyDto);
		if(result>0) {
			response.sendRedirect("ReplyList.do");
		}
		
		
//		replyDto.setSubject(subject);
//		replyDto.setUserName(userName);
//		
//		System.out.println("subject==="+subject);
//		System.out.println("userName==="+userName);
//		System.out.println("=====================");
//		System.out.println("subject==="+replyDto.getSubject());
//		System.out.println("userName==="+replyDto.getUserName());
		
		
		//Dto
	}
}
