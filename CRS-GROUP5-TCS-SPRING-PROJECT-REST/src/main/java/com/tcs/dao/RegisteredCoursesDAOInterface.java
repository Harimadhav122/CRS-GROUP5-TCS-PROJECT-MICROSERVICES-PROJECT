/**
 * 
 */
package com.tcs.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author VENKY_HARI
 *
 */
public interface RegisteredCoursesDAOInterface {
	public List registeredcoursesList(int id) throws SQLException;
}
