package com.koreait.board3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board3.dao.BoardDAO;
import com.koreait.board3.vo.BoardListModel;

@WebServlet("/boardList")
public class BoardListSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardListModel> data = BoardDAO.selectBoardList();
		request.setAttribute("data", data);		
		
		String jsp = "/WEB-INF/jsp/boardList.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

}
