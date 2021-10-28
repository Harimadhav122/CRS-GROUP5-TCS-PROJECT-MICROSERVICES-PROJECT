/**
 * 
 */
package com.tcs.util;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DBUtils {
	private static Connection connection = null;
	public static Connection getConnection() {
	
		if(connection!=null)
			return connection;
		else {
			try {
				Properties prop = new Properties();
				InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("application.properties");
				prop.load(inputStream);
				String driver = prop.getProperty("spring.datasource.driverClassName");
				String url = prop.getProperty("spring.datasource.url");
				String user = prop.getProperty("spring.datasource.username");
				String password = prop.getProperty("spring.datasource.password");
				
				Class.forName(driver);
				connection = DriverManager.getConnection(url,user,password);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
}