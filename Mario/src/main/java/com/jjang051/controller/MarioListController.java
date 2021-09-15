package com.jjang051.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.MarioDao;
import com.jjang051.model.MarioDto;

@WebServlet("/MarioList.do")
public class MarioListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MarioListController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MarioDao marioDao = new MarioDao();
		ArrayList<MarioDto> marioList = marioDao.selectAllMario();
		request.setAttribute("marioList", marioList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		dispatcher.forward(request, response);
	}
}
//Dao에서 메서드 정의  
//Controller에서 dao의 메서드 실행
















