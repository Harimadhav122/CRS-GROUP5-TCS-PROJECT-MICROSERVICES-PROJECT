/**
 * 
 */
package com.tcs.exception;

/**
 * @author VENKY_HARI
 *
 */
public class StudentNotFoundException extends Exception {
	private int id;
	public StudentNotFoundException(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public String getMessage() {
		return "Student with id "+id+" not found";
	}
}
