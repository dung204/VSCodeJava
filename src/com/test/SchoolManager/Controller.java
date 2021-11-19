package com.test.SchoolManager;

import java.io.IOException;
import java.util.Scanner;

import com.test.util.Utilities;

public class Controller {
  static School school = new School(null);
  static Scanner scan = new Scanner(System.in);

  public Controller() throws InterruptedException, IOException {
    while(true) {
      if(school.getSchoolName() == null)
        setNewSchoolName();
      showMenu();
      handleMenu(); 
    }   
  }

  public void setNewSchoolName() throws InterruptedException, IOException {
    Utilities.clearScreen();
    System.out.print("Nhập tên cho trường học mới để tiếp tục: ");
    String newSchoolName = scan.nextLine();
    school.setSchoolName(newSchoolName);
    System.out.printf("Tên trường đã được thay đổi thành công: %s\n", newSchoolName);
    System.out.print("Nhấn enter để tiếp tục...");
    Utilities.pauseScreen(scan);
  }

  public void showMenu() throws InterruptedException, IOException {
    Utilities.clearScreen();
    System.out.println("===================QUẢN LÝ TRƯỜNG HỌC===================");
    System.out.println("1. Quản lý lớp học");
    System.out.println("2. Quản lý giáo viên");
    System.out.println("3. Hiển thị thông tin trường học");
    System.out.println("4. Thay đổi tên trường học");
    System.out.println("0. Thoát");
    System.out.print("Lựa chọn của bạn là: ");
  }

  public void handleMenu() throws InterruptedException, IOException {
    switch(Integer.parseInt(scan.nextLine())) {
      case 0:
        exit();
        break;
      case 1:
        new ClassroomController();
        break;
      case 2:
        // TODO: new TeacherController here 
        break;
      case 3:
        Utilities.clearScreen();
        System.out.println(school.toString());
        System.out.print("Nhấn enter để tiếp tục...");
        Utilities.pauseScreen(scan);
        break;
      case 4:
        setNewSchoolName();
        break;
    }
  }

  public void exit() {
    System.out.println("Goodbye!!");
    scan.close();
    System.exit(0);
  }
}
