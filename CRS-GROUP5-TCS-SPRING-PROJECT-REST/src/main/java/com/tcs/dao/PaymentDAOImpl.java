/**
 * 
 */
package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.tcs.bean.Payment;
import com.tcs.constant.SQLQueriesConstants;
import com.tcs.util.DBUtils;

/**
 * @author VENKY_HARI
 *
 */
@Repository
public class PaymentDAOImpl implements PaymentDAOInterface {
	Connection con = DBUtils.getConnection();
	SQLQueriesConstants sql = new SQLQueriesConstants();
	private static Logger logger=Logger.getLogger(AdminDAOImpl.class);

	@Override
	public List list(int id) throws SQLException {
		// TODO Auto-generated method stub
		List<Payment> payments = new ArrayList<Payment>();
		PreparedStatement stmt=con.prepareStatement("select * from payment where studentId=?");
		stmt.setInt(1,id);
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			payments.add(new Payment(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4)));
		}
		return payments;
	}

	@Override
	public String insert(int id, Payment payment) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmt=con.prepareStatement("insert into payment values(?,?,?,?)");
		stmt.setInt(1,id);
		stmt.setInt(2,payment.getTransactionId());
		stmt.setInt(3,payment.getAmount());
		stmt.setString(4,payment.getPaymentMode());
		
		int i = stmt.executeUpdate();
		
		if(i==1) {
			PreparedStatement stmt1=con.prepareStatement("insert into paymentnotification values(?,?)");
			stmt1.setInt(1,payment.getTransactionId());
			stmt1.setString(2,"success");
			int j = stmt1.executeUpdate();
			return "Your payment is successful";
		}
		return "Your payment is failed";
	}

}
