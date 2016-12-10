package com.example.spring01;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

//@ContextConfiguration(location={file:src/main/webapp/WEB-INF/spring/**/*.xml})
public class MyBatisTest {
	//의존관계 주입
	@Inject
	private SqlSessionFactory sqlFactory;
	@Test
	public void testFactory(){
		System.out.println(sqlFactory);
	}
	@Test
	public void testSession() throws Exception{
		try(SqlSession session=sqlFactory.openSession()) {
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
