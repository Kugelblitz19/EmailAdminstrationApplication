package emailApp;

import java.util.Scanner;

public class Email {
    private final String firstName;
    private final String lastName;
    private String password;
    private final String department;
    private String email;
    private int mailBoxCapacity=500;
    private int defaultPasswordLength=10;
    private String alternateEmail;
    private String companySuffix ="aeycompany.com";

    //constructor to receive the first name and last name;
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created: " + this.firstName + " " + this.lastName);

        //call the method asking for the department- return the department
        this.department = setDepartment();
      //  System.out.println("Department: " + this.department);
        //call a method that returns a random password
      this.password=randomPassword(defaultPasswordLength);
      System.out.println("Your Password is: " + this.password);
      //combine element to generate email
        email =firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    //    System.out.println("Your Email is: " + email);
    }
    //Ask for department

    private String setDepartment() {
        System.out.print("New Worker: " + firstName + ". Department Codes:\n1 for sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Department code:");
        Scanner sc = new Scanner(System.in);
        int depChoice = sc.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "accounting";

        } else {
            return "";
        }
    }

    //Generate a random password
private String randomPassword(int length){
      String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@$%";
      char[] password= new char[length];
      for(int i=0;i<length;i++){
       int random= (int) (Math.random() * passwordSet.length());
       password[i] =passwordSet.charAt(random);
      }
      return new String(password);
}
    //set the mailbox capacity
public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity=capacity;

}
    //set the alternate mail
    public void setAlternateEmail(String altEmail){
        this.alternateEmail=altEmail;
    }
    //change the password
public void changePassword(String password){
        this.password=password;
}
   public  int getMailBoxCapacity(){
        return mailBoxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
public String getPassword(){
        return password;
}
public String showInfo(){
        return "Display Name: " + firstName + "-" + lastName + "\nCompany Email: " + email +
                " \nMailBox Capacity: " + mailBoxCapacity + "mb";
}

}
