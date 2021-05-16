package com.staff.attendence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import com.staff.record.ConnectionFecther;
import com.staff.record.Staff;
/*
CREATED BY BISWARUP BHATTACHARJEE
EMAIL    : bbiswa471@gmail.com
PHONE NO : 6290272740
*/

public class ConnectionOpratios {
	  public static boolean InsertStaffToDB(Attendance st) {
		  boolean success=false;
		  try {
			  //JDBC CODE............
			  Connection con=ConnectionEstablish.CreateConnection();
			  //QUERY.....
			  String Query="insert into staffs_attendance(enroll,name,chckTime,date,designation) values(?,?,?,?,?)";
			  //PREPARED STATEMENT....
			  PreparedStatement pst=con.prepareStatement(Query);
			  //SET VALUES 1 BY 1
			  pst.setString(1, st.getEnroll());
			  pst.setString(2, st.getName());
			  pst.setString(3, st.getChckTime());
			  pst.setString(4, st.getDate());
			  pst.setString(5,st.getDesignation());
			  //EXECUTE
			  pst.executeUpdate();
			  autoIdUpdate();
			  success=true;
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		 return success;
				  
	  }
	  public static void fetchAttendence(String date) {
		  try {
			  Connection con=ConnectionEstablish.CreateConnection();
			  String Q=String.format("select enroll,name,chckTime,date,designation from staffs_attendance where date=\"%s\"",date);
			  Statement smt=con.createStatement();
			  ResultSet rs=smt.executeQuery(Q);
			  System.out.println("*************************************************************************************************************************************************************************************************************");
			  System.out.printf("%-20s%-30s%-25s%-15s%-35s\n","ENROLLMENT NO.","NAME","CHECK-IN TIME","DATE","DESIGNATION");
			  System.out.println("*************************************************************************************************************************************************************************************************************");
			  autoIdUpdate();
				if(rs.next()){ 
					do{
					System.out.printf("%-20s%-30s%-25s%-15s%-35s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
					System.out.println();
					}while(rs.next());
				}
				else{
					System.out.println("Record Not Found...");
				}
				con.close();
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		
	  }
	  public static void delete(int id) {
		  try {
			  Connection con=ConnectionEstablish.CreateConnection();
			  String Query1=String.format("select name from staffs_attendance where id=%d",id);
			  Statement smt=con.createStatement();
			  ResultSet rs = smt.executeQuery(Query1);
			  if(rs.next()) {
				  do {
					  System.out.println("STUDENT NAME :: "+rs.getString(1));
					  System.out.println("DELETED SUCCESSFULLY !!!!");
				  }while(rs.next());}
				  else {
					  System.out.println("Record Not Found...");
				  }
			  String Query="delete from staffs_attendance where id=?";
			  PreparedStatement pstmt=con.prepareStatement(Query);
			  pstmt.setInt(1,id);
			  pstmt.executeUpdate();
			  autoIdUpdate();
			  
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  public static void autoIdUpdate() {
		  try {
			  String Q1="SET  @num := 0";
			  String Q2="UPDATE staffs_attendance SET id = @num := (@num+1)";
			  String Q3="ALTER TABLE staffs_attendance AUTO_INCREMENT =1";
			  Connection con=ConnectionEstablish.CreateConnection();
			  PreparedStatement pst1=con.prepareStatement(Q1);
			  PreparedStatement pst2=con.prepareStatement(Q2);
			  PreparedStatement pst3=con.prepareStatement(Q3);
			  pst1.executeUpdate();
			  pst2.executeUpdate();
			  pst3.executeUpdate();
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
	  public static void allAttendence() {
		  try {
			  Connection con=ConnectionEstablish.CreateConnection();
			  Statement smt=con.createStatement();
			  String Query="select * from staffs_attendance";
			  ResultSet rs=smt.executeQuery(Query);
			  System.out.println("*************************************************************************************************************************************************************************************************************");
			  System.out.printf("%-10s%-20s%-30s%-25s%-15s%-35s\n","ID","ENROLLMENT NO.","NAME","CHECK-IN TIME","DATE","DESIGNATION");
			  System.out.println("*************************************************************************************************************************************************************************************************************");
				if(rs.next()){ 
					do{
					System.out.printf("%-10s%-20s%-30s%-25s%-15s%-35s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
					System.out.println();
					}while(rs.next());
				}
				else{
					System.out.println("Record Not Found...");
				}
				con.close();
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  public static String[] searchAttendanceStaff(String enroll) {
		  String  dates[] = new String[0];
		  try {
			  Connection con=ConnectionEstablish.CreateConnection();
			  Statement smt=con.createStatement();
			  Statement smt2=con.createStatement();
			  String q1=String.format("select * from staffs_attendance where enroll=\"%s\"",enroll);
			  ResultSet rs=smt.executeQuery(q1);
			  System.out.println("*************************************************************************************************************************************************************************************************************");
			  System.out.printf("%-10s%-20s%-30s%-25s%-15s%-35s\n","ID","ENROLLMENT NO.","NAME","CHECK-IN TIME","DATE","DESIGNATION");
			  System.out.println("*************************************************************************************************************************************************************************************************************");
				int i=0;
				if(rs.next()){ 
					do{
					System.out.printf("%-10s%-20s%-30s%-25s%-15s%-35s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
					System.out.println();
					dates=Arrays.copyOf(dates,dates.length+1);
					dates[i]=rs.getString(5);
					i++;
					}while(rs.next());
					con.close();
					return dates;
				}
				else{
					System.out.println("Record Not Found...");
					return dates;
				}
				
				
		  }
		  catch(Exception e) {
			  e.printStackTrace();
			  return dates;
		  }
	  }
	  public static String[] degnsArray() {
		  String  degs[] = new String[0];
		  try {
			  Connection con=ConnectionFecther.CreateConnection();
			  String Q="select staffDg from staffs";
			  Statement smt=con.createStatement();
			  ResultSet rs=smt.executeQuery(Q);
			  
			  int i=0;
			  if(rs.next()) {
				do {
					degs=Arrays.copyOf(degs,degs.length+1);
					degs[i]=rs.getString(1);
					i++;
					
				}while(rs.next());
				return degs;
			  }
			  return degs;
		  
			  
		  }catch(Exception e)
		  {
			  e.printStackTrace();
			  return degs;
		  }
	  }
	  public static String[] nmsArray() {
		  String  nms[] = new String[0];
		  try {
			  Connection con=ConnectionFecther.CreateConnection();
			  String Q="select staffnm from staffs";
			  Statement smt=con.createStatement();
			  ResultSet rs=smt.executeQuery(Q);
			  
			  int i=0;
			  if(rs.next()) {
				do {
					nms=Arrays.copyOf(nms,nms.length+1);
					nms[i]=rs.getString(1);
					i++;
					
				}while(rs.next());
				return nms;
			  }
			  return nms;
		  
			  
		  }catch(Exception e)
		  {
			  e.printStackTrace();
			  return nms;
		  }
	  }
	  public static String[] enrollsArray() {
		  String  enrolls[] = new String[0];
		  try {
			  Connection con=ConnectionFecther.CreateConnection();
			  String Q="select staffenroll from staffs";
			  Statement smt=con.createStatement();
			  ResultSet rs=smt.executeQuery(Q);
			  
			  int i=0;
			  if(rs.next()) {
				do {
					enrolls=Arrays.copyOf(enrolls,enrolls.length+1);
					enrolls[i]=rs.getString(1);
					i++;
					
				}while(rs.next());
				return enrolls;
			  }
			  return enrolls;
		  
			  
		  }catch(Exception e)
		  {
			  e.printStackTrace();
			  return enrolls;
		  }
	  }
	  public static String[] datesAttendArray() {
		  String  dates[] = new String[0];
		  try {
			  Connection con=ConnectionEstablish.CreateConnection();
			  String Q="select date from staffs_attendance";
			  Statement smt=con.createStatement();
			  ResultSet rs=smt.executeQuery(Q);
			  
			  int i=0;
			  if(rs.next()) {
				do {
					dates=Arrays.copyOf(dates,dates.length+1);
					dates[i]=rs.getString(1);
					i++;
					
				}while(rs.next());
				return dates;
			  }
			  return dates;
		  
			  
		  }catch(Exception e)
		  {
			  e.printStackTrace();
			  return dates;
		  }
	  }
}
