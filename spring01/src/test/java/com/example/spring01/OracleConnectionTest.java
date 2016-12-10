package com.example.spring01;

import java.sql.Connection;
import java.sql.DriverManager;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class OracleConnectionTest {
	//logger를 수집할 대상 클래스
	private static final Logger logger= LoggerFactory.getLogger(OracleConnectionTest.class);
	//jdbc 오라클 드라이버
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	//오라클 연결 문자열
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	//사용자 아이디
	private static final String USER="spring";
	//비밀번호
	private static final String pw="1234";
	//테스트 JUnit
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try(Connection con= DriverManager.getConnection(URL, USER, pw)){
			System.out.println(con);
			System.out.println("연결되었습니다.");
			logger.info("연결되었습니다.");
		}catch(Exception e){
			e.printStackTrace();
		}
				
	}
}
