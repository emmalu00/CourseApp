/**
 * @Original Author: Tony Gaddis
 * @Modified heavily by: Dennis Lang and Emma Lucas
 * 
 * Course.java
 * Class stores data about a course which includes course number
 * course name, instructor information (stored as an object) and
 * required textbook for the course information (stored as an object)
 *
*/

public class Course
{
   private String courseNumber;    // e.g. CIS 200
   private String courseName;      // e.g. Programming Fundamentals
   private Instructor instructor;  // Course instructor (object)
   private TextBook textBook;      // Required Course textbook (object)

   /**
      This constructor initializes the courseName,
      instructor, and text fields.
      @param number - The course number. 
      @param name - The name of the course.
      @param instr - An Instructor object.
      @param text - A TextBook object.
   */
   public Course(String number, String name, Instructor instr,
                 TextBook text)
   {
      // Assign the courseNumber.
      courseNumber = number;

      // Assign the courseName.
      courseName = name;

      // Create a new Instructor object, passing
      // instr as an argument to the copy constructor.
      instructor = new Instructor(instr);

      // Create a new TextBook object, passing
      // text as an argument to the copy constructor.
      textBook = new TextBook(text);
   }

   /**
      getName method gets the course name
      @return courseName - the name of the course
   */

   public String getName()
   {
      return courseName;
   }

   /**
      getNumber method gets the course number
      @return courseNumber - the number of the course
   */

   public String getNumber()
   {
      return courseNumber;
   }
   /**
      getInstructor method returns a copy of the instructor object
      @return new Instructor(instructor) - a reference to a copy 
      of this course's Instructor object
   */

   public Instructor getInstructor()
   {
      // Return a copy of the instructor object.
      return new Instructor(instructor);
   }

   /**
      getTextBook method returns a copy of the textBook object
      @return new TextBook(textBook) - a reference to a copy of 
      this course's TextBook object.
   */

   public TextBook getTextBook()
   {
      // Return a copy of the textBook object.
      return new TextBook(textBook);
   }

   /**
      toString method reuturns course information
      @return str - containing the course information
   */

   public String toString()
   {
      // Create a string representing the object.
      String str = (courseNumber + " " + courseName + "\n" + instructor + textBook);
          //"Course number: " + courseNumber + "\nCourse name: " + courseName + "\nInstructor Information:\n" + instructor + "\nTextbook Information:\n" + textBook;
    // String str = courseNumber + " " + courseName + "\n";

      // Return the string.
      return str;
   }
}
