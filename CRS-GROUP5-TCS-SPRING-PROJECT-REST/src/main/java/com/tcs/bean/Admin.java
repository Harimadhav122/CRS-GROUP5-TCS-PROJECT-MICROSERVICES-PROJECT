/**
 * 
 */
package com.tcs.bean;

/**
 * @author VENKY_HARI
 *
 */
public class Admin {
	public int adminId;
	public String adminName;
	private String password;
	
	public void setPassword(String password) {
		this.password = password;
	}
	//constructor to assign values when object is created
	public Admin(int adminId, String adminName, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
	}
	public Admin(int adminId, String adminName) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
	}
	/**
	 * @return the adminId
	 */
	public Admin() {
		
	}
	/**
	 * @return the adminId
	 */
	public int getAdminId() {
		return adminId;
	}
	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}
	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
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
}
