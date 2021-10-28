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

import org.springframework.stereotype.Repository;

import com.tcs.bean.RegisteredCourses;
import com.tcs.constant.SQLQueriesConstants;
import com.tcs.util.DBUtils;

/**
 * @author VENKY_HARI
 *
 */
@Repository
public class RegisteredCoursesDAOImpl implements RegisteredCoursesDAOInterface {
	Connection con = DBUtils.getConnection();
	SQLQueriesConstants sql = new SQLQueriesConstants();

	@Override
	public List registeredcoursesList(int id) throws SQLException {
		// TODO Auto-generated method stub
		List<RegisteredCourses> courses = new ArrayList<RegisteredCourses>();
		PreparedStatement stmt = con.prepareStatement(sql.VIEW_REGISTERED_COURSES);
		stmt.setInt(1,id);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			courses.add(new RegisteredCourses(rs.getInt(2),rs.getInt(3)));
		}
		return courses;
	}

}
