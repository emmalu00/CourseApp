/**
 * @Original Author: Tony Gaddis
 * @Modified heavily by: Dennis Lang
 * 
 * Instructor.java
 * Class stores data about an instructor of a course which includes
 * the instructor's firstname, lastname, and username
*/

public class Instructor
{
   private String lastName;     // Last name   
   private String firstName;    // First name
   private String userName; 	// Username ID

   /**
      This constructor initializes the last name,
      first name, and user name.
      @param lname - The instructor's last name.
      @param fname - The instructor's first name.
      @param un - The instructor's user name.
   */
   public Instructor(String lname, String fname,
                     String un)
   {
      lastName = lname;
      firstName = fname;
      userName = un;
   }

   /**
      The copy constructor initializes the object
      as a copy of another Instructor object.
      @param object2 - The object to copy.
   */
   public Instructor(Instructor object2)
   {
      lastName = object2.lastName;
      firstName = object2.firstName;
      userName = object2.userName;
   }

   /**
      toString method returns the instructor informaiton
      @return str - A string containing instructor information.
   */
   public String toString()
   {
      // Create a string representing the object.
       //String str = "Last Name: " + lastName + "\nFirst Name: " + firstName;
       String str = (lastName + ", " + firstName + "\n" + userName.concat("@ksu.edu") + "\n");

      // Return the string.
      return str;
   }
}