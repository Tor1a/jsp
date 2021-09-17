package com.jjang051.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jjang051.model.ReplyDao;
import com.jjang051.utils.ScriptWriterUtil;

@WebServlet("/BoardDelete.do")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardDeleteController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt( request.getParameter("no") );
		String password = request.getParameter("password");
		System.out.println("no==="+no+",password===="+password);
		ReplyDao replyDao = new ReplyDao();
		int result = replyDao.deleteBoard(no,password);
		if(result > 0) {
			ScriptWriterUtil.alertAndNext(response, "삭제되었습니다.", "ReplyList.do");
		} else {
			ScriptWriterUtil.alertAndBack(response, "비밀번호를 확인해 주세요");
		}
	}
}
