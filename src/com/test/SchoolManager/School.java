package com.test.SchoolManager;

import java.util.ArrayList;
import java.util.List;

public class School {
  private String schoolName;
  private final List<Classroom> classrooms;
  private final List<Teacher> teachers;

  public School() {
    this.schoolName = null;
    classrooms = new ArrayList<>();
    teachers = new ArrayList<>();
  }

  public School(String schoolName) {
    this.schoolName = schoolName;
    classrooms = new ArrayList<>();
    teachers = new ArrayList<>();
  }


  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }

  public String getSchoolName() {
    return this.schoolName;
  }

  public List<Classroom> getClassrooms() {
    return this.classrooms;
  }

  public int getTotalNumberOfStudents() {
    int total = 0;
    for(Classroom classroom : classrooms) {
      total += classroom.getNumberOfStudents();
    }
    return total;
  }

  public List<Teacher> getTeachers() {
    return this.teachers;
  }

  public Classroom findClassroomByName(String classroomName) {
    return classrooms.stream().filter(classroom -> classroom.getClassroomName().equals(classroomName))
      .findFirst().orElse(null);
  }

  public boolean addClassroom(String newClassroomName) {
    Classroom duplicate = findClassroomByName(newClassroomName);
    
    if(duplicate != null) return false;
    return classrooms.add(new Classroom(newClassroomName));
  }

  public boolean addStudentToClassroom(Student newStudent, String classroomName) {
    Classroom found = findClassroomByName(classroomName);
    
    if(found == null) return false;
    return found.addStudent(newStudent);
  }

  public int addTeachersToClassrooms(Teacher newTeacher, String... classroomNames) {
    int countAdded = 0; //Number of available classrooms where new teacher works
    for(String classroomName : classroomNames) {
      Classroom found = findClassroomByName(classroomName);
      
      if(found == null) continue;
      found.addTeacher(newTeacher);
      countAdded++;  
    }
    return countAdded;
  }

  @Override
  public String toString() {
    return "School name: " + schoolName + "\n" +
           "Number of classrooms: " + classrooms.size() + "\n" +
           "Total number of students: " + getTotalNumberOfStudents() + "\n" +
           "Number of teachers: " + teachers.size() + "\n";
  }
}