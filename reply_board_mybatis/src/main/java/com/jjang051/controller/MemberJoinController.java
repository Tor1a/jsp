package com.jjang051.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;

@WebServlet("/MemberJoin.do")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberJoinController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; cahrset=UTF-8");
		
		String id = request.getParameter("userId");
		String password = request.getParameter("userPw");
		String name = request.getParameter("userName");
		int zipcode =Integer.parseInt( request.getParameter("zipcode") );
		String address = request.getParameter("address01")+" "+request.getParameter("address02");
		String hp = request.getParameter("phoneNumber")+request.getParameter("phoneMiddleNumber")+request.getParameter("phoneLastNumber");
		String email = request.getParameter("userEmail");
		
		MemberDto memberDto= new MemberDto();
		memberDto.setId(id);
		memberDto.setPassword(password);
		memberDto.setName(name);
		memberDto.setZipcode(zipcode);
		memberDto.setAddress(address);
		memberDto.setHp(hp);
		memberDto.setEmail(email);
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.insertMember(memberDto);
		if(result>0) {
			response.sendRedirect("MemberList.do");
		}
	}
}








