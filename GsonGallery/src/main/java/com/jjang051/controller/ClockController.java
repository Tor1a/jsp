package com.jjang051.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.ClockDao;
import com.jjang051.model.ClockDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/Clock.do")
public class ClockController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ClockController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//업로드 파일 받아서 처리하기....
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String savePath = "upload";
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath);
		
		int fileSize = 1024*1024*10;
		String encoding = "UTF-8";
		DefaultFileRenamePolicy filePolicy = new DefaultFileRenamePolicy();
		MultipartRequest multipartRequest = new MultipartRequest(request, realPath,fileSize,encoding,filePolicy);
		
		ClockDto clockDto = new ClockDto();
		
		clockDto.setCategory( multipartRequest.getParameter("category") );
		clockDto.setTitle( multipartRequest.getParameter("title") );
		clockDto.setDepth(Integer.parseInt( multipartRequest.getParameter("depth") ));
		clockDto.setPrice(Integer.parseInt( multipartRequest.getParameter("price") ));
		clockDto.setLink( multipartRequest.getParameter("link") );
		clockDto.setClockImg( multipartRequest.getOriginalFileName("hublotFile") );
		clockDto.setRealClockImg( multipartRequest.getFilesystemName("hublotFile") );
		
		ClockDao clockDao = new ClockDao();
		int result = clockDao.insertClock(clockDto);
		if(result>0) {
			response.sendRedirect("Main.do");
		}
	}
}

























