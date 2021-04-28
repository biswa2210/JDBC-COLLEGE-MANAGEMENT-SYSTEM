import java.util.Scanner;
import com.student.manage.ConnectionMethods;
import com.student.manage.Student;
public class StudentsRecord {
	public static void addStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER THE NAME OF THE STUDENT :: ");
		String stnm=sc.nextLine();
		System.out.print("ENTER THE ENROLLMENT NUMBER OF THE STUDENT :: ");
		String sten=sc.nextLine();
		sten=sten.replaceAll("\\s+","").toLowerCase();
		String[] enrolls=ConnectionMethods.enrollsArray();
		int flag=0; 
		for(int i=0;i<enrolls.length;i++) {
			String temp=enrolls[i].replaceAll("\\s+","").toLowerCase();
			if(sten.equals(temp)) {
				flag=1;
				break;
			}
		}
		if(flag==0) {
		System.out.print("ENTER THE REGISTRATION NUMBER OF THE STUDENT :: ");
		String strg=sc.nextLine();
		strg=strg.replaceAll("\\s+","").toLowerCase();
		String[] rgnos=ConnectionMethods.regnosArray();
		int flag2=0;
		for(int i=0;i<rgnos.length;i++) {
			String temp=rgnos[i].replaceAll("\\s+","").toLowerCase();
			if(strg.equals(temp)) {
				flag2=1;
				break;
			}
		}
		if(flag2==0) {
			System.out.print("ENTER THE PHONE NUMBER OF THE STUDENT :: ");
			String stph=sc.nextLine();
			System.out.print("ENTER THE CITY OF THE STUDENT :: ");
			String stcity=sc.nextLine();
			Student st=new Student(stnm,sten,strg,stph,stcity);
			boolean result=ConnectionMethods.InsertStudentToDB(st);
			if(result) {
				System.out.println("STUDENT RECORD ADDED SUCCESSFULLY.....");
			}
			else {
				System.out.println("Something Went Wrong.......");
			}
		}
		else {
			System.out.println("THIS REGISTRATION NUMBER IS ALREADY REGISTERED....");
		}

		}
		else {
			System.out.println("THIS ENROLLMENT NUMBER IS ALREADY REGISTERED....");
		}
		
		
	}
	public static void displayStudents() {
		ConnectionMethods.ShowAll();
	}
	public static void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER YOUR ENROLLMENT NUMBER :: ");
		String Enrollstr=sc.nextLine();
		ConnectionMethods.searchRecord(Enrollstr);
	}
	public static void delete(int id) {
	ConnectionMethods.delete(id);
	}
	public static void updatePh() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER THE ENROLLMENT NUMBER :: ");
		String Enrollstr=sc.nextLine();
		Enrollstr=Enrollstr.replaceAll("\\s+","").toLowerCase();
		boolean up=ConnectionMethods.updatePhoneNo(Enrollstr);
		  if(up){
	            System.out.println("PHONE NUMBER IS SUCCESSFULLY UPDATED...");
	        }
	        else{
	            System.out.println("Something Went Wrong....");
	        }
	}
}
