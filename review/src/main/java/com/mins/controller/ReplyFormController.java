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
		//request.getParameter("");	// query string���� �Ѿ�� �����ʹ� String�̴�
		
		//request.getAttribute("userName");	// setAttribute()�� ������ ��� ���������� object
		//request.setAttribute("userName", "aaa");
		//String aaa = "k";
		//pageContext, request(�Ѱ����� ������ ����),  session  (������ ����), application(���� ����)
		RequestDispatcher  dispatcher = request.getRequestDispatcher("board/wirte.do");
		dispatcher.forward(request, response);
	}

}
