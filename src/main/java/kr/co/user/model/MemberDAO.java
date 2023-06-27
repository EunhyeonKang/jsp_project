package kr.co.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource ds;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public int JoinOk(MemberDTO member) {
		int result = 0;
		try {
			// conn = JDBCConnection.getConnection();
			conn = ds.getConnection();
			// SQL 쿼리 작성
			String sql = "INSERT INTO users (id, pw, name, phone, email,statetype,roletype) VALUES (?, ?, ?, ?,?,?,?)";

			// PreparedStatement를 생성하여 SQL 쿼리 실행 준비
			pstmt = conn.prepareStatement(sql);

			// PreparedStatement의 파라미터 설정
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getStatetype());
			pstmt.setString(7, member.getRoletype());
			// SQL 쿼리 실행
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public MemberDTO LoginOk(String ids) {
		MemberDTO md = new MemberDTO();
		try {
			// conn = JDBCConnection.getConnection();
			conn = ds.getConnection();
			String sql = "SELECT * FROM users where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ids);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				md.setId(rs.getString("ID"));
				md.setPw(rs.getString("PW"));
				md.setName(rs.getString("NAME"));
				md.setEmail(rs.getString("EMAIL"));
				md.setPhone(rs.getString("PHONE"));
				md.setStatetype(rs.getString("statetype"));
				md.setRoletype(rs.getString("roletype"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return md;
	}

	public ArrayList<MemberDTO> selectMember() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			// conn = JDBCConnection.getConnection();
			conn = ds.getConnection();
			String sql = "SELECT * FROM users";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDTO md = new MemberDTO();
				md.setId(rs.getString("ID"));
				md.setPw(rs.getString("PW"));
				md.setName(rs.getString("NAME"));
				md.setPhone(rs.getString("phone"));
				md.setRoletype(rs.getString("roletype"));
				md.setStatetype(rs.getString("statetype"));
				list.add(md);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return list;
	}

	public int ModifyOk(String id, String pw, String name,String phone, String email) {
		// SQL 쿼리 작성
		String sql = "UPDATE users SET pw=?, name=?,phone=?, email=? WHERE id=?";
		int result = 0;
		// PreparedStatement 생성
		try {
			// conn = JDBCConnection.getConnection();
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			// PreparedStatement 파라미터 설정
			pstmt.setString(1, pw); // pw 변수로 설정
			pstmt.setString(2, name); // phone 변수로 설정
			pstmt.setString(3, phone);
			pstmt.setString(4, email);
			pstmt.setString(5, id);
			// SQL 쿼리 실행
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return result;
	}

	public int UserModifyOk(String id, String name, String email, String roletype, String statetype) {
		// SQL 쿼리 작성
		String sql = "UPDATE users SET name=?, email=?,roletype=?,statetype=? WHERE id=?";
		int result = 0;
		// PreparedStatement 생성
		try {
			// conn = JDBCConnection.getConnection();
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			// PreparedStatement 파라미터 설정
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, roletype);
			pstmt.setString(4, statetype);
			pstmt.setString(5, id);

			// SQL 쿼리 실행
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return result;
	}

	public int pauseUser(String id) {
		// SQL 쿼리 작성
		String sql = "UPDATE users SET statetype=? WHERE id=?";
		int result = 0;
		// PreparedStatement 생성
		try {
			// conn = JDBCConnection.getConnection();
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			// PreparedStatement 파라미터 설정
			pstmt.setString(1, "일시정지");
			pstmt.setString(2, id);
			// SQL 쿼리 실행
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return result;
	}

	public int deleteUser(String id) {
		String sql = "DELETE FROM users WHERE id=?";
		int result = 0;
		// PreparedStatement 생성
		try {
			// conn = JDBCConnection.getConnection();
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			// PreparedStatement 파라미터 설정
			pstmt.setString(1, id);
			// SQL 쿼리 실행
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return result;
	}

}
