package com.jjang051.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;
import com.jjang051.utils.ScriptWriterUtil;

@WebServlet("/MemberJoin.do")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberJoinController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		int zipcode =  Integer.parseInt( request.getParameter("zipcode") );
		String address = request.getParameter("address01")+" "+request.getParameter("address02");
		String hp = request.getParameter("phoneNumber")+"-"+request.getParameter("phoneMiddleNumber")+"-"+request.getParameter("phoneLastNumber");
		String email = request.getParameter("userEmail");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		memberDto.setName(userName);
		memberDto.setZipCode(zipcode);
		memberDto.setAddress(address);
		memberDto.setHp(hp);
		memberDto.setEmail(email);
		
		System.out.println(memberDto.toString());
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.insertMember(memberDto);
		if(result > 0) {
			ScriptWriterUtil.alertAndNext(response, "회원가입이 완료되었습니다.","ReplyList.do");
		} else {
			ScriptWriterUtil.alertAndBack(response, "회원가입이 되어 있습니다");
		}
	}
}





