package com.test.TeacherManager;

public class Teacher {
  private final String id;
  private String name;
  private int age;
  private String hometown;
  private double initialSalary;
  private double bonusSalary;
  private double fineSalary;


  public Teacher(String id, String name, int age, String hometown, double initialSalary, 
  double bonusSalary, double fineSalary) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.hometown = hometown;
    this.initialSalary = initialSalary;
    this.bonusSalary = bonusSalary;
    this.fineSalary = fineSalary;
  }


  public String getId() {
    return this.id;
  }


  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getHometown() {
    return this.hometown;
  }

  public void setHometown(String hometown) {
    this.hometown = hometown;
  }

  public double getInitialSalary() {
    return this.initialSalary;
  }

  public void setInitialSalary(double initialSalary) {
    this.initialSalary = initialSalary;
  }

  public double getBonusSalary() {
    return this.bonusSalary;
  }

  public void setBonusSalary(double bonusSalary) {
    this.bonusSalary = bonusSalary;
  }

  public double getFineSalary() {
    return this.fineSalary;
  }

  public void setFineSalary(double fineSalary) {
    this.fineSalary = fineSalary;
  }


  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", age='" + getAge() + "'" +
      ", hometown='" + getHometown() + "'" +
      ", initialSalary='" + getInitialSalary() + "'" +
      ", bonusSalary='" + getBonusSalary() + "'" +
      ", fineSalary='" + getFineSalary() + "'" +
      "}";
  }
}
