package com.test.TeacherManager;

import java.util.ArrayList;
import java.util.List;

public class TeacherManager {
  private List<Teacher> teachers;

  public TeacherManager() {
    teachers = new ArrayList<>();
  }

  public List<Teacher> getTeachers() {
    return teachers;
  }

  public Teacher findTeacherById(String id) {
    return teachers.stream().filter(teacher -> teacher.getId().equals(id)).findFirst().orElse(null);
  }

  public boolean addTeacher(Teacher newTeacher) {
    if(newTeacher == null) return false;
    
    Teacher existedIdTeacher = findTeacherById(newTeacher.getId());
    if(existedIdTeacher != null) return false;

    return teachers.add(newTeacher); //true
  }

  public boolean deleteTeacherById(String id) {
    Teacher found = findTeacherById(id);
    return teachers.remove(found); //true if teacher found in the list, or else false
  }

  public void listTeachers() {
    System.out.printf("%-5s %-25s %-4s %-25s %-15s %-15s %-15s\n", "ID", "Name", "Age", "Hometown", 
      "Initial Salary", "Bonus Salary", "Fine Salary");
    teachers.forEach(teacher -> System.out.printf("%-5s %-25s %-4s %-25s %-15s %-15s %-15s\n", teacher.getId(), 
    teacher.getName(), teacher.getAge(), teacher.getHometown(), teacher.getInitialSalary(), 
    teacher.getBonusSalary(), teacher.getFineSalary()));
  }

  public String calculateSalary() {
    StringBuilder result = new StringBuilder("");
    teachers.forEach(teacher -> {
      double realSalary = teacher.getInitialSalary() + teacher.getBonusSalary() 
        - teacher.getFineSalary();
      result.append(teacher.getName() + "(" + teacher.getId() + ")" + ": " + realSalary + "\n");
    });
    return result.toString();
  }
}
