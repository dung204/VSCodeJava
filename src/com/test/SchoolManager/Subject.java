package com.test.SchoolManager;

public enum Subject {
  MATH,
  PHYSICS,
  CHEMISTRY,
  BIOLOGY,
  IT,
  LITERATURE,
  HISTORY,
  GEOGRAPHY,
  ENGLISH,
  TECHNOLOGY,
  ND_EDUCATION, //National Defense Education
  CE, //Citezen Education
  PE; //Physical Education

  public static String generateTeacherId(Subject subject) {
    return new StringBuilder(subject.toString()).substring(0, 2);
  }
}
