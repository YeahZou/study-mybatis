package com.yeah.mybatis.service;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yeah.mybatis.dto.UserVo;
import com.yeah.mybatis.mapper.UserMapper;

public class Main {
	public static void main(String[] argv) {
		String resource = "mybatis.xml";
		SqlSession session = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			session = sqlSessionFactory.openSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			UserVo userVo = mapper.getUserById(1L);
			System.out.println("userVo: " + userVo.toString());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
