/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;
import java.util.List;

import com.tcs.bean.Admin;
import com.tcs.bean.Course;
import com.tcs.bean.GradeCard;
import com.tcs.bean.Professor;
import com.tcs.exception.AdminNotFoundException;
import com.tcs.exception.CourseNotFoundException;
import com.tcs.exception.StudentNotFoundException;

/**
 * @author VENKY_HARI
 *
 */
public interface AdminServiceInterface {
	
	/**
	 * Get admin details using SQL commands
	 * @param admin id
	 * @throws AdminNotFoundException
	 * @throws SQLException
	 */
	public Admin getId(int id) throws SQLException, AdminNotFoundException;
	/**
	 * Delete student using SQL commands
	 * @param student id
	 * @throws StudentNotFoundException
	 * @throws SQLException
	 */
	public String deleteStudent(int id) throws SQLException, StudentNotFoundException;
	/**
	 * admin registration using SQL commands
	 * @param Admin class object
	 * @throws SQLException
	 */
	public Admin insert(Admin admin) throws SQLException;
	/**
	 * Update admin details using SQL commands
	 * @param admin id
	 * @param Admin class object
	 * @throws AdminNotFoundException
	 * @throws SQLException
	 */
	public Admin update(int id, Admin admin)throws SQLException, AdminNotFoundException;
	/**
	 * Approve student registration using SQL commands
	 * @param student id
	 * @throws StudentNotFoundException
	 * @throws SQLException
	 */
	public String approveStudReg(int id) throws SQLException, StudentNotFoundException;
	/**
	 * Generate graade card using SQL commands
	 * @param student id
	 * @param course id
	 * @throws SQLException
	 */
	public String generateGradeCard(int studentId, int courseId) throws SQLException;
	/**
	 * Add new course using SQL commands
	 * @param Course class object
	 * @throws SQLException
	 */
	public Course addCourses(Course course) throws SQLException;
	/**
	 * Delete course using SQL commands
	 * @param course id
	 * @throws SQLException
	 * @throws CourseNotFoundException
	 */
	public String deleteCourse(int id) throws CourseNotFoundException, SQLException;
	/**
	 * Add new professor using SQL commands
	 * @param Professor class object
	 * @throws SQLException
	 */
	public Professor addNewProf(Professor professor) throws SQLException;
	/**
	 * Remove professor using SQL commands
	 * @param professor id
	 * @throws SQLException
	 * @throws AdminNotFoundException
	 */
	public String removeProf(int id) throws SQLException, AdminNotFoundException;
	
}
