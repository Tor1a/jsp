package com.jjang051.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberJoinForm.do")
public class MemberJoinFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberJoinFormController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/join.jsp");
		dispatcher.forward(request, response);
		//MEMBER02  seq, memberDto, memberDao, insert
		//코드 주세요...
	}
}





