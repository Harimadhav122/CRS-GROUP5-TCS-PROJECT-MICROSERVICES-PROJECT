/**
 * 
 */
package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.tcs.bean.GradeCard;
import com.tcs.bean.Student;
import com.tcs.util.*;
import com.tcs.constant.*;
import com.tcs.exception.CourseNotFoundException;
import com.tcs.exception.GradeCardNotFoundException;
import com.tcs.exception.StudentNotFoundException;
import com.tcs.constant.Roles;

@Repository
public class StudentDAOImpl implements StudentDAOInterface{
	Connection con = DBUtils.getConnection();
	SQLQueriesConstants sql = new SQLQueriesConstants();
	private static Logger logger=Logger.getLogger(StudentDAOImpl.class);


	@Override
	public Student update(int id, Student student) throws SQLException {
		try {
			PreparedStatement stmt=con.prepareStatement("update students set studentName=?, studentDept=? where studentId=?");  
			stmt.setString(1,student.getStudentName());//1 specifies the first parameter in the query i.e. name  
			stmt.setString(2,student.getStudentDept());
			stmt.setInt(3, id );
			logger.debug(stmt);
			int i = stmt.executeUpdate();
			
			return student;
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Student insert(Student student) throws SQLException {
		try {
			PreparedStatement stmt=con.prepareStatement("insert into students(studentId,studentName,studentDept) values(?,?,?)");
			stmt.setInt(1,student.getStudentId());
			stmt.setString(2,student.getStudentName());
			stmt.setString(3,student.getStudentDept());
			logger.debug(stmt);
			int i = stmt.executeUpdate();
			
			PreparedStatement stmt1=con.prepareStatement("insert into users values(?,?,?)");
			stmt1.setInt(1,student.getStudentId());
			stmt1.setString(2,student.getPassword());
			stmt1.setString(3,Roles.student.toString());
			logger.debug(stmt1);
			int j = stmt1.executeUpdate();
			return student;
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Student getId(int id) throws SQLException, StudentNotFoundException {
		try {
			String s = sql.VIEW_SELECTED_STUDENT;
			PreparedStatement stmt = con.prepareStatement(s);
			stmt.setInt(1, id);
			logger.debug(stmt);

			ResultSet rs= stmt.executeQuery();
			logger.debug(rs);
			if (rs.next()) {
				return new Student(rs.getInt("studentId"),rs.getString("studentName"),rs.getString("studentDept"),rs.getString("status"));
			}
			else {
				throw new StudentNotFoundException(id);
			}
		}
		catch(StudentNotFoundException e) {
			logger.error(e.getMessage());
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		
		return null;
	}

	@Override
	public String registerCourse(int studentId, int courseId) throws SQLException, CourseNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt=con.prepareStatement("select * from courses where courseId=?");
			stmt.setInt(1,courseId);
			ResultSet rs=stmt.executeQuery();
			if(!rs.next()) {
				throw new CourseNotFoundException(courseId);
			}
			PreparedStatement stmt1=con.prepareStatement("insert into registeredcourses values(?,?)");
			stmt1.setInt(1,studentId);
			stmt1.setInt(2,courseId);
			logger.debug(stmt1);
			int j = stmt1.executeUpdate();
			return "Course registration is succesful";
		}
		catch(CourseNotFoundException e) {
			logger.error(e.getMessage());
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
		
	}

	@Override
	public List viewGradeCard(int studentId, int courseId) throws SQLException, GradeCardNotFoundException {
		// TODO Auto-generated method stub
		try {
			List<GradeCard> gradecards = new ArrayList<GradeCard>();
			PreparedStatement stmt1=con.prepareStatement("select * from gradecard where studentId=? AND courseId=?");
			stmt1.setInt(1,studentId);
			stmt1.setInt(2,courseId);
			ResultSet rs = stmt1.executeQuery();
			if(rs.next()) {
				gradecards.add(new GradeCard(rs.getInt(1),rs.getInt(2),rs.getString(3)));
				return gradecards;
			}
			else {
				throw new GradeCardNotFoundException(studentId, courseId);
			}
		}
		catch(GradeCardNotFoundException e) {
			logger.error(e.getMessage());
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
		
	}
	

}
