package com.seoil.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.seoil.dao.MovieDAO;
import com.seoil.dto.MovieVO;

@WebServlet("/moviewrite.do")
public class MovieWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieWrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "movie\\movieWirte.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String saveDirectory = request.getServletContext()
				.getRealPath("images");
		int maxPostSize = 5*1024*1024; //5KB
		String encType="EUC-KR";
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest multi= new MultipartRequest(request, saveDirectory,
				maxPostSize,
				encType,
				policy);
		MovieVO mVO = new MovieVO();
		mVO.setTitle(multi.getParameter("mtitle"));
		mVO.setPrice(Integer.parseInt(multi.getParameter("price")));
		mVO.setDirector(multi.getParameter("director"));
		mVO.setActor(multi.getParameter("actor"));
		mVO.setPoster(multi.getFilesystemName("poster"));
		mVO.setSynopsis(multi.getParameter("synopsis"));
		System.out.println(mVO);
		MovieDAO productDAO = MovieDAO.getInstance();
		productDAO.insertMovie(mVO);
		// 상품 리스트로 이동
		response.sendRedirect("movielist.do");
	}

}
