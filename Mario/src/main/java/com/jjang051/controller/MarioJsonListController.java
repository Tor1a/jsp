package com.jjang051.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jjang051.model.MarioDao;
import com.jjang051.model.MarioDto;

@WebServlet("/MarioJsonList.do")
public class MarioJsonListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MarioJsonListController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MarioDao marioDao = new MarioDao();
		ArrayList<MarioDto> marioList = marioDao.selectAllMario();
		
		HashMap<String,ArrayList<MarioDto>> hashMap = new HashMap<String,ArrayList<MarioDto>>();
		hashMap.put("marioList", marioList);
		
		Gson gson = new Gson();
		String marioJsonList = gson.toJson(hashMap);
		
		request.setAttribute("marioJsonList", marioJsonList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mario_json_list.jsp");
		dispatcher.forward(request, response);
	}
}









