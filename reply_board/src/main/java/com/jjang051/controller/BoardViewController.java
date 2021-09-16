package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.ReplyDao;
import com.jjang051.model.ReplyDto;
@WebServlet("/BoardView.do")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardViewController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//하나만 들고오기
		
		int no = Integer.parseInt(request.getParameter("no"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		String clickedPage=request.getParameter("clickedPage");
	    request.setAttribute("clickedPage", clickedPage);
		ReplyDao replyDao = new ReplyDao();
		ReplyDto replyDto = null;
		replyDto = replyDao.getSelectOne(no);
		request.setAttribute("replyDto", replyDto);
		
		// 클릭한 것의 이전 페이지 모든 정보 dto
		ReplyDto prevReplyDto = null;
		prevReplyDto = replyDao.getSelectPrev(num);
		request.setAttribute("prevReplyDto", prevReplyDto);
		
		// 클릭한 것의 이전 페이지 모든 정보 dto
		ReplyDto nextReplyDto = null;
		nextReplyDto = replyDao.getSelectNext(num);
		request.setAttribute("nextReplyDto", nextReplyDto);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/view.jsp");
		dispatcher.forward(request, response);
	}
}

















