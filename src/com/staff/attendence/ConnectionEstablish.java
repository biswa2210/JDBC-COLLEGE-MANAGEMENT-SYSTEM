package com.staff.attendence;
import java.sql.*;
public class ConnectionEstablish {
	static Connection con;
    public static Connection CreateConnection() {
    	try {
    		//LOAD THE DRIVER
    		Class.forName("com.mysql.jdbc.Driver");
    		//CREATE THE CONNECTION
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_management","root","BISWA_LOVES_CODING");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return con;
    }
}