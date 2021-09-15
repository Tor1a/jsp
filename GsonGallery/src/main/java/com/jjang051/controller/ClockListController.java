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
import com.jjang051.model.ClockDao;
import com.jjang051.model.ClockDto;

@WebServlet("/ClockList.do")
public class ClockListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ClockListController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ClockDao clockDao = new ClockDao();
		ArrayList<ClockDto> clockList = clockDao.showAllClock();
		
		HashMap<String,ArrayList<ClockDto>> hashMap = new HashMap<String,ArrayList<ClockDto>>();
		hashMap.put("items", clockList);
		
		Gson gson = new Gson();
		//String clockJsonList = gson.toJson(clockList);
		String clockJsonList = gson.toJson(hashMap);
		request.setAttribute("clockJsonList", clockJsonList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("hublot_list.jsp");
		dispatcher.forward(request, response);
		/*
		오전에 fileupalod할때 hashMap을 만들엇 json
		{
			"clockList":[{"aaa":"ffdsf"},{"aaa":"jkjj"},{}]
		}
		*/
	}
}












