import java.sql.*;
import java.util.*;
import com.staff.attendence.*;
/*
CREATED BY BISWARUP BHATTACHARJEE
EMAIL    : bbiswa471@gmail.com
PHONE NO : 6290272740
*/
public class Operations2 {
	public static void addAttendence() {
		Scanner sc=new Scanner(System.in);
		System.out.print("ENROLLMENT NO. OF STAFF :: ");
		String enroll=sc.nextLine();
		System.out.print("NAME OF THE STAFF :: ");
		String nm=sc.nextLine();
		String temp1=nm.replaceAll("\\s+","").toLowerCase();
		System.out.print("ENTER THE CHECK IN TIME :: ");
		String chckTime=sc.nextLine();
		System.out.print("ENTER THE DATE OF ATTENDENCE (D/M/YYYY):: ");
		String date=sc.nextLine();
		String temp4=date.replaceAll("\\s+","").toLowerCase();
		System.out.print("ENTER THE DESIGNATION OF STAFF (IF FACULTY,THEN TYPE--> \"FACULTY_STREAM_SUBJECT\"):: ");
		String designation=sc.nextLine();
		String temp2=designation.replaceAll("\\s+", "").toLowerCase();
		String temp3=enroll.replaceAll("\\s+","").toLowerCase();
		String[] enrolls = ConnectionOpratios.enrollsArray(); 
		String[] desgns = ConnectionOpratios.degnsArray();
		String[] names = ConnectionOpratios.nmsArray();
		String[] dates=  ConnectionOpratios.datesAttendArray();
		int flag=0;
		for(int i=0;i<enrolls.length;i++) {
			String temp1c=names[i].replaceAll("\\s+","").toLowerCase();
			String temp2c=desgns[i].replaceAll("\\s+","").toLowerCase();
			String temp3c=enrolls[i].replaceAll("\\s+", "").toLowerCase();
			if(temp1.equals(temp1c) && temp2.equals(temp2c) && temp3.equals(temp3c)) {
				for(int j=0;j<dates.length;j++) {
					String temp4c=dates[j].replaceAll("\\s+","").toLowerCase();
					flag=1;
					if(temp4.equals(temp4c)) {
						flag=2;
						break;
				}
				
			}
			
			}
			}
		if(flag==1) {
			Attendance at=new Attendance(enroll,nm,chckTime,date,designation);
			boolean retval = ConnectionOpratios.InsertStaffToDB(at);
			if(retval) {
				System.out.println("Record Added Successfully.....");
			}else {
				System.out.println("Something Went Wrong.....");
			}
		}
		else if(flag==2){
			System.out.println("This Staff's Attendance is already listed...");

			
		}else {
			System.out.println("This Staff's Credentials Is Not Present Our Database...Try Again With Another Credentials..");
		}
		
		
	}
	public static void fetchAttendence() {
		Scanner sc=new Scanner(System.in);
		System.out.print("ENTER THE DATE TO FETCH ATTENDENCE DETAILS :: "); 
		String Date=sc.nextLine();
		Date=Date.replaceAll("\\s+","").toLowerCase();
		ConnectionOpratios.fetchAttendence(Date);	
	}
	public static void alldispl() {
		ConnectionOpratios.allAttendence();
	}
	public static void totalDates() {
		String[] dates=  ConnectionOpratios.datesAttendArray();
		  System.out.println("*************************************************************************************************************************************************************************************************************");
		  System.out.println("Total "+dates.length+" dates added yet ");
		  System.out.println("*************************************************************************************************************************************************************************************************************");
		for(int i=0;i<dates.length;i++) {
			System.out.println((i+1)+"TH DATE IS :: "+dates[i]);
		}
		  System.out.println("*************************************************************************************************************************************************************************************************************");
	
	}
	public static void search() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the enrollment no. of staff :: ");
		String enroll=sc.nextLine();
		String[] dates=  ConnectionOpratios.datesAttendArray();
		String[] mainDates=ConnectionOpratios.searchAttendanceStaff(enroll);
		System.out.println("*************************************************************************************************************************************************************************************************************");
		int count=0;
		for(int i=0;i<dates.length;i++) {
			for(int j=0;j<mainDates.length;j++) {
				if(dates[i].equals(mainDates[j])) {
					count++;
					
				}
			}
			
		}
		if(count>1) {
		System.out.println("THIS STAFF PRESENT TOTAL :: "+count+" DAYS IN OUR COLLEGE");
		}
		else {
			System.out.println("THIS STAFF PRESENT TOTAL :: "+count+" DAY IN OUR COLLEGE");
		}
		System.out.println("*************************************************************************************************************************************************************************************************************");

	}
	public static void delete(int id) {
		ConnectionOpratios.delete(id);
	}
	

}
