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
@WebServlet("/MemberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberUpdateController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 요청으로 들어오는 한글 인코딩을 utf-8로 처리하겠다.
		response.setContentType("text/html; charset=utf-8");// 출력용 한글깨짐 방짐...
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String address = request.getParameter("address01") + " " + request.getParameter("address02");
		String phone = request.getParameter("phoneNumber") + request.getParameter("phoneMiddleNumber")
				+ request.getParameter("phoneLastNumber");
		String userEmail = request.getParameter("userEmail");
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		
		PrintWriter out = response.getWriter();
		
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		memberDto.setName(userName);
		memberDto.setZipcode(zipcode);
		memberDto.setAddress(address);
		memberDto.setHp(phone);
		memberDto.setEmail(userEmail);
		int result = memberDao.updateMember(memberDto);
		
		HttpSession session = request.getSession(); 
		
		if(result > 0) {
			session.invalidate();
			out.println("<script>");
			out.println("alert('회원정보 수정이 완료되었습니다. 다시 로그인하세요.')");
			out.println("location.href='MemberList.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('비밀번호를 확인하세요.')");
			out.println("history.back();");
			out.println("</script>");
		}
		
	}
}
