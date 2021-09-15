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
		String clickedPage=request.getParameter("clickedPage");
	    request.setAttribute("clickedPage", clickedPage);
		ReplyDao replyDao = new ReplyDao();
		ReplyDto replyDto = null;
		replyDto = replyDao.getSelectOne(no);
		request.setAttribute("replyDto", replyDto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/view.jsp");
		dispatcher.forward(request, response);
	}
}

















