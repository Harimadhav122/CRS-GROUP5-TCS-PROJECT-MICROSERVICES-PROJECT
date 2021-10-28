/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;
import java.util.List;

import com.tcs.bean.Course;
import com.tcs.exception.CourseNotFoundException;

/**
 * @author VENKY_HARI
 *
 */
public interface CourseServiceInterface {
	public List courseList() throws SQLException;
	public Course getCourse(int id) throws CourseNotFoundException, SQLException;
}
