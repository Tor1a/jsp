package com.mins.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mins.model.ReplyDto;
import com.mins.model.ReplyDao;

@WebServlet("/ReplyList.do")
public class ReplyListController extends HttpServlet {
	private static final long serialVersoinUID  = 1L;
	
    public ReplyListController() {
        super();
     
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 서버단에서 페이지를 바꿔서 호출해주는 forward
		
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		
			ArrayList<ReplyDto> replyList = null;
			
			ReplyDao replyDao = new ReplyDao();
			replyList = replyDao.getAllList();
			request.setAttribute("replyList", replyList);
			
			RequestDispatcher  disdpathcer = request.getRequestDispatcher("board/list.jsp");
			request.setAttribute("name","k");
			disdpathcer.forward(request,response);
	}

}
