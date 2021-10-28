/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.dao.UserDAOInterface;
import com.tcs.exception.UserNotFoundException;

/**
 * @author VENKY_HARI
 *
 */
@Component
public class UserServiceImpl implements UserServiceInterface {
	@Autowired 
	private UserDAOInterface users;

	@Override
	public String studentLogin(int userId, String password) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		return users.studentLogin(userId, password);
	}

	@Override
	public String professorLogin(int userId, String password) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		return users.professorLogin(userId, password);
	}

	@Override
	public String AdminLogin(int userId, String password) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		return users.AdminLogin(userId, password);
	}

}
