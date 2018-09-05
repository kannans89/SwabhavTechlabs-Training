package com.techlabs.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
	public void executeTransaction(Connection dbConnection, double amount) throws SQLException {
		try {
			dbConnection.setAutoCommit(false);
			
			
			String cquery = "select * from customer where id = ?";
			PreparedStatement selectCustomer = dbConnection.prepareStatement(cquery);
			selectCustomer.setInt(1, 101);
			ResultSet cresult = selectCustomer.executeQuery();
			double cbalance = 0;
			while(cresult.next()) {
				cbalance = Double.parseDouble(cresult.getString("balance"));
			}
			
			double cnewBalance = cbalance-amount;
			
			String cquery1 = "update customer set balance = ? where id = ?";
			PreparedStatement updateCustomer = dbConnection.prepareStatement(cquery1);
			updateCustomer.setDouble(1, cnewBalance);
			updateCustomer.setInt(2, 101);
			updateCustomer.executeUpdate();
			
			String mquery = "select * from merchent where id = ?";
			PreparedStatement selectMerchent = dbConnection.prepareStatement(mquery);
			selectMerchent.setInt(1, 1001);
			ResultSet mresult = selectMerchent.executeQuery();
			double mbalance = 0;
			while(mresult.next()) {
				mbalance = Double.parseDouble(mresult.getString("balance1"));
			}
			
			double mnewBalance = mbalance+amount;
			
			String mquery2 = "update merchent set balance = ? where id = ?";
			PreparedStatement updateMerchent = dbConnection.prepareStatement(mquery2);
			updateMerchent.setDouble(1, mnewBalance);
			updateMerchent.setInt(2, 1001);
			
			updateMerchent.executeUpdate();
			dbConnection.commit();

			System.out.println("Done!");
		} catch(SQLException ex) {
			ex.printStackTrace();
			try {
				dbConnection.rollback();
				System.out.println("Roll backed successfully");
			} catch(Exception e) {
				e.printStackTrace();
			}
		} finally{
			try {
				if(dbConnection != null) {
					dbConnection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}
}
