package com.student.manage;
import java.sql.*;
import java.io.*;
public class ConnectionProvider {
	static Connection con;
	/*
CREATED BY BISWARUP BHATTACHARJEE
EMAIL    : bbiswa471@gmail.com
PHONE NO : 6290272740
*/
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
