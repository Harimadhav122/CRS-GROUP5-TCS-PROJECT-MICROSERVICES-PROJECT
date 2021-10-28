/**
 * 
 */
package com.tcs.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.tcs.constant.Roles;
import com.tcs.constant.SQLQueriesConstants;
import com.tcs.exception.UserNotFoundException;
import com.tcs.util.DBUtils;

/**
 * @author VENKY_HARI
 *
 */
@Repository
public class UserDAOImpl implements UserDAOInterface {
	Connection con = DBUtils.getConnection();
	SQLQueriesConstants sql = new SQLQueriesConstants();
	private static Logger logger=Logger.getLogger(UserDAOImpl.class);

	@Override
	public String studentLogin(int userId, String password) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		int user=0;
		String pass=null;
		String role=null;
		String status=null;
		String res=null;
		try {
			PreparedStatement stmt = con.prepareStatement("select * from users where userId=?");
			stmt.setInt(1,userId);
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) {
				user = rs.getInt(1);
				pass = rs.getString(2);
				role = rs.getString(3);
			}
			
			
			PreparedStatement stmt1 = con.prepareStatement("select * from students where studentId=?");
			stmt1.setInt(1,userId);
			ResultSet rs1= stmt1.executeQuery();
			if(rs1.next()) {
				status = rs1.getString(4);
			}
			
			if(!status.equals("approved")) {
				return "Student is not approved";
			}
			
			res=Roles.student.toString();
			
			
			if(user == userId && res.equals(role) && password.equals(pass) && status.equals("approved")){
				return "Login is successful";
			}
			else {
				throw new UserNotFoundException(userId);
			}
		}
		catch(UserNotFoundException e) {
			return e.getMessage();
		}
	}

	@Override
	public String professorLogin(int userId, String password) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = con.prepareStatement("select * from users where userId=?");
			stmt.setInt(1,userId);
			ResultSet rs= stmt.executeQuery();
			String res=Roles.professor.toString();
			if (rs.next()) {
				if(password.equals(rs.getString("password")) && res.equals(rs.getString("role"))){
					return "Login is successful";
				}
				else {
					throw new UserNotFoundException(userId);
				}
			}
		}
		catch(UserNotFoundException e) {
			return e.getMessage();
		}
		return null;
	}
	
	@Override
	public String AdminLogin(int userId, String password) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = con.prepareStatement("select * from users where userId=?");
			stmt.setInt(1,userId);
			ResultSet rs= stmt.executeQuery();
			String res=Roles.admin.toString();
			if (rs.next()) {
				if(password.equals(rs.getString("password")) && res.equals(rs.getString("role"))){
					return "Login is successful";
				}
				else {
					throw new UserNotFoundException(userId);
				}
			}
		}
		catch(UserNotFoundException e) {
			return e.getMessage();
		}
	return null;
	}
}
