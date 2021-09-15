package com.jjang051.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;

@WebServlet("/MemberDelete.do")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberDeleteController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String userPw =  request.getParameter("userPw");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		MemberDao memberDao = new MemberDao();

		MemberDto loggedMember = (MemberDto) session.getAttribute("loggedMember");
		loggedMember.setPassword(userPw);
		int result = memberDao.deleteMember(loggedMember);
		if (result > 0) {
			session.invalidate();
			out.println("<script>");
			out.println("alert('회원탈퇴 되었습니다.');");
			out.println("location.href='./BoardList.do';");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다..');");
			out.println("history.back();");
			out.println("</script>");
		}

	}
}
