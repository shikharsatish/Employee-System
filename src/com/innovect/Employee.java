package com.innovect;

import com.innovect.PersonalDetails.Address;
import com.innovect.PersonalDetails.PersonalInfo;

public class Employee {
  String id;
  PersonalInfo personalInfo;
  Address address;
  PersonalInfo otherinfo;

  public String getId() {
    return id;
  }
  public PersonalInfo getPersonalInfo() {
    return personalInfo;
  }

  public Address getAddress() {
    return address;
  }

  public PersonalInfo getOtherinfo() {
    return otherinfo;
  }

  public Employee(PersonalInfo personalInfo, Address address, PersonalInfo otherinfo, String id) {
    this.personalInfo = personalInfo;
    this.address = address;
    this.otherinfo = otherinfo;
    this.id = id;
  }

  @Override
  public String toString() {
    return "Id : " + this.id + "\nAddress : " + this.address + "\notherInfo:" + otherinfo;
  }
}
