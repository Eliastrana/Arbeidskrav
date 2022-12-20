import java.util.*;

public class Client {
    public static void main(String[] args) {
        AssignmentOverview a = new AssignmentOverview(); // creates new object from AssignmentOverview class

        //testClient(); // test client to make sure methods are working, and that correct information gets printed

        while (true) { // Until broken, the loop will show the menu
            showMenu(a); 
        }
    }

    /**
     * Test client:
     
    public static void testClient() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name of student: ");
        String name = sc.nextLine();

        System.out.println("Enter amount of assignments done");
        int numAssignments = sc.nextInt();

        Student newStudent = new Student(name, numAssignments); // creates student from information read from user input

        System.out.println("Data registered to student:");
        System.out.println("Name: " + newStudent.getName()); // Prints name
        System.out.println("Assignments done: " + newStudent.getNumAssignments()); // prints number of assignments

        System.out.println("Now adding 15 assignments done: ");
        newStudent.increaseNumAssignments(15); // increases amount of assignments done

        System.out.println("Assignments done: " + newStudent.getNumAssignments()); // prints new amount of assignments done
        System.out.println(newStudent.toString());

        System.out.println("Test completed. Please look over data."); // Urges user to check over information to check if it's correct
    }
    */

    /**
     * Method containing the user interface
     */

    public static void showMenu(AssignmentOverview a) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("1: Show all students");
        System.out.println("2: Show number of assignments a specific student have done");
        System.out.println("3: Show number of students registered");
        System.out.println("4: Register a new student");
        System.out.println("5: Increase amount of assignments a specific student have done");
        System.out.println("6: Cancel program");

        int menuInput = in.nextInt();

        switch (menuInput) {
            case 1:
                printEverything(a); 
                showMenu(a); 
                break;

            case 2:
                in.nextLine();
                System.out.println(a.toString()); // Shows current information to user to help with choices
                System.out.print("Which student? "); // asks user to input which student they want to check
                String name = in.nextLine();

                int id = a.studentId(name); // Converts the place of that student in the array list to an integer

                try { // Makes sure that there are no illegal arguments input
                    Student student = a.getStudents().get(id); // gets information for student at specific place in array list
                    System.out.println(student.getName() + " has done " + student.getNumAssignments() + " assignments."); // prints out information for that student
                } catch (IndexOutOfBoundsException e) { // catches illegal arguments. In this case, it let's user know if there are no students with that name
                    System.out.println("This student doesn't exist. Press 1 in the menu to see all students.");
                }
                showMenu(a); // goes back to menu
                break;

            case 3:
                System.out.println(a.getNumOfStudents() + " students are registered."); // prints number of students
                break;

            case 4:
                in.nextLine();
                System.out.println("Enter name of the student: "); // Name of new student
                String name1 = in.nextLine();

                System.out.println("Enter amount of assignments the student has finished:"); // Amount of assignments completed by new student
                int numAssignments = in.nextInt();

                a.newStudent(name1, numAssignments); // creates new student from previous information
                showMenu(a); // goes back to menu
                break;

            case 5:
                in.nextLine();
                System.out.println(a.toString());
                System.out.println("Which student? "); // Asks user which student they would like to work on
                String name2 = in.nextLine();
                int id1 = a.studentId(name2); // Converts the place of that student in the array list to an integer
                try { // Makes sure there are no illegal arguments
                    System.out.println("How many more assignments are done?");
                    int increasement = in.nextInt();
                    Student student = a.getStudents().get(id1); 
                    student.increaseNumAssignments(increasement); 
                    System.out.println(student.getName() + " has now done " + student.getNumAssignments() + " assignments"); 
                } catch (IndexOutOfBoundsException e) { // Catches illegal arguments, in this case if there are no existing students with that name
                    System.out.println("This student doesn't exist. Press 1 in the menu to see all students");
                }
                showMenu(a); // loops back to menu
                break;

            case 6:
                System.out.println("Cancelling...");
                System.exit(0);
                break;

            default:
                System.out.println("You need to enter a number between 1 and 6");
                showMenu(a);
                break;
        }
    }

    /**
     * Method to print out all information
     * @param a uses object a as a variable
     */
    public static void printEverything(AssignmentOverview a) {
        System.out.println("");
        if (a.getNumOfStudents() < 1) { // If less than 1, no student has done work ;(
            System.out.println("There are no registered students.");
        } else { 
            System.out.println("Students: ");
            for (int i = 0; i < a.getNumOfStudents(); i++) { // prints amount of students based on how many students there are
                Student student = a.getStudents().get(i); 
                System.out.println("Name: " + student.getName() + ", assignments: " + student.getNumAssignments()); 
            }
        }
    }
}