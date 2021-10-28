/**
 * 
 */
package com.tcs.dao;

import java.sql.SQLException;
import java.util.List;

import com.tcs.bean.Payment;

/**
 * @author VENKY_HARI
 *
 */
public interface PaymentDAOInterface {
	public List list(int id) throws SQLException;
	public String insert(int id, Payment payment) throws SQLException;
}
