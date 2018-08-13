package com.framework.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public Connection makeConnection() {
		Connection con=null;
		 // JDBC driver name and database URL
         final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		 final String DB_URL = "jdbc:mysql://localhost/";
		 //  Database credentials
		 final String USER = "username";
		 final String PASS = "password";
		 try{
		      //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      con = DriverManager.getConnection(DB_URL, USER, PASS);

		     
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try

		return con;
		
	}

}
