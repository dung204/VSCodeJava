package com.test.SchoolManager;

public class Teacher extends Person {
  private static int count = 1;
  private final String teacherId;
  private final Subject teachingSubject;
  // private Classroom classroom;
  
  public Teacher(String name, int age, String address, Gender gender, Subject teachingSubject) {
    super(name, age, address, gender);
    this.teacherId = Subject.generateTeacherId(teachingSubject) + String.format("%03d", count++);
    this.teachingSubject = teachingSubject;
  }

  public String getTeacherId() {
    return this.teacherId;
  }

  public Subject getTeachingSubject() {
    return this.teachingSubject;
  }

  @Override
  public String toString() {
    return "{" +
      " name='" + getName() + "'" +
      ", age='" + getAge() + "'" +
      ", address='" + getAddress() + "'" +
      ", gender='" + getGender() + "'" +
      ", teachingSubject='" + teachingSubject + "'" +
      "}";
  }
}

