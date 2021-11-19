package com.test.SchoolManager;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
  private String classroomName;
  private final List<Student> students;
  private final List<Teacher> teachers;

  public Classroom(String classroomName) {
    this.classroomName = classroomName;
    students = new ArrayList<>();
    teachers = new ArrayList<>();
  }

  public String getClassroomName() {
    return this.classroomName;
  }

  public List<Student> getStudents() {
    return this.students;
  }


  public List<Teacher> getTeachers() {
    return this.teachers;
  }

  public int getNumberOfStudents() {
    return this.students.size();
  }

  public boolean addStudent(Student newStudent) {
    return students.add(newStudent);
  }

  public Student findStudentById(String id) {
    return this.students.stream().filter(student -> student.getStudentId().equals(id))
      .findFirst().orElse(null);
  }

  public boolean deleteStudentById(String id) {
    Student found = findStudentById(id);
    return students.remove(found);
  }

  public boolean addTeacher(Teacher newTeacher) {
    return teachers.add(newTeacher);
  }

  public boolean deleteTeacherById(String id) {
    Teacher found = teachers.stream()
      .filter(teacher -> teacher.getTeacherId().equals(id)).findFirst().orElse(null);
    return teachers.remove(found);
  }

  @Override
  public String toString() {
    return "Classroom name: " + classroomName + "\n" +
           "Number of students: " + students.size() + "\n";
  }
}
