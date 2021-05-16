package com.student.manage;
import java.sql.*;
import java.util.*;
/*
CREATED BY BISWARUP BHATTACHARJEE
EMAIL    : bbiswa471@gmail.com
PHONE NO : 6290272740
*/
public class ConnectionMethods {
  public static boolean InsertStudentToDB(Student st) {
	  boolean success=false;
	  try {
		  //JDBC CODE............
		  Connection con=ConnectionProvider.CreateConnection();
		  //QUERY.....
		  String Query="insert into students(sname,senroll,sregno,sphone,scity) values(?,?,?,?,?)";
		  //PREPARED STATEMENT....
		  PreparedStatement pst=con.prepareStatement(Query);
		  //SET VALUES 1 BY 1
		  pst.setString(1, st.getStudentNm());
		  pst.setString(2, st.getStudentENno());
		  pst.setString(3, st.getStudentRGno());
		  pst.setString(4, st.getStudentPHno());
		  pst.setString(5, st.getStudentCity());
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
		  Connection con=ConnectionProvider.CreateConnection();
		  Statement smt=con.createStatement();
		  String Query="select * from students";
		  ResultSet rs=smt.executeQuery(Query);
	    	System.out.println("######################################################################################################################################################################################################################################");
		  System.out.printf("%-10s%-50s%-25s%-25s%-25s\n","ID","STUDENT NAMES","ENROLLMENT NO.","REGISTRATION NO.","PHONE NO.");
	    	System.out.println("######################################################################################################################################################################################################################################");
			if(rs.next()){ 
				do{
				System.out.printf("%-10s%-50s%-25s%-25s%-25s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
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
	  Connection con=ConnectionProvider.CreateConnection();
	  String Query="select sid,sname,sregno,sphone,scity from students where senroll="+sten;
	  Statement smt=con.createStatement();
	  ResultSet rs = smt.executeQuery(Query);
	  if(rs.next()) {
	  do {
	  System.out.println("STUDENT SERIAL NUMBER       :: "+rs.getString(1));
	  System.out.println("STUDENT NAME                :: "+rs.getString(2));
	  System.out.println("STUDENT REGISTRATION NUMBER :: "+rs.getString(3));
	  System.out.println("STUDENT PHONE NUMBER        :: "+rs.getString(4));
	  System.out.println("STUDENT CITY NAME           :: "+rs.getString(5));
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
		  Connection con=ConnectionProvider.CreateConnection();
		  String Query1=String.format("select sname from students where sid=%d",id);
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
		  String Query="delete from students where sid=?";
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
       Connection con=ConnectionProvider.CreateConnection();
       String IQ=String.format("select sname,sphone from students where senroll=\"%s\"",Enrollment);
       Statement stmt=con.createStatement();
       ResultSet rs=stmt.executeQuery(IQ);

       if(rs.next()){
           do{
               System.out.println("STUDENT'S NAME :: "+rs.getString(1));
               System.out.println("PHONE NUMBER  :: "+rs.getString(2));
           }while(rs.next());
           String FQ="update students set sphone=? where senroll=?";
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
		  String Q2="UPDATE students SET sid = @num := (@num+1)";
		  String Q3="ALTER TABLE students AUTO_INCREMENT =1";
		  Connection con=ConnectionProvider.CreateConnection();
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
		  Connection con=ConnectionProvider.CreateConnection();
		  String Q="select senroll from students";
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
		  Connection con=ConnectionProvider.CreateConnection();
		  String Q="select sregno from students";
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
