package com.jjang051.controller.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.ReplyDao;
import com.jjang051.model.ReplyDto;

@WebServlet("/ReplyList.do")
public class ReplyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReplyListController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버단에서 페이지를 바꿔서 호출해주는 forward
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ReplyDao replyDao = new ReplyDao();
		request.setAttribute("replyList", replyDao.getAllList());
		//request.setAttribute("name", "장성호"); // 데이터 싣기
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/list.jsp");
		dispatcher.forward(request, response);
	}
}











