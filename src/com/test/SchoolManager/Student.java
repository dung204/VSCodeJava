package com.test.SchoolManager;

import java.util.List;

public class Student extends Person {
  private static int count = 1;
  private final String studentId;
  private Classroom classroom;
  private final List<Score> scores;

  public Student(String name, int age, String address, Gender gender) {
    super(name, age, address, gender);
    this.studentId = "ST" + String.format("%03d", count++); //ST for student
    this.scores = Score.generateScores();
  }

  public void setClassroom(Classroom classroom) {
    this.classroom = classroom;
  }

  public Classroom getClassroom() {
    return this.classroom;
  }

  public String getStudentId() {
    return this.studentId;
  }

  public List<Score> getScores() {
    return this.scores;
  }

  @Override
  public String toString() {
    return super.toString() + 
           "Lớp: " + classroom.getClassroomName() + "\n";
  }

}
