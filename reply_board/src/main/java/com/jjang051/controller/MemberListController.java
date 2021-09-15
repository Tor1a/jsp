package com.jjang051.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;

@WebServlet("/MemberList.do")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberListController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();
		MemberDto memberDto = new MemberDto();
		MemberDao memberDao = new MemberDao();
		memberList = memberDao.showAllMember();
		request.setAttribute("memberList", memberList);
		//view 로 사용할 페이지로 포워딩.....
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/list.jsp");
		dispatcher.forward(request, response);
	}
}




