package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board3.dao.BoardDAO;

@WebServlet("/boardDetail")
public class BoardDetailSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();		
		if(hs.getAttribute("loginUser") == null) {
			response.sendRedirect("/login");
			return;
		}
		
		int i_board = Integer.parseInt(request.getParameter("i_board"));		
		request.setAttribute("data", BoardDAO.selectBoardList(i_board));
		
		String jsp = "/WEB-INF/jsp/boardDetail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}


}
