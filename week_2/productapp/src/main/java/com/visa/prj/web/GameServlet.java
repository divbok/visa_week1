package com.visa.prj.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();

		ses.setAttribute("actual", "liverpool");
		ses.setAttribute("answer", "*********");
		ses.setAttribute("lives", 5);
		request.getRequestDispatcher("game.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession(false);
		if (ses != null) {
			String guess = request.getParameter("guess");
			String actualanswer = (String) ses.getAttribute("actual");
			String latestanswer = (String) ses.getAttribute("answer");
			int livesleft = (int) ses.getAttribute("lives");
			boolean flag = false;
			StringBuilder newanswer = new StringBuilder();
			if (livesleft > 1) {
				for (int i = 0; i < actualanswer.length(); i++) {
					if (guess.charAt(0) == actualanswer.charAt(i)) {
						newanswer.append(actualanswer.charAt(i));
						flag = true;
					} else {
						newanswer.append(latestanswer.charAt(i));
					}
				}
				if (flag == false) {
					livesleft--;
				}
				ses.setAttribute("answer", newanswer.toString());
				ses.setAttribute("lives", livesleft);
				request.getRequestDispatcher("game.jsp").forward(request, response);
			} else {
				response.sendRedirect("game.jsp");
			}
		}

	}

}
