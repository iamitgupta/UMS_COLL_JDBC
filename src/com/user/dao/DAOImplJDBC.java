package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.user.beans.User;

public class DAOImplJDBC implements DAO{
	public DAOImplJDBC(){
		try {
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//db query
	String url="jdbc:mysql://127.0.0.1:3306/USER_DB?user=root&password=root";
	
	@Override
	public boolean addUser(User user) {
		//Insert into db if user doesn't exist
		String query="INSERT INTO userinfo VALUES (?,?,?,?)";
		String passQuery="SELECT * FROM userinfo WHERE userid="+user.getId();
		
		try(Connection conn=DriverManager.getConnection(url);
			PreparedStatement pstmt=conn.prepareStatement(query);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(passQuery);
			){
			if(rs.next()){
				return false;
			}else{
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.executeUpdate();
			return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUser(int id) {
		//return user detail
		String query="SELECT  * FROM userinfo where userid="+id;

		try(Connection conn=DriverManager.getConnection(url);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(query)){

			User user= new User();
			if(rs.next()){
				user.setId(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setEmail((rs.getString("email")));

				return user;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		//update user if already exists in db
		String query="UPDATE userinfo SET username=?,email=?,password=? WHERE userid="+user.getId();
		String passQuery="SELECT * FROM userinfo WHERE userid="+user.getId();
		try(Connection conn=DriverManager.getConnection(url);
				PreparedStatement pstmt=conn.prepareStatement(query);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(passQuery);
				){
			if(rs.next()) {
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPassword());

				pstmt.executeUpdate();
				
				return true;
			}
			else {
				return false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		//delete user if already exists 
		String query="DELETE FROM userinfo WHERE userid="+id;
		String passQuery="SELECT * FROM userinfo WHERE userid="+id;
		try(Connection conn=DriverManager.getConnection(url);
				PreparedStatement pstmt=conn.prepareStatement(query);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(passQuery);
				){
			if(rs.next()) {
				pstmt.executeUpdate();
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
