/**
 * 
 */
package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.tcs.bean.Admin;
import com.tcs.bean.GradeCard;
import com.tcs.util.DBUtils;
import com.tcs.bean.GradeCard;

/**
 * @author VENKY_HARI
 *
 */
@Repository
public class GradeCardDAOImpl implements GradeCardDAOInterface {
	Connection con = DBUtils.getConnection();

	@Override
	public GradeCard getGrade(int studentId, int courseId) throws SQLException {
		// TODO Auto-generated method stub
		String s = "select * from gradecard where studentId=? AND courseId=?";
		PreparedStatement stmt = con.prepareStatement(s);
		
		System.out.println("Database Connected......");
		stmt.setInt(1,studentId);
		stmt.setInt(2,courseId);
		ResultSet rs= stmt.executeQuery();
		if (rs.next())
			return new GradeCard(rs.getInt("studentId"),rs.getInt("courseId"),rs.getString("grade"));
		return null;
	}

}
