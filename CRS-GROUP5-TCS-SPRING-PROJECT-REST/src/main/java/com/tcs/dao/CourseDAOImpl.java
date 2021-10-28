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

import com.tcs.bean.Admin;
import com.tcs.bean.Course;
import com.tcs.constant.SQLQueriesConstants;
import com.tcs.exception.CourseNotFoundException;
import com.tcs.util.DBUtils;

/**
 * @author VENKY_HARI
 *
 */
@Repository
public class CourseDAOImpl implements CourseDAOInterface{
	Connection con = DBUtils.getConnection();
	SQLQueriesConstants sql = new SQLQueriesConstants();
	private static Logger logger=Logger.getLogger(UserDAOImpl.class);

	@Override
	public List courseList() throws SQLException {
		// TODO Auto-generated method stub
		List<Course> course = new ArrayList<Course>();
		PreparedStatement stmt = con.prepareStatement(sql.VIEW_COURSE);
		logger.debug(stmt);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			course.add(new Course(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
		}
		return course;
	}

	@Override
	public Course getCourse(int id) throws CourseNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			String s = sql.VIEW_SELECTED_COURSE;
			PreparedStatement stmt = con.prepareStatement(s);
			stmt.setInt(1, id);		
			logger.debug(stmt);
			
			System.out.println("Database Connected......");
			ResultSet rs= stmt.executeQuery();
			logger.debug(rs);
			if (rs.next()) {
				return new Course(rs.getInt("courseId"),rs.getString("courseDesc"),rs.getInt("amount"),rs.getString("catalogName"));
			}
			else {
				throw new CourseNotFoundException(id);
			}
		}
		catch(CourseNotFoundException e) {
			e.getMessage();
		}
		return null;
		
	}

}
