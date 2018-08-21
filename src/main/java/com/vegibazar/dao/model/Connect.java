package com.vegibazar.dao.model;

import java.sql.*;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Service
public class Connect {
	
	private static final String url="jdbc:mysql://localhost:3306/play";
	private static final String usr="root";
	private static final String pwd="root";
	
	private static  Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, usr, pwd);
			
		}catch(Exception exception){
			exception.printStackTrace();
			return null;
		}
		
	}
	
	public Statement getStatement(){
		try{
		
		return (Statement) getConnection().createStatement();
		
		}catch(Exception exception){
			
			exception.printStackTrace();
			return null;
		}
	}
	
	public PreparedStatement getPreparedStatement(String sql){
		
		try {
			return (PreparedStatement) getConnection().prepareStatement(sql);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	} 

}
