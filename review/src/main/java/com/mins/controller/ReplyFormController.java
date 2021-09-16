package com.mins.controller;

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
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getParameter("");	// query string으로 넘어온 데이터는 String이다
		
		//request.getAttribute("userName");	// setAttribute()를 받을때 사용 중의할점은 object
		//request.setAttribute("userName", "aaa");
		//String aaa = "k";
		//pageContext, request(넘겨지는 페이지 단위),  session  (브라우져 단위), application(서번 단위)
		RequestDispatcher  dispatcher = request.getRequestDispatcher("board/wirte.do");
		dispatcher.forward(request, response);
	}

}
