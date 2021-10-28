/**
 * 
 */
package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.tcs.bean.Course;
import com.tcs.bean.Professor;
import com.tcs.bean.Student;
import com.tcs.util.*;
import com.tcs.constant.*;
import com.tcs.exception.CourseNotFoundException;
import com.tcs.exception.ProfessorNotFoundException;
import com.tcs.exception.StudentNotFoundException;

/**
 * @author VENKY_HARI
 *
 */
@Repository
public class ProfessorDAOImpl implements ProfessorDAOInterface{
	Connection con = DBUtils.getConnection();
	SQLQueriesConstants sql = new SQLQueriesConstants();
	
	private static Logger logger=Logger.getLogger(AdminDAOImpl.class);
	
	@Override
	public List studentList() throws SQLException {
		try {
			List<Student> students = new ArrayList<Student>();
			PreparedStatement stmt = con.prepareStatement(sql.VIEW_LIST_STUDENTS);
			logger.debug(stmt);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				students.add(new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			return students;
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Professor getId(int id) throws SQLException, ProfessorNotFoundException {
		try {
			String s = sql.VIEW_SELECTED_PROFESSOR;
			PreparedStatement stmt = con.prepareStatement(s);
			stmt.setInt(1, id);
			logger.debug(stmt);
			ResultSet rs= stmt.executeQuery();
			if (rs.next()) {
				return new Professor(rs.getInt("professorId"),rs.getString("professorName"),rs.getString("professorDept"));
			}
			else {
				throw new ProfessorNotFoundException(id);
			}
		}
		catch(ProfessorNotFoundException e) {
			logger.error(e.getMessage());
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public String assignGrade(int studentId, int courseId, String grade) throws SQLException, StudentNotFoundException, CourseNotFoundException {
		// TODO Auto-generated method stub
		try {
			String s = sql.VIEW_SELECTED_STUDENT;
			PreparedStatement stmt = con.prepareStatement(s);
			stmt.setInt(1, studentId);
			logger.debug(stmt);
			ResultSet rs= stmt.executeQuery();
			if(!rs.next()) {
				throw new StudentNotFoundException(studentId);
			}
			
			String s1 = sql.VIEW_SELECTED_COURSE;
			PreparedStatement stmt1 = con.prepareStatement(s1);
			stmt1.setInt(1, courseId);
			logger.debug(stmt1);
			ResultSet rs1= stmt1.executeQuery();
			if(!rs1.next()) {
				throw new CourseNotFoundException(courseId);
			}
			
			PreparedStatement stmt2=con.prepareStatement("insert into grade values(?,?,?)");  
			stmt2.setInt(1,studentId);
			stmt2.setInt(2,courseId);
			stmt2.setString(3,grade);
			logger.debug(stmt2);
			int i = stmt2.executeUpdate();
			
			return "Grade assigned for student";
		}
		catch(StudentNotFoundException e) {
			return e.getMessage();
		}
		catch(CourseNotFoundException e) {
			return e.getMessage();
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public List courseList() throws SQLException {
		// TODO Auto-generated method stub
		try {
			List<Course> courses = new ArrayList<Course>();
			PreparedStatement stmt = con.prepareStatement(sql.VIEW_COURSE);
			logger.debug(stmt);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				courses.add(new Course(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
			}
			return courses;
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	

}