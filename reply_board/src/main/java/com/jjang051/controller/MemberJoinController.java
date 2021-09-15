package com.jjang051.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		request.setCharacterEncoding("utf-8");  // 요청으로 들어오는 한글 인코딩을 utf-8로 처리하겠다.
		response.setContentType("text/html; charset=utf-8");// 출력용 한글깨짐 방짐...
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw"); 
		String userName = request.getParameter("userName");
		int zipcode =  Integer.parseInt(request.getParameter("zipcode"));
		String address =  request.getParameter("address01")+" "+request.getParameter("address02");
		String phone = request.getParameter("phoneNumber")+request.getParameter("phoneMiddleNumber")+request.getParameter("phoneLastNumber");
		String userEmail = request.getParameter("userEmail");
		
		MemberDto memberDto = new MemberDto();
		MemberDao memberDao = new MemberDao();
		PrintWriter out = response.getWriter();
		
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		memberDto.setName(userName);
		memberDto.setZipcode(zipcode);
		memberDto.setAddress(address);
		memberDto.setHp(phone);
		memberDto.setEmail(userEmail);
		int result = memberDao.insertMember(memberDto);

		if(result > 0) {
			out.println("<script>");
			out.println("alert('회원가입이 완료되었습니다.')");
			out.println("location.href='MemberList.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('회원가입에 실패하였습니다.')");
			out.println("history.back();");
			out.println("</script>");
		}
	}
}



