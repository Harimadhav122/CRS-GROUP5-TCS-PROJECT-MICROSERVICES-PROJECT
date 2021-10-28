/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.dao.RegisteredCoursesDAOInterface;

/**
 * @author VENKY_HARI
 *
 */
@Component
public class RegisteredCoursesServiceImpl implements RegisteredCoursesServiceInterface {
	@Autowired 
	private RegisteredCoursesDAOInterface courses;
	
	public List registeredcoursesList(int id) throws SQLException{
		return courses.registeredcoursesList(id);
	}
}
