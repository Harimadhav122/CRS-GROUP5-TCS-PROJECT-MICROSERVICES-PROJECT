/**
 * 
 */
package com.tcs.exception;

/**
 * @author VENKY_HARI
 *
 */
public class AdminNotFoundException extends Exception {
	private int id;
	public AdminNotFoundException(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public String getMessage() {
		return "Admin with id "+id+" not found";
	}
}
