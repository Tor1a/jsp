package com.jjang051.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;
import com.jjang051.utils.ScriptWriterUtil;

@WebServlet("/MemberLogin.do")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberLoginController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		MemberDao memberDao = new MemberDao();
		MemberDto loggedMemberInfo = memberDao.getLoggedMember(userId, userPw);
		if(loggedMemberInfo!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedMemberInfo", loggedMemberInfo);
			ScriptWriterUtil.alertAndNext(response, "로그인 되었습니다.", "ReplyList.do");
		} else {
			ScriptWriterUtil.alertAndBack(response, " ID,PW 확인하세요.");
		}
	}
}

















