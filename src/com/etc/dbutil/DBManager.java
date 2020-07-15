package com.etc.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	private Connection conn;
	private PreparedStatement pstmt;
	
	private static DBManager instance = new DBManager();
	
	private DBManager(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DBManager getInstance(){
		return instance;
	}
	
	
	private void openConnection(){
		
		try {
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/boke", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

	
	public int execUpdate(String sql, Object... params){
		
		try {
			
			this.openConnection();
			
			this.pstmt = this.conn.prepareStatement(sql);
			
			
			for(int i=0; i< params.length; i++){
				this.pstmt.setObject(i+1, params[i]);
			}
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			return -1;
			
		} finally{
			
			
			this.closeConnection();
		}
		
	}
	
	
	public ResultSet execQuery(String sql, Object... params){
		
		try {
			this.openConnection();
			this.pstmt = this.conn.prepareStatement(sql);
			
			
			for(int i=0; i< params.length; i++){
				this.pstmt.setObject(i+1, params[i]);
			}
			
			return pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void closeConnection(){
		
		try {
			this.pstmt.close();
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
