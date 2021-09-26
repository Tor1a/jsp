package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.MemberDao;

@WebServlet("/MemberIdCheck.do")
public class MemberIdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberIdCheckController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		String id = request.getParameter("id");
		int result= memberDao.idCheck(id);
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/id_check.jsp");
		dispatcher.forward(request, response);
	}
}





