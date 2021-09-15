package com.jjang051.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.MarioDao;
import com.jjang051.model.MarioDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/MarioUpload.do")
public class MarioUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MarioUploadController() {
		super();
	}
	
	//
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 자기가 직접 해보는게 제일 중요해요
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 파일 디렉토리...
		String savePath = "upload_mario";
		ServletContext context =  this.getServletContext();// 현재 내가 서비스하는 context;
		String realPath = context.getRealPath(savePath); // context path
		//String realPath ="C:\\upload_mario";
		
		
		File dir = new File(realPath);
		if (!dir.exists()) dir.mkdirs();
		
		int fileSize = 1024*1024*100; // 파일 크기 지정
		String encoding ="UTF-8";
		DefaultFileRenamePolicy filePolicy = new DefaultFileRenamePolicy();
		//MultipartRequest multipartRequest = new MultipartRequest(request,"파일 저장되는 곳 (내 서버 디렉토리)",파일사이즈,인코딩, 중복파일);
		MultipartRequest multipartRequest = new MultipartRequest(request,realPath,fileSize,encoding, filePolicy);
		
		String title = multipartRequest.getParameter("title");
		String background = multipartRequest.getParameter("background");
		String link = multipartRequest.getParameter("link");
		String contents = multipartRequest.getParameter("contents");
		//String file = request.getParameter("file");
		String marioImg = multipartRequest.getOriginalFileName("file");
		String marioRealImg = multipartRequest.getFilesystemName("file");

		MarioDao marioDao = new MarioDao();
		MarioDto marioDto = new MarioDto();

		marioDto.setTitle(title);
		marioDto.setBg(background);
		marioDto.setLink(link);
		marioDto.setContents(contents);
		marioDto.setMarioImg(marioImg);
		marioDto.setMarioRealImg(marioRealImg);
		System.out.println(marioDto.toString());
		int result = marioDao.insertMario(marioDto);
	}
}



