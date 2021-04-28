import java.util.Scanner;
import java.io.IOException;
public class Navigations {
	public static void StudentRecordsAdmin() {
	Scanner sc = new Scanner(System.in);
	int input;
    do {
    	System.out.println("######################################################################################################################################################################################################################################");
        System.out.println("STUDENTS RECORDS ADMIN PANEL");
    	System.out.println("######################################################################################################################################################################################################################################");
        System.out.println("PRESS 1 : ADD STUDENT");
        System.out.println("PRESS 2 : DELETE STUDENT");
        System.out.println("PRESS 3 : DISPLAY STUDENTS");
        System.out.println("PRESS 4 : SEARCH STUDENT");
        System.out.println("PRESS 5 : UPDATE PHONE");
        System.out.println("PRESS 6 : EXIT");
        System.out.println("PRESS 7 : BACK TO MAIN MENU");
    	System.out.println("######################################################################################################################################################################################################################################");
        System.out.print("ENTER YOUR CHOICE :: ");
        input = sc.nextInt();
        switch (input) {
        case 1: StudentsRecord.addStudent();
        break;
        case 2: System.out.print("Enter the student id to delete :: ");
    			int id=sc.nextInt();
    			StudentsRecord.delete(id);
    			break;
        case 3: StudentsRecord.displayStudents();
        		break;
        case 4: StudentsRecord.search();
        		break;
        case 5:StudentsRecord.updatePh();
        		break;
        case 6: System.exit(0);
        case 7: MenuItems.mainMenu();
            		break;
            default:
                System.out.print("The entered value is unrecognized!\n");
                break;
        }
    } while (true);
    }
	public static void StudentAttendenceSystem() {
		Scanner sc = new Scanner(System.in);
		int input;
        do {
	    	System.out.println("######################################################################################################################################################################################################################################");
            System.out.println("STUDENTS ATTENDENCE RECORDS ADMIN PANEL");
	    	System.out.println("######################################################################################################################################################################################################################################");
            System.out.println("PRESS 1 : ADD ATTENDENCE");
            System.out.println("PRESS 2 : FETCH ATTENDENCE DETAILS");
            System.out.println("PRESS 3 : ALL ATTENDENCE");
            System.out.println("PRESS 4 : TOTAL CLASS IDS");
            System.out.println("PRESS 5 : SEARCH STUDENT");
            System.out.println("PRESS 6 : DELETE RECORD BY SERIAL NUMBER");
            System.out.println("PRESS 7 : EXIT");
            System.out.println("PRESS 8 : BACK TO MAIN MENU");
	    	System.out.println("######################################################################################################################################################################################################################################");
        	System.out.print("ENTER YOUR CHOICE :: ");
            input = sc.nextInt();
            switch (input) {
                case 1: Operations.addAttendence();
                    break;
                case 2: Operations.fetchAttendence();
                    break;
                case 3: Operations.alldispl();
                    break;
                case 4: Operations.totalClasses();
                		break;
                
                case 5: Operations.search();
                		break;
                case 6:System.out.print("Enter the serial no. to delete record :: ");
				int id=sc.nextInt();
				Operations.delete(id);
					break;
                case 7: System.exit(0);
                case 8:MenuItems.mainMenu();
        			   break;
                default:
                    System.out.print("The entered value is unrecognized!\n");
                    break;
            }
        } while (true);


	}
	
	public static void StaffSRecordsAdmin() {
	Scanner sc = new Scanner(System.in);
	int input;
    do {
    	System.out.println("######################################################################################################################################################################################################################################");
        System.out.println("STAFFS RECORDS ADMIN PANEL");
    	System.out.println("######################################################################################################################################################################################################################################");
        System.out.println("PRESS 1 : ADD STAFF");
        System.out.println("PRESS 2 : DELETE STAFF");
        System.out.println("PRESS 3 : DISPLAY STAFFS");
        System.out.println("PRESS 4 : SEARCH STAFF");
        System.out.println("PRESS 5 : UPDATE PHONE");
        System.out.println("PRESS 6 : EXIT");
        System.out.println("PRESS 7 : BACK TO MAIN MENU");
    	System.out.println("######################################################################################################################################################################################################################################");
        System.out.print("ENTER YOUR CHOICE :: ");
        input = sc.nextInt();
        switch (input) {
        case 1: Staffsrecord.addStaff();
        break;
        case 2: System.out.print("Enter the staff's id to delete :: ");
    			int id=sc.nextInt();
    			Staffsrecord.delete(id);
    			break;
        case 3: Staffsrecord.displayStaffs();
        		break;
        case 4: Staffsrecord.search();
        		break;
        case 5:Staffsrecord.updatePh();
        break;
        case 6: System.exit(0);
            case 7: MenuItems.mainMenu();
            		break;
            default:
                System.out.print("The entered value is unrecognized!\n");
                break;
        }
    } while (true);
    }

public static void StaffAttendenceSystem() {
	Scanner sc = new Scanner(System.in);
	int input;
    do {
		  System.out.println("*************************************************************************************************************************************************************************************************************");
        System.out.println("STAFFS ATTENDENCE RECORDS ADMIN PANEL");
		  System.out.println("*************************************************************************************************************************************************************************************************************");
        System.out.println("PRESS 1 : ADD ATTENDENCE");
        System.out.println("PRESS 2 : FETCH ATTENDENCE DETAILS");
        System.out.println("PRESS 3 : ALL ATTENDENCE");
        System.out.println("PRESS 4 : TOTAL DATES");
        System.out.println("PRESS 5 : SEARCH STAFF");
        System.out.println("PRESS 6 : DELETE RECORD BY SERIAL NUMBER");
        System.out.println("PRESS 7 : EXIT");
        System.out.println("PRESS 8 : BACK TO MAIN MENU");
		  System.out.println("*************************************************************************************************************************************************************************************************************");
        System.out.print("ENTER YOUR CHOICE :: ");
        input = sc.nextInt();
        switch (input) {
            case 1: Operations2.addAttendence();
                    break;
            case 2: Operations2.fetchAttendence();
                    break;
            case 3: Operations2.alldispl();
                    break;
            case 4: Operations2.totalDates();
            		break;
            
            case 5: Operations2.search();
            		break;
            case 6: System.out.print("Enter the serial no. to delete record :: ");
    				int id=sc.nextInt();
    				Operations2.delete(id);
    				break;
            case 7: System.exit(0);
            case 8: MenuItems.mainMenu();
    				break;
            default:System.out.print("The entered value is unrecognized!\n");
                    break;
        }
    } while (true);


}

}