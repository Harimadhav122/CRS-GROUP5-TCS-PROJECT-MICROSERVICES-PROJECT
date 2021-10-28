/**
 * 
 */
package com.tcs.exception;

/**
 * @author VENKY_HARI
 *
 */
public class ProfessorNotFoundException extends Exception {
	private int id;
	public ProfessorNotFoundException(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public String getMessage() {
		return "Professor with id "+id+" not found";
	}
}
