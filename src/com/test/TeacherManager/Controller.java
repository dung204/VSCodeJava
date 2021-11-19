package com.test.TeacherManager;

import java.util.Scanner;

public class Controller {
  private Scanner scan = new Scanner(System.in);
  private TeacherManager teacherManager = new TeacherManager();

  public Controller() {
    while(true) {
      showMenu();
      switch(receiveMenuInput()) {
        case 0: 
          exit();
          break;
        case 1:
          Teacher newTeacher = receiveTeacherInput();
          System.out.println((teacherManager.addTeacher(newTeacher) ? "Added successfully" 
            : "ID existed. Added failed."));
          break;
        case 2:
          String id = receiveIDInput();
          System.out.println((teacherManager.deleteTeacherById(id) ? "Delete successfully." 
            : "ID not found. Deleted failed."));
          break;
        case 3:
          teacherManager.listTeachers();
          break;
        case 4:
          System.out.println(teacherManager.calculateSalary());
          break;
        default:
          System.err.println("Invalid option. Try again.");
          break;
      }
    }
  }

  private void showMenu() {
    System.out.print(
      "------------------TEACHER MANAGER------------------\n" +
      "1. Add teacher\n" +
      "2. Delete teacher by ID\n" +
      "3. List all teachers\n" +
      "4. Calculate salary of each teacher\n" +
      "0. Exit\n" +
      "Your option is: "
    );
  }

  private int receiveMenuInput() {
    try {
      return Integer.parseInt(scan.nextLine().strip());
    } catch (NumberFormatException error) {
      return -1;
    }
  }

  private String receiveIDInput() {
    System.out.print("Enter ID: ");
    return scan.nextLine().strip();
  }

  private Teacher receiveTeacherInput() {
    try {
      System.out.print("ID: ");
      String id = scan.nextLine().strip();

      System.out.print("Name: ");
      String name = scan.nextLine().strip();

      System.out.print("Age: ");
      int age = Integer.parseInt(scan.nextLine().strip());

      System.out.print("Hometown: ");
      String hometown = scan.nextLine().strip();

      System.out.print("Initial salary: ");
      double initialSalary = Double.parseDouble(scan.nextLine().strip());

      System.out.print("Bonus salary: ");
      double bonusSalary = Double.parseDouble(scan.nextLine().strip().replace(',', '.'));

      System.out.print("Fine salary: ");
      double fineSalary = Double.parseDouble(scan.nextLine().strip());
      
      return new Teacher(id, name, age, hometown, initialSalary, bonusSalary, fineSalary);
    } catch (NumberFormatException error) {
      System.err.println("A number is required for this field (integer for age, " + 
        "decimal number for salaries (both comma and dot are allowed)).");
      return null;
    }
  }

  private void exit() {
    System.out.println("Goodbye!!");
    scan.close();
    System.exit(0);
  }
}
