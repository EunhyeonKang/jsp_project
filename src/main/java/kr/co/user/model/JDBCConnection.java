package kr.co.user.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
        	// 오라클의 JDBC 드라이버 이름
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            // jdbc:oracle:thin:@{호스트 이름}?TNS_ADMIN={Wallet파일 위치경로}
            String url = "jdbc:oracle:thin:@dinkdb_medium?"
            		+ "TNS_ADMIN=/Users/test/Wallet_DinkDB"; 
            String user = "DA2311";
            String passwd = "Data2311";
            // DriverManager를 이용해서 Connection 생성한다.
            conn = DriverManager.getConnection(url, user, passwd);     
            return conn;
        } catch (ClassNotFoundException e) {
            // 드라이버 로드 중 예외가 발생한 경우 처리합니다.
            e.printStackTrace();
        } catch (SQLException e) {
            // 데이터베이스 연결 및 쿼리 실행 중 예외가 발생한 경우 처리합니다.
            e.printStackTrace();
        }
        return conn;
    }
}
