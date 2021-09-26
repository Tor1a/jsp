package com.jjang051.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.MemberDao;
@WebServlet("/MemberDelete.do")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberDeleteController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt( request.getParameter("no") );
		String password =  request.getParameter("userPw");
		MemberDao memberDao = new MemberDao();
		String dbPassword = memberDao.getPassword(no);
		if(dbPassword.equals(password)) {
			int result = memberDao.deleteMember(no);
			if(result>0) {
				response.sendRedirect("MemberList.do");
			}
		} else {
			// 경고창 띄우기....
		}
	}
}
