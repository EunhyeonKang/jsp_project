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
 * Servlet implementation class loginOk
 */
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginOk() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		PrintWriter out = response.getWriter();
		try {
			MemberDAO mt = new MemberDAO();
			MemberDTO md = mt.LoginOk(id);
			if (md == null) {
				out.println("<h2>조회실패</h2>");
			} else {
				if (id.equals(md.getId()) && pw.equals(md.getPw())) {
					// role이 admin이면 관리자 화면으로 이동
					HttpSession session = request.getSession(true);
					session.setAttribute("id", md.getId());
					session.setAttribute("name", md.getName());
					session.setAttribute("pw", md.getPw());
					if(md.getStatetype().equals("정상")) {
						// role이 user이면서 승인이면 로긴완료 
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("loginResult.jsp");
						dispatcher.forward(request, response);
					}else if(md.getRoletype().equals("user")&& md.getStatetype().equals("일시정지")|| md.getStatetype().equals("승인대기")) {
						// role이 user이면서 일시정지거나 승인대기면 로긴실패 
						RequestDispatcher dispatcher = request.getRequestDispatcher("loading.jsp?state="+md.getStatetype());
						dispatcher.forward(request, response);
					}
					
					return;
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
					return;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendRedirect("join.html");
		}
	}

}
