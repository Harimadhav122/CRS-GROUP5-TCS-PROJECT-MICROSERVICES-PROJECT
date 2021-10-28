/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;

import com.tcs.exception.UserNotFoundException;

/**
 * @author VENKY_HARI
 *
 */
public interface UserServiceInterface {
	public String studentLogin(int userId, String password) throws SQLException, UserNotFoundException;
	public String professorLogin(int userId, String password) throws SQLException, UserNotFoundException;
	public String AdminLogin(int userId, String password) throws SQLException, UserNotFoundException;

}
