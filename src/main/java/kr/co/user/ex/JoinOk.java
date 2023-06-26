package kr.co.user.ex;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.user.model.MemberDAO;
import kr.co.user.model.MemberDTO;


/**
 * Servlet implementation class JoinOk
 */

public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOk() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String roletype = request.getParameter("roletype");
        String state = null;
        
        if(roletype.equals("user")) {
        	state = "승인대기";
        }else {
        	state = "정상";
        }
        MemberDTO member = new MemberDTO(id,pw,name,phone,email,state,roletype);
        MemberDAO mt = new MemberDAO();
		try {
			int result = mt.JoinOk(member);
			if (result > 0) {
	            // 삽입 성공 시
	            response.sendRedirect("login.jsp?result="+result);
	        } else {
	            // 삽입 실패 시
	            response.sendRedirect("join.html");
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("join.html");
		} 
	}

}
