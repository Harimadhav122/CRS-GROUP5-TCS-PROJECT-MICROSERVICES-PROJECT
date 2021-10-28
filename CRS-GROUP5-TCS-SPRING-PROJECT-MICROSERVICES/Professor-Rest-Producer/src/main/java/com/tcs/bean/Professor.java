/**
 * 
 */
package com.tcs.bean;

/**
 * @author VENKY_HARI
 *
 */
public class Professor {
	private int ProfessorId;
	private String ProfessorName;
	private String ProfessorDept;
	private String password;
	
	
	public Professor(int ProfessorId, String ProfessorName, String ProfessorDept, String password) {
		// TODO Auto-generated constructor stub
		super();
		this.ProfessorId=ProfessorId;
		this.ProfessorName=ProfessorName;
		this.ProfessorDept=ProfessorDept;
		this.password=password;
		
	}
	public Professor(int ProfessorId, String ProfessorName, String ProfessorDept) {
		// TODO Auto-generated constructor stub
		super();
		this.ProfessorId=ProfessorId;
		this.ProfessorName=ProfessorName;
		this.ProfessorDept=ProfessorDept;
		
	}
	public Professor(){
		
	}
	/**
	 * @return the professorId
	 */
	public int getProfessorId() {
		return ProfessorId;
	}
	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(int professorId) {
		ProfessorId = professorId;
	}
	/**
	 * @return the professorName
	 */
	public String getProfessorName() {
		return ProfessorName;
	}
	/**
	 * @param professorName the professorName to set
	 */
	public void setProfessorName(String professorName) {
		ProfessorName = professorName;
	}
	/**
	 * @return the professorDept
	 */
	public String getProfessorDept() {
		return ProfessorDept;
	}
	/**
	 * @param professorDept the professorDept to set
	 */
	public void setProfessorDept(String professorDept) {
		ProfessorDept = professorDept;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}