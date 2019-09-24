package com.innovect.service;

import com.innovect.Employee;
import com.innovect.PersonalDetails.Address;
import com.innovect.PersonalDetails.PersonalInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

class CommonPeople {
  Scanner obj = new Scanner(System.in);

  public void eat() {
    System.out.println("normal thali");
  }

  public void talk() {

  }
}

class King extends CommonPeople {
  public void rule() {

  }

  public void decision() {

  }

  @Override
  public void eat() {
    System.out.println("chappan bhog");
  }
}

public class Demo {
  boolean isInput;
  Scanner obj = new Scanner(System.in);
  static ArrayList<Employee> data = new ArrayList();
  ArrayList deleted = new ArrayList();

 /* boolean validName(String name){
    do {
      System.out.println("Enter again:");
      if (obj.hasNext()) {
        isInput = true;
      } else {
        System.out.println("Please try again");
        isInput = false;
      }
    }while (!(isInput));
    return isInput;
  }*/

  void addEmployee() {
    obj.nextLine();
    System.out.println("Enter ID:");
    String id = obj.nextLine();
    String firstName = null;
     do {
       System.out.println("Enter your first name:");
       firstName = Validation.validFirstName(obj.nextLine());
     }    while(firstName == null);

      System.out.println("Enter your middle name:");
      String middleName = obj.nextLine();
    String lastName = null;
    do {
      System.out.println("Enter your last name:");
      lastName = Validation.validLastName(obj.nextLine());
    }    while(lastName == null);

    PersonalInfo personalInfo = new PersonalInfo(firstName, middleName, lastName);
    Date dob = null;
    do {
      System.out.println("Enter Date of Birth:");
      dob = Validation.valDate(obj.nextLine());
    }while(dob == null);
    String mail = null;
    do {
      System.out.println("Enter Email:");
      mail = Validation.validEmail(obj.nextLine());
    }while(mail == null);
    String phone = null;
    do {
      System.out.println("Enter Phone Number:");
      phone = Validation.validPhone(obj.nextLine());
    }while (phone == null);

    System.out.println("Enter Designation:");
    String designation = obj.nextLine();
    System.out.println("Enter Department:");
    String department = obj.nextLine();
    System.out.println("Enter Salary:");
    String salary = obj.nextLine();
    PersonalInfo otherInfo = new PersonalInfo(dob, mail, phone, designation, department, salary);
    System.out.println("Enter Address Line 1:");
    String addressLine1 = obj.nextLine();
    System.out.println("Enter Address Line 2:");
    String addressLine2 = obj.nextLine();
    System.out.println("Enter City:");
    String city = obj.nextLine();
    System.out.println("Enter State:");
    String state = obj.nextLine();
    System.out.println("Enter Country:");
    String country = obj.nextLine();
    Address address = new Address(addressLine1, addressLine2, city, state, country);
    Employee emp = new Employee(personalInfo, address, otherInfo, id);
    data.add(emp);
    System.out.println(emp);

  }

  void viewEmployee() {
    data.forEach(emp1 -> System.out.println(emp1));
  }

  void updateEmployee() {
    obj.nextLine();
    PersonalInfo personalInfo = new PersonalInfo();
    System.out.println("Enter user ID:");
    String id = obj.nextLine();
    Optional<Employee> matchingObject = data.stream().
        filter(p -> p.getId().equals(id)).
        findFirst();
    Employee matchedEmployee = matchingObject.get();
    if (matchedEmployee != null) {
      Address employeeAddress = matchedEmployee.getAddress();
      System.out.println(matchedEmployee);
      System.out.println("1. Update address line 1");
      System.out.println("2. Update address line 2");
      System.out.println("3. Update city");
      System.out.println("4. Update state");
      System.out.println("5. Update country");
      System.out.println("Choose the field to update:");
      Integer i = obj.nextInt();
      switch (i) {
        case 1:
          System.out.println("Enter address:");
          String address1 = obj.nextLine();
          employeeAddress.setAddressLine1(address1);
          break;
        case 2:
          System.out.println("Enter address:");
          String address2 = obj.nextLine();
          employeeAddress.setAddressLine2(address2);
          break;
        case 3:
          System.out.println("Enter city:");
          String city = obj.nextLine();
          employeeAddress.setCity(city);
          break;
        case 4:
          System.out.println("Enter State:");
          String state = obj.nextLine();
          employeeAddress.setState(state);
          break;
        case 5:
          obj.nextLine();
          System.out.println("Enter country:");
          String country = obj.nextLine();
          employeeAddress.setCountry(country);
          break;
        default:
          options();
          break;
      }
    }

  }

  void searchById() {
    obj.nextLine();
    System.out.println("Enter ID:");
    String id = obj.nextLine();
    for (Employee e : data) {
      if (id.equals(e.getId())) {
        System.out.println(e);
      }
    }
  }

  void remove() {
    obj.nextLine();
    System.out.println("Enter ID to remove data:");
    String id = obj.nextLine();
    for (Employee e : data) {
      deleted.add(e);
      data.remove(e);
    }
  }

  void veiwRemoved() {
    deleted.forEach(del -> System.out.println(del));
  }

  enum userchoice {
    EXIT, ADD, VIEW, UPDATE, SEARCH, REMOVE, VIEWALL;
  }

  void options() {
    System.out.println("\n1. Add Employee");
    System.out.println("2. View Employee");
    System.out.println("3. Update Employee");
    System.out.println("4. Search by Employee ID");
    System.out.println("5. Remove Employee");
    System.out.println("6. View all removed Employee");
    System.out.println("0. Exit");
    System.out.println("Enter Your Choice:");

    Integer choose = obj.nextInt();
    userchoice u = userchoice.values()[choose];
    switch (u) {
      case ADD:
        addEmployee();
        break;
      case VIEW:
        viewEmployee();
        break;
      case SEARCH:
        searchById();
        break;
      case REMOVE:
        remove();
        break;
      case VIEWALL:
        veiwRemoved();
        break;
      case UPDATE:
        updateEmployee();
        break;
      case EXIT:
        System.exit(0);
    }
  }

  public static void main(String[] args) {
    Demo d = new Demo();
    Validation validation = new Validation();
    boolean flag = true;
    Scanner obj = new Scanner(System.in);
    System.out.println("1. HOME");
    System.out.println("2. EXIT");
    System.out.println("Enter Your Choice:");
    final int HOME = 1;
    final int EXIT = 2;
    Integer main = obj.nextInt();
    while (flag) {
      switch (main) {
        case HOME:
          d.options();
          break;
        case EXIT:
          flag = false;
          System.exit(0);
      }
    }
  }

}
