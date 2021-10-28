/**
 * 
 */
package com.tcs.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


import com.tcs.bean.Admin;
import com.tcs.bean.Course;
import com.tcs.bean.GradeCard;
import com.tcs.bean.Professor;
import com.tcs.util.*;
import com.tcs.constant.*;
import com.tcs.exception.AdminNotFoundException;
import com.tcs.exception.CourseNotFoundException;
import com.tcs.exception.StudentNotFoundException;

/**
 * @author VENKY_HARI
 * class for admin DAO operations
 */


//Repository is data access object
@Repository
public class AdminDAOImpl implements AdminDAOInterface {
	//Database connection
	Connection con = DBUtils.getConnection();
	
	//get sql queries
	SQLQueriesConstants sql = new SQLQueriesConstants();
	
	private static Logger logger=Logger.getLogger(AdminDAOImpl.class);
	
	@Override
	public String deleteStudent(int id) throws SQLException, StudentNotFoundException {
		try {
			String s = sql.DELETE_SELECTED_ID_STUDENT;
			PreparedStatement stmt = con.prepareStatement(s);
			logger.debug(stmt);
			stmt = con.prepareStatement(s);
			
			stmt.setInt(1, id);
			int rs= stmt.executeUpdate();
			
			String s1 = sql.DELETE_SELECTED_USER;
			PreparedStatement stmt1 = con.prepareStatement(s1);
			logger.debug(stmt1);
			stmt = con.prepareStatement(s1);
			
			stmt.setInt(1, id);
			int rs1= stmt.executeUpdate();
			
			if (rs==0) {
				throw new StudentNotFoundException(id);
			}
			else {
				return "Student deleted";
			}
		}
		catch(StudentNotFoundException e) {
			return e.getMessage();
		}
	}
	@Override
	public String approveStudReg(int id) throws SQLException, StudentNotFoundException {
		// TODO Auto-generated method stub
		try {
			String s = "update students set status=? where studentId=?";
			PreparedStatement stmt = con.prepareStatement(s);
			logger.debug(stmt);
			stmt.setString(1,"approved");
			stmt.setInt(2,id);
			int i = stmt.executeUpdate();
			if(i==1) {
				return "Student approved";
			}
			else {
				throw new StudentNotFoundException(id);
			}
		}
		catch(StudentNotFoundException e) {
			return e.getMessage();
		}
	}

	
	@Override
	public Admin update(int id, Admin admin) throws SQLException, AdminNotFoundException {
		try {
			PreparedStatement stmt=con.prepareStatement("update admins set adminName=? where adminId=?");  
			stmt.setString(1,admin.getAdminName());//1 specifies the first parameter in the query i.e. name  
			stmt.setInt(2, id );
			logger.debug(stmt);
			int i = stmt.executeUpdate();
			if(i==1) {
				return admin;
			}
			throw new AdminNotFoundException(id);
		}
		catch(AdminNotFoundException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Admin insert(Admin admin) throws SQLException {
		try {
			PreparedStatement stmt=con.prepareStatement("insert into admins values(?,?)");
			stmt.setInt(1,admin.getAdminId());
			stmt.setString(2,admin.getAdminName());
			logger.debug(stmt);
			int i = stmt.executeUpdate();
			
			PreparedStatement stmt1=con.prepareStatement("insert into users values(?,?,?)");
			stmt1.setInt(1,admin.getAdminId());
			stmt1.setString(2,admin.getPassword());
			stmt1.setString(3,Roles.admin.toString());
			logger.debug(stmt1);
			int j = stmt1.executeUpdate();
			
			return admin;
			
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Admin getId(int id) throws SQLException, AdminNotFoundException {
		try {
			String s = sql.VIEW_SELECTED_ID_ADMIN;
			PreparedStatement stmt = con.prepareStatement(s);
			stmt.setInt(1,id);
			logger.debug(stmt);
			ResultSet rs= stmt.executeQuery();
			logger.debug(rs);
			if (rs.next()) {
				return new Admin(rs.getInt("adminId"),rs.getString("adminName"));
			}
			else {
				throw new AdminNotFoundException(id);
			}
		}
		catch(AdminNotFoundException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Professor addNewProf(Professor professor) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt1=con.prepareStatement("insert into professors values(?,?,?)");
			stmt1.setInt(1,professor.getProfessorId());
			stmt1.setString(2,professor.getProfessorName());
			stmt1.setString(3,professor.getProfessorDept());
			
			logger.debug(stmt1);
			int i = stmt1.executeUpdate();
			
			PreparedStatement stmt=con.prepareStatement("insert into users values(?,?,?)");
			stmt.setInt(1,professor.getProfessorId());
			stmt.setString(2,professor.getPassword());
			stmt.setString(3,Roles.professor.toString());
			logger.debug(stmt);
			
			int j = stmt.executeUpdate();
			return professor;
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public String removeProf(int id) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt1=con.prepareStatement("delete from professors where professorId=?");
			stmt1.setInt(1,id);
			
			logger.debug(stmt1);
			int i = stmt1.executeUpdate();
			if(i==0) {
				throw new AdminNotFoundException(id);
			}
			
			PreparedStatement stmt=con.prepareStatement("delete from users where userId=?");
			stmt.setInt(1,id);
			
			int j = stmt.executeUpdate();
			return "Professor is deleted";
		}
		catch(AdminNotFoundException e) {
			return e.getMessage();
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public String generateGradeCard(int studentId, int courseId) throws SQLException {
		// TODO Auto-generated method stub
		try {
			String grade = null;
			PreparedStatement stmt1=con.prepareStatement("select * from grade where studentId=? AND courseId=?");
			stmt1.setInt(1,studentId);
			stmt1.setInt(2,courseId);
			ResultSet rs= stmt1.executeQuery();
			logger.debug(rs);
			if(rs.next()) {
				grade=rs.getString("grade");
			}
			PreparedStatement stmt=con.prepareStatement("insert into gradecard values(?,?,?)");
			stmt.setInt(1,studentId);
			stmt.setInt(2,courseId);
			stmt.setString(3,grade);
			
			int i = stmt.executeUpdate();
			return "Generated grade card succesfully";
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Course addCourses(Course course) throws SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt=con.prepareStatement("insert into courses values(?,?,?,?)");
			stmt.setInt(1,course.getCourseId());
			stmt.setString(2,course.getCourseDesc());
			stmt.setInt(3,course.getAmount());
			stmt.setString(4,course.getCatalogName());
			logger.debug(stmt);
			
			int i = stmt.executeUpdate();
			return course;
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public String deleteCourse(int id) throws CourseNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			String s = sql.DELETE_SELECTED_COURSE;
			PreparedStatement stmt = con.prepareStatement(s);
			stmt.setInt(1, id);
			logger.debug(stmt);
			int k= stmt.executeUpdate();
			if(k==0){
				throw new CourseNotFoundException(id);
			}
			return "course deleted successfully";
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		catch(CourseNotFoundException e) {
			return e.getMessage();
		}
		return null;
	}


}
