package kr.co.user.ex;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.user.model.MemberDAO;
import kr.co.user.model.MemberDTO;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class UserModify
 */
public class UserModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModify() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String roletype = request.getParameter("roletype");
		String statetype = request.getParameter("statetype");
		PrintWriter out = response.getWriter();
		try {
			MemberDAO dt = new MemberDAO();
			MemberDTO idCheck = dt.LoginOk(id);
			if (idCheck == null) {
				out.println("<h2>조회실패</h2>");
			} else {
				int result = dt.UserModifyOk(id, name,email,roletype,statetype);
				if (result > 0) {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("modifyResult.jsp");
					dispatcher.forward(request, response);
					return;

				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("userModify.jsp");
					dispatcher.forward(request, response);
					return;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
