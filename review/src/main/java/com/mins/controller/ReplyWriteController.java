package com.mins.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mins.model.ReplyDto;

@WebServlet("/ReplyWrite.do")
public class ReplyWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReplyWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  msg = request.getParameter("subject");
		String  userName = request.getParameter("userName");

		
	}

}
