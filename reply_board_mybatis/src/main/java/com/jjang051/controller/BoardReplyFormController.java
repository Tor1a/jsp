package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.ReplyDto;

@WebServlet("/BoardReplyForm.do")
public class BoardReplyFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardReplyFormController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//no,reGroup,reStep,reLevel
		int no =  Integer.parseInt( request.getParameter("no") );
		int reGroup =  Integer.parseInt( request.getParameter("reGroup") );
		int reStep =  Integer.parseInt( request.getParameter("reStep") );
		int reLevel =  Integer.parseInt( request.getParameter("reLevel") );
		
		System.out.println(no+"==="+reGroup+"==="+reStep+"==="+reLevel);
		
		request.setAttribute("no", no);
		request.setAttribute("reGroup", reGroup);
		request.setAttribute("reStep", reStep);
		request.setAttribute("reLevel", reLevel);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/reply_write.jsp");
		dispatcher.forward(request, response);
	}
}
