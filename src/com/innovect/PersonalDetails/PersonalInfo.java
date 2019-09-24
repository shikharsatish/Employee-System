package com.innovect.PersonalDetails;

import java.util.*;

public class PersonalInfo {
  private String firstName;
  private String middleName;
  private String lastName;
  private Date dob;
  private String email;
  private String phone;
  private String designation;
  private String department;
  private String salary;


  public PersonalInfo(Date dob, String email, String phone, String designation, String department, String salary) {
    this.dob = dob;
    this.email = email;
    this.phone = phone;
    this.designation = designation;
    this.department = department;
    this.salary = salary;
  }

  public PersonalInfo(){}

  public PersonalInfo(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "\nDate of birth" + dob + "\nemail" + email + "\nphone" + phone + "\ndesignation" + designation +"\ndepartment" + department + "\nsalary" + salary;
  }
}
