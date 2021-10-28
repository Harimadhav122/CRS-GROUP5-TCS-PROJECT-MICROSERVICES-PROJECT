/**
 * 
 */
package com.tcs.dao;
import java.util.List;

import java.sql.SQLException;
import com.tcs.bean.Professor;
import com.tcs.exception.CourseNotFoundException;
import com.tcs.exception.ProfessorNotFoundException;
import com.tcs.exception.StudentNotFoundException;

/**
 * @author VENKY_HARI
 *
 */
public interface ProfessorDAOInterface {
	/**
	 * List students using SQL commands
	 * @throws SQLException 
	 */
	public List studentList()  throws SQLException;
	/**
	 * Get professor details using SQL commands
	 * @param professor id
	 * @throws ProfessorNotFoundException
	 * @throws SQLException 
	 */
	public Professor getId(int id) throws SQLException, ProfessorNotFoundException; 
	/**
	 * Assign grade for student using SQL commands
	 * @param student id
	 * @param course id
	 * @param grade
	 * @throws StudentNotFoundException
	 * @throws CourseNotFoundException
	 * @throws SQLException 
	 */
	public String assignGrade(int studentId, int courseId, String grade) throws SQLException, StudentNotFoundException, CourseNotFoundException;
	/**
	 * List couses using SQL commands
	 * @throws SQLException 
	 */
	public List courseList() throws SQLException;
}
