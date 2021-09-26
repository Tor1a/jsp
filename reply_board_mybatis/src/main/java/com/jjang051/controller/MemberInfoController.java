package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;

@WebServlet("/MemberInfo.do")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberInfoController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no =Integer.parseInt( request.getParameter("no") );
		MemberDao memberDao = new MemberDao();
		MemberDto loggedMember = null;
		loggedMember = memberDao.getSelectOne(no);
		HttpSession session = request.getSession();
		session.setAttribute("loggedMember", loggedMember);
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/member_info.jsp");
		dispatcher.forward(request, response);
	}
}




