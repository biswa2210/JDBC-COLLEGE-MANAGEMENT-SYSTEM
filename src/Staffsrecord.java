import java.util.Scanner;
import com.staff.record.*;
public class Staffsrecord {
	public static void addStaff() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER THE NAME OF THE STAFF :: ");
		String stnm=sc.nextLine();
		System.out.print("ENTER THE ENROLLMENT NUMBER OF THE STAFF :: ");
		String sten=sc.nextLine();
		sten=sten.replaceAll("\\s+","").toLowerCase();
		String[] enrolls=ConnectionOperations.enrollsArray();
		int flag=0; 
		for(int i=0;i<enrolls.length;i++) {
			String temp=enrolls[i].replaceAll("\\s+","").toLowerCase();
			if(sten.equals(temp)) {
				flag=1;
				break;
			}
		}
		if(flag==0) {
		System.out.print("ENTER THE DESIGNATION  OF THE STAFF (IF FACULTY THEN FOMAT IS \"FACULTY_STREAM_SUBJECT\"):: ");
		String stdg=sc.nextLine();
		stdg=stdg.replaceAll("\\s+","").toLowerCase();
		String[] dgs=ConnectionOperations.regnosArray();
		int flag2=0;
		for(int i=0;i<dgs.length;i++) {
			String temp=dgs[i].replaceAll("\\s+","").toLowerCase();
			if(stdg.equals(temp)) {
				flag2=1;
				break;
			}
		}
		if(flag2==0) {
			System.out.print("ENTER THE PHONE NUMBER OF THE STAFF :: ");
			String stph=sc.nextLine();
			System.out.print("ENTER THE CITY OF THE STAFF :: ");
			String stcity=sc.nextLine();
			Staff st=new Staff(stnm,sten,stdg,stph,stcity);
			boolean result=ConnectionOperations.InsertStudentToDB(st);
			if(result) {
				System.out.println("STAFF RECORD ADDED SUCCESSFULLY.....");
			}
			else {
				System.out.println("Something Went Wrong.......");
			}
		}
		else {
			System.out.println("THIS DESIGNATION IS ALREADY OCCUPIED....");
		}

		}
		else {
			System.out.println("THIS ENROLLMENT NUMBER IS ALREADY REGISTERED....");
		}
		
		
	}
	public static void displayStaffs() {
		ConnectionOperations.ShowAll();
	}
	public static void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER YOUR ENROLLMENT NUMBER :: ");
		String Enrollstr=sc.nextLine();
		ConnectionOperations.searchRecord(Enrollstr);
	}
	public static void delete(int id) {
		ConnectionOperations.delete(id);
	}
	public static void updatePh() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER THE ENROLLMENT NUMBER :: ");
		String Enrollstr=sc.nextLine();
		Enrollstr=Enrollstr.replaceAll("\\s+","").toLowerCase();
		boolean up=ConnectionOperations.updatePhoneNo(Enrollstr);
		  if(up){
	            System.out.println("PHONE NUMBER IS SUCCESSFULLY UPDATED...");
	        }
	        else{
	            System.out.println("Something Went Wrong....");
	        }
	}
}
