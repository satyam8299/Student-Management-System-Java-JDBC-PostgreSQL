
	package com.sms;

	import java.util.Scanner;

	public class MainApp{

	    public static void main(String[] args) {

	        StudentDAO dao = new StudentDAO();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n===== Student Management System =====");
	            System.out.println("1. Add Student");
	            System.out.println("2. View Students");
	            System.out.println("3. Search Student");
	            System.out.println("4. Update Student");
	            System.out.println("5. Delete Student");
	            System.out.println("6. Exit");
	            System.out.print("Enter choice: ");

	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Name: ");
	                    sc.nextLine();
	                    String name = sc.nextLine();

	                    System.out.print("Email: ");
	                    String email = sc.nextLine();

	                    System.out.print("Course: ");
	                    String course = sc.nextLine();

	                    dao.addStudent(new Student(name, email, course));
	                    break;

	                case 2:
	                    dao.viewStudents();
	                    break;

	                case 3:
	                    System.out.print("Enter ID: ");
	                    dao.searchStudent(sc.nextInt());
	                    break;

	                case 4:
	                    System.out.print("Enter ID: ");
	                    int id = sc.nextInt();
	                    System.out.print("New Course: ");
	                    sc.nextLine();
	                    dao.updateStudent(id, sc.nextLine());
	                    break;

	                case 5:
	                    System.out.print("Enter ID: ");
	                    dao.deleteStudent(sc.nextInt());
	                    break;

	                case 6:
	                    System.out.println("🙏 Thank You");
	                    System.exit(0);
	            }
	        }
	    }
	}

