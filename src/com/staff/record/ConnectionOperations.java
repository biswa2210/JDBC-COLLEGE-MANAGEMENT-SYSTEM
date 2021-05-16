package com.staff.record;

import java.sql.*;
import java.util.*;
/*
CREATED BY BISWARUP BHATTACHARJEE
EMAIL    : bbiswa471@gmail.com
PHONE NO : 6290272740
*/
public class ConnectionOperations {
  public static boolean InsertStudentToDB(Staff st) {
	  boolean success=false;
	  try {
		  //JDBC CODE............
		  Connection con=ConnectionFecther.CreateConnection();
		  //QUERY.....
		  String Query="insert into staffs(staffnm,staffenroll,staffDg,staffph,staffcity) values(?,?,?,?,?)";
		  //PREPARED STATEMENT....
		  PreparedStatement pst=con.prepareStatement(Query);
		  //SET VALUES 1 BY 1
		  pst.setString(1, st.getStaffNm());
		  pst.setString(2, st.getStaffENno());
		  pst.setString(3, st.getStaffDG());
		  pst.setString(4, st.getStaffPHno());
		  pst.setString(5, st.getStaffCity());
		  //EXECUTE
		  pst.executeUpdate();
		  success=true;
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
	 return success;
			  
  }
  public static void ShowAll() {
	  try {
		  Connection con=ConnectionFecther.CreateConnection();
		  Statement smt=con.createStatement();
		  String Query="select * from staffs";
		  ResultSet rs=smt.executeQuery(Query);
	    	System.out.println("######################################################################################################################################################################################################################################");
		  System.out.printf("%-10s%-30s%-20s%-55s%-15s\n","ID","STUDENT NAMES","ENROLLMENT NO.","DESIGNATION.","PHONE NO.");
	    	System.out.println("######################################################################################################################################################################################################################################");
			if(rs.next()){ 
				do{
				System.out.printf("%-10s%-30s%-20s%-55s%-15s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
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
  public static void searchRecord(String sten) {
	  try {
	  Connection con=ConnectionFecther.CreateConnection();
	  String Query="select staffnm,staffenroll,staffDg,staffph,staffcity from staffs where staffenroll="+sten;
	  Statement smt=con.createStatement();
	  ResultSet rs = smt.executeQuery(Query);
	  if(rs.next()) {
	  do {
	  System.out.println("STAFF'S  SERIAL NUMBER       :: "+rs.getString(1));
	  System.out.println("STAFF'S  NAME                :: "+rs.getString(2));
	  System.out.println("STAFF'S  DESIGNATION :: "+rs.getString(3));
	  System.out.println("STAFF'S  PHONE NUMBER        :: "+rs.getString(4));
	  System.out.println("STAFF'S  CITY NAME           :: "+rs.getString(5));
	  }while(rs.next());}
	  else {
		  System.out.println("Record Not Found...");
	  }
  }catch(Exception e) {
	  System.out.println(e.getMessage());
  }
}
  public static void delete(int id) {
	  try {
		  Connection con=ConnectionFecther.CreateConnection();
		  String Query1=String.format("select staffnm from staffs where staffid=%d",id);
		  Statement smt=con.createStatement();
		  ResultSet rs = smt.executeQuery(Query1);
		  if(rs.next()) {
			  do {
				  System.out.println("STAFF'S  NAME :: "+rs.getString(1));
				  System.out.println("DELETED SUCCESSFULLY !!!!");
			  }while(rs.next());}
			  else {
				  System.out.println("Record Not Found...");
			  }
		  String Query="delete from staffs where staffid=?";
		  PreparedStatement pstmt=con.prepareStatement(Query);
		  pstmt.setInt(1,id);
		  pstmt.executeUpdate();
		  autoIdUpdate();
		  
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	 
  }
  public static boolean updatePhoneNo(String Enrollment) {
	   boolean f=false;
      try{
      Connection con=ConnectionFecther.CreateConnection();
      String IQ=String.format("select staffnm,staffph from staffs where staffenroll=\"%s\"",Enrollment);
      Statement stmt=con.createStatement();
      ResultSet rs=stmt.executeQuery(IQ);

      if(rs.next()){
          do{
              System.out.println("STAFF'S NAME :: "+rs.getString(1));
              System.out.println("PHONE NUMBER  :: "+rs.getString(2));
          }while(rs.next());
          String FQ="update staffs set staffph=? where staffenroll=?";
          System.out.print("Enter the Updated Phone Number :: ");
          Scanner sc=new Scanner(System.in);
          String phno=sc.nextLine();
          PreparedStatement pst=con.prepareStatement(FQ);
          pst.setString(1,phno);
          pst.setString(2,Enrollment);
          pst.executeUpdate();
          f=true;
          return f;
      }
      else{
          System.out.println("Record Not Found");
          return f;
      }

  }catch (Exception e){
      System.out.println("Error Occured :: "+e.getMessage());
          return f;
      }
 }
 
  
  public static void autoIdUpdate() {
	  try {
		  String Q1="SET  @num := 0";
		  String Q2="UPDATE staffs SET staffid = @num := (@num+1)";
		  String Q3="ALTER TABLE staffs AUTO_INCREMENT =1";
		  Connection con=ConnectionFecther.CreateConnection();
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
  public static String[] enrollsArray() {
	  String  stens[] = new String[0];
	  try {
		  Connection con=ConnectionFecther.CreateConnection();
		  String Q="select staffenroll from staffs";
		  Statement smt=con.createStatement();
		  ResultSet rs=smt.executeQuery(Q);
		  
		  int i=0;
		  if(rs.next()) {
			do {
				stens=Arrays.copyOf(stens,stens.length+1);
				stens[i]=rs.getString(1);
				i++;
				
			}while(rs.next());
			return stens;
		  }
		  return stens;
	  
		  
	  }catch(Exception e)
	  {
		  e.printStackTrace();
		  return stens;
	  }
  }
  public static String[] regnosArray() {
	  String  strgs[] = new String[0];
	  try {
		  Connection con=ConnectionFecther.CreateConnection();
		  String Q="select staffDg from staffs";
		  Statement smt=con.createStatement();
		  ResultSet rs=smt.executeQuery(Q);
		  
		  int i=0;
		  if(rs.next()) {
			do {
				strgs=Arrays.copyOf(strgs,strgs.length+1);
				strgs[i]=rs.getString(1);
				i++;
				
			}while(rs.next());
			return strgs;
		  }
		  return strgs;
	  
		  
	  }catch(Exception e)
	  {
		  e.printStackTrace();
		  return strgs;
	  }
  }
  }
