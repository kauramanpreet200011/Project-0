package com.revature.project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustImpl1 {
	static int count=0;
	static boolean b1;
	static Connection con = ConnectionUtils.getConnection();
	public static boolean login1(int acc_no,String password) {
		try {
		int acc_no1 = acc_no;
		String pwd1 = password;
		String query="select * from cust_details where accountno=? and pwd=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1,acc_no1);
		stmt.setString(2,pwd1);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			System.out.println("Welcome "+rs.getString(1));count++;
		}	if(count == 1) {b1=true;}else {b1=false;}
	}catch(SQLException | NullPointerException e) {
		e.printStackTrace();
	}
	return  b1;
	}

}
