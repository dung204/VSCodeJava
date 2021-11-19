package com.test.SchoolManager;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.test.util.Utilities;

public class ClassroomController {
  private School school = Controller.school;
  private Scanner scan = Controller.scan;
  private List<Classroom> classrooms = Controller.school.getClassrooms();
  private Classroom selectedClassroom = null;
  private int option;

  public ClassroomController() throws InterruptedException, IOException {
    do {
      showMenu();
      option = Integer.parseInt(scan.nextLine());
      handleMenu(option);
    } while(option != 0);
  }

  public void showMenu() throws InterruptedException, IOException {
    Utilities.clearScreen();
    System.out.println("1. Liệt kê các lớp hiện có");
    System.out.println("2. Chọn lớp (mở khóa thêm tính năng)");
    if(selectedClassroom != null) {
      System.out.println("3. Hiển thị thông tin lớp học đang chọn");
      System.out.println("4. Hiển thị danh sách học sinh của lớp đang chọn");
      System.out.println("5. Hiển thị điểm của một học sinh");
      System.out.println("6. Hiển thị danh sách giáo viên của lớp đang chọn");
    }
    System.out.println("0. Quay lại");
    System.out.println("Lựa chọn của bạn là:");
  }

  public void handleMenu(int option) throws InterruptedException, IOException {
    switch(option) {
      case 0:
        break;
      case 1:
        showAllClassrooms();
        break;
      case 2:
        getSelectedClassrooms();
        break;
      case 3:
        System.out.println(selectedClassroom.toString());
        break;
      case 4:
        showAllStudents();
        break;
      case 5:
        showOneStudentScore();
        break;
      case 6:
        
        break;
      default:
        break;
    }
  }

  public void checkSelectedClassroom() {
    if(selectedClassroom == null)
      System.out.println("Invalid option");
  }

  public void showAllClassrooms() throws InterruptedException, IOException {
    Utilities.clearScreen();
    classrooms.forEach(classroom -> System.out.println(classroom.toString()));
    System.out.print("Nhấn enter để tiếp tục...");
    Utilities.pauseScreen(scan);
  }

  public void getSelectedClassrooms() throws InterruptedException, IOException {
    Utilities.clearScreen();
    String classroomName = scan.nextLine();
    Classroom found = this.school.findClassroomByName(classroomName);
    
    if(found == null) {
      System.out.println("Lớp không tồn tại");
    }
    this.selectedClassroom = found;
    System.out.printf("Đã chọn lớp thành công: %s", found.getClassroomName());
    System.out.print("Nhấn enter để tiếp tục...");
    Utilities.pauseScreen(scan);
  }

  public void showAllStudents() throws InterruptedException, IOException {
    Utilities.clearScreen();
    List<Student> studentList = selectedClassroom.getStudents();
    int count = 1;
    for(Student student : studentList) {
      System.out.printf("%d. %s (ID: %s)\n", count++, student.getName(), student.getStudentId());
    }
    System.out.print("Nhấn enter để tiếp tục...");
    Utilities.pauseScreen(scan);
  }

  public void showOneStudentScore() throws InterruptedException, IOException {
    Utilities.clearScreen();
    System.out.printf("Nhập ID học sinh: ");
    String id = scan.nextLine();
    Student found = selectedClassroom.findStudentById(id);
    System.out.println(
      "ID: " + found.getStudentId() + "\n" +
      "Name: " + found.getName() + "\n"
    );
    found.getScores().forEach(score -> System.out.println(score.toString()));
    System.out.print("Nhấn enter để tiếp tục...");
    Utilities.pauseScreen(scan);
  }
}
