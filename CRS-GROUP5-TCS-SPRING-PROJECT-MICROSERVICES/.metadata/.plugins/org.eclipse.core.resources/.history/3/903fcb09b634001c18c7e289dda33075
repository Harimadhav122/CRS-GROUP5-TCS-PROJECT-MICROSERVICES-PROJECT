/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;
import java.util.List;

import com.tcs.bean.GradeCard;
//import com.tcs.bean.Course;
import com.tcs.bean.Student;
import com.tcs.exception.CourseNotFoundException;
import com.tcs.exception.GradeCardNotFoundException;
import com.tcs.exception.StudentNotFoundException;

/**
 * @author VENKY_HARI
 *
 */
public interface StudentServiceInterface {
	/**
	 * Get student details using SQL commands
	 * @param student id
	 * @throws CourseNotFoundException
	 * @throws SQLException 
	 */
	public Student getId(int id) throws SQLException, StudentNotFoundException;
	/**
	 * Register student using SQL commands
	 * @param Student class object
	 * @throws SQLException 
	 */
	public Student insert(Student student) throws SQLException;
	/**
	 * Update student details using SQL commands
	 * @param student id
	 * @param student class object
	 * @throws SQLException 
	 */
	public Student update(int id, Student student)throws SQLException;
	/**
	 * Student register for the course using SQL commands
	 * @param student id
	 * @param course id
	 * @throws SQLException
	 * @throws CourseNotFoundException 
	 */
	public String registerCourse(int studentId, int courseId) throws SQLException,CourseNotFoundException;
	/**
	 * View grade card of the course using SQL commands
	 * @param student id
	 * @param course id
	 * @throws SQLException
	 * @throws GradeCardNotFoundException 
	 */
	public List viewGradeCard(int studentId, int courseId) throws SQLException, GradeCardNotFoundException;
	
	
}
