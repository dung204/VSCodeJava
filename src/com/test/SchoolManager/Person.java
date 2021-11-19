package com.test.SchoolManager;

public class Person {
  private String name;
  private int age;
  private String address;
  private Gender gender;

  public Person(String name, int age, String address, Gender gender) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.gender = gender;
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

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Gender getGender() {
    return this.gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "Tên: " + name + "\n" +
           "Tuổi: " + age + "\n" +
           "Giới tính: " + (gender.equals(Gender.MALE) ? "Nam" : "Nữ") + "\n" +
           "Địa chỉ: " + address + "\n";
  }
}
