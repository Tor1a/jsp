package com.jjang051.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReplyForm.do")
public class ReplyFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReplyFormController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getParameter("");  //   query string으로 넘어온 데이터는 String 형변환
		//request.getAttribute("userName");  // setAttribute("임의로 만든 이름",값)를 받을때 사용 주의할점은 Object
		//request.setAttribute("userName", "aaa");
		//String aaa = "장성호"; 
		//pageContext, request (넘겨지는 페이지 단위), session(브라우져 단위), application(서번단위)
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/write.jsp");
		dispatcher.forward(request, response);
	}
}









