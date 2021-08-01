package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SecondDemo {
	public static void main(String[] args) {
		
		
		String url="jdbc:postgresql://database-1.cpemxk3wvwow.us-east-2.rds.amazonaws.com/dvdrental";
		Connection con=null;
		//Step 1:load the driver  -- not required from java 1.6
		try {
			Class.forName("org.postgresql.Driver");
			//Step 2: Open a connection
				con=DriverManager.getConnection(url,"postgres","ZAua7jciPqmD5qccmxRE");
				//Step 3: create a statement object to execute sql query
				int id=100;
				String name="A%";
				String queryActor="select * from actor where actor_id>? and first_name like ?";
				PreparedStatement stmt=con.prepareStatement(queryActor);
				stmt.setInt(1,id);
				stmt.setString(2, name);
				ResultSet rs = stmt.executeQuery();
				
				//Step 4: Process the resultset
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString("first_name")+" "+rs.getString(3));
				}
				//Step 5: clean up the code
				stmt.close();
				con.close();
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}


