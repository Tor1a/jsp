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
@WebServlet("/ReplyDeleteForm.do")
public class ReplyDeleteFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReplyDeleteFormController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		ReplyDao replyDao = new ReplyDao();
		ReplyDto replyDto = replyDao.getSeletOne(no);
		
		request.setAttribute("replyDto",replyDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/delete.jsp");
		dispatcher.forward(request, response);
	}
}
