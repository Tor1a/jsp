package com.jjang051.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.ReplyDao;
import com.jjang051.model.ReplyDto;

@WebServlet("/ReplyView.do")
public class ReplyViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReplyViewController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 요청 받을때 한글 깨짐 방지...
		response.setContentType("text/html; charset=UTF-8");  // 내보낼때 html, 한글처리를 위해 utf-8
		
		int no = Integer.parseInt( request.getParameter("no") );
		//System.out.println("no===="+no);
		
		ReplyDao replyDao = new ReplyDao();
		ReplyDto replyDto = replyDao.getSeletOne(no);
		
		request.setAttribute("replyDto", replyDto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/view.jsp"); //view 로 사용할 jsp
		dispatcher.forward(request, response);
	}
}






