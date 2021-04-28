import java.util.Scanner;
import java.io.IOException;
public class MenuItems {
public static void mainMenu(){
	Scanner sc = new Scanner(System.in); 
	int input;
	do {
    System.out.println("######################################################################################################################################################################################################################################");
	System.out.println("COLLEGE ADMIN PANEL");
	System.out.println("######################################################################################################################################################################################################################################");
	System.out.println("PRESS --> 1 :: STUDENTS RECORD PANEL");
	System.out.println("PRESS --> 2 :: STUDENTS ATTENDENCE PANEL");
	System.out.println("PRESS --> 3 :: STAFF AND FACULTY RECORDS PANEL");
	System.out.println("PRESS --> 4 :: STAFFS ATTENDENCE PANEL");
	System.out.println("PRESS --> 5 :: EXIT");
	System.out.println("######################################################################################################################################################################################################################################");
    System.out.print("ENTER YOUR CHOICE :: ");
    input = sc.nextInt();
    switch (input) {
        case 1:Navigations.StudentRecordsAdmin();
               break;
        case 2: Navigations.StudentAttendenceSystem();
            break;
        case 3: Navigations.StaffSRecordsAdmin();
            break;
        case 4: Navigations.StaffAttendenceSystem();
        	break;
        case 5: System.exit(0);
  
        default:
            System.out.print("The entered value is unrecognized!\n");
            break;
    }
	}while(true);
}
}
