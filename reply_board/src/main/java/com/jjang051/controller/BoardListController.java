package com.jjang051.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.ReplyDao;
import com.jjang051.model.ReplyDto;
@WebServlet("/BoardList.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardListController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ReplyDao replyDao = new ReplyDao();
		ArrayList<ReplyDto> replyList = null;
		replyList = replyDao.getAllList();
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/list.jsp");
		request.setAttribute("replyList", replyList);
		dispatcher.forward(request, response);
	}
}





















