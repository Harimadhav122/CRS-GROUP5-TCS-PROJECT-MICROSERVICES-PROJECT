/**
 * 
 */
package com.tcs.exception;

/**
 * @author VENKY_HARI
 *
 */
public class UserNotFoundException extends Exception {
	private int id;
	public UserNotFoundException(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public String getMessage() {
		return "UserId or password is incorrect";
	}

}
