package kr.co.user.ex;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.user.model.MemberDAO;
import kr.co.user.model.MemberDTO;

/**
 * Servlet implementation class deleteUser
 */
public class PauseUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PauseUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/// TODO Auto-generated method stub
		// doGet(request, response);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession(true);
		String id = (String)session.getAttribute("id");

		PrintWriter out = response.getWriter();
		try {
			MemberDAO dt = new MemberDAO();
			MemberDTO idCheck = dt.LoginOk(id);
			if (idCheck == null) {
				out.println("<h2>조회실패</h2>");
			} else {
				int result = dt.pauseUser(id);
				if (result > 0) {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("deleteResult.jsp");
					dispatcher.forward(request, response);
					return;

				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("modify.jsp");
					dispatcher.forward(request, response);
					return;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
