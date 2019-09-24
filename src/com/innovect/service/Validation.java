package com.innovect.service;

import java.util.Date;
import java.util.regex.*;
import java.text.SimpleDateFormat;

public class Validation {
  static public boolean isNotNull;
  static boolean mobile;
  static boolean mail;

  static String validFirstName(String firstName) {
    if (!(firstName.isEmpty())) {
      return firstName;
    } else
      return null;
  }

  static String validLastName(String lastName) {
    if (!(lastName.isEmpty())) {
      return lastName;
    } else
      return null;
  }

  static String validPhone(String phone) {
    String num = phone;
    String regexStr = "^[0-9]{10}$";
    if (Pattern.matches(regexStr, phone))
      return num;
    else
      return null;
  }

  static Date valDate(String dob) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date bod = null;
    sdf.setLenient(false);
    try {
      bod = sdf.parse(dob);
      return bod;
    } catch (Exception e) {
      return null;
    }
  }

  static String validEmail(String email) {

    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
        "[a-zA-Z0-9_+&*-]+)*@" +
        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
        "A-Z]{2,7}$";
    if (Pattern.matches(emailRegex, email))
      return email;
    else
      return null;
  }
}
