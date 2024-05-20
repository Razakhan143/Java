import java.util.Scanner;

class DirectoryStudent {
    private String ID;
    private String NAME;
    private String ADDRESS;
    private String PHONE_NUMBER;

    void setData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ENTER ID: ");
        ID = scanner.nextLine();
        System.out.print("ENTER NAME: ");
        NAME = scanner.nextLine();
        System.out.print("ENTER ADDRESS: ");
        ADDRESS = scanner.nextLine();
        System.out.print("ENTER PHONE NUMBER: ");
        PHONE_NUMBER = scanner.nextLine();
        System.out.println();
    }

    String getID() {
        return ID;
    }

    String getNAME() {
        return NAME;
    }

    String getADDRESS() {
        return ADDRESS;
    }

    String getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }
}

public class StudentsContactsOrganizer {
    static DirectoryStudent[] directoryStudents = new DirectoryStudent[10];
    static int count = 0;

    static Scanner scanner = new Scanner(System.in);

    static void mainMenu() {
        System.out.println("*********************************************************");
        System.out.println("         Students Contacts Organizer: MAIN MENU");
        System.out.println("*********************************************************");
        System.out.println();
        System.out.println("   1) Insert a new student");
        System.out.println("   2) Update an existing student");
        System.out.println("   3) Delete a record");
        System.out.println("   4) Search for a record");
        System.out.println("   5) List Directory");
        System.out.println("   0) EXIT\n");
        System.out.println("Enter your choice for the above mentioned menu (1, 2, 3, 4, 5 ,0)");
    }
    static void insertMenu() {
    print_function("Students Contacts Organizer: INSERT MENU");
    }

    static void insertStudent() {
        if (count < directoryStudents.length) {
            insertMenu();
            directoryStudents[count] = new DirectoryStudent();
            directoryStudents[count].setData();
            count++;
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Directory is full. Cannot add more students.");
        }
    }
    static void print_function(String heading){
        System.out.println("*********************************************************");
        System.out.println("         "+heading);
        System.out.println("*********************************************************");
        System.out.println();
    }
    static void updateStudent() {
        print_function("UPDATE STUDENT INFORMATION");
        System.out.print("Enter student ID to update: ");
        String idToUpdate = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (directoryStudents[i].getID().equals(idToUpdate)) {
                System.out.println("Enter new data for student:");
                directoryStudents[i].setData();
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + idToUpdate + " not found.");
        }
    }

    static void deleteStudent() {
        print_function("DELETE STUDENT INFORMATION");
        System.out.print("Enter student ID to delete: ");
        String idToDelete = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (directoryStudents[i].getID().equals(idToDelete)) {
                for (int j = i; j < count - 1; j++) {
                    directoryStudents[j] = directoryStudents[j + 1];
                }
                count--;
                System.out.println("Student deleted successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + idToDelete + " not found.");
        }
    }

    static void searchStudent() {
        print_function(" SEARCH FOR STUDENT");
        System.out.print("Enter student ID to search: ");
        String idToSearch = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (directoryStudents[i].getID().equals(idToSearch)) {
                System.out.println("Student found:");
                System.out.println("ID: " + directoryStudents[i].getID());
                System.out.println("Name: " + directoryStudents[i].getNAME());
                System.out.println("Address: " + directoryStudents[i].getADDRESS());
                System.out.println("Phone Number: " + directoryStudents[i].getPHONE_NUMBER());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + idToSearch + " not found.");
        }
    }

    static void listDirectory() {
        print_function("DATABASE FOR STUDENT CONTACTS");
        for (int i = 0; i < count; i++) {
            System.out.println("ID: " + directoryStudents[i].getID());
            System.out.println("Name: " + directoryStudents[i].getNAME());
            System.out.println("Address: " + directoryStudents[i].getADDRESS());
            System.out.println("Phone Number: " + directoryStudents[i].getPHONE_NUMBER());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int option;

        mainMenu();
        option = Integer.parseInt(scanner.nextLine());

        while (option != 0) {
            switch (option) {
                case 1:
                    insertStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    listDirectory();
                    break;
            }
            mainMenu();
            option = Integer.parseInt(scanner.nextLine());
        }
    }
}
