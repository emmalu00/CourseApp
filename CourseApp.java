/**
* CourseApp.java
* Emma Lucas
* This class creates an array list of Course objects. The user can add as many courses as they
* wish to the array list. Once the user is finished adding course to the list, the program 
* displays information for each course, asking the user to enter the textbook markup for each
* course. The program finishes by asking the user to delete a course from the array list and add
* a new course to the beginning of the array list.
*/

import java.util.*;
import java.io.*;

public class CourseApp 
{
    public static void main(String[] args)
    {   
        ArrayList<Course> course = new ArrayList<Course>();
        Scanner s = new Scanner(System.in);
        char reply = 'y';
        String courseNumber = "", courseName = "";
        String firstName = "", lastName = "", userName = ""; 
        String title = "", author = "";
        double price = 0.0;
        IO io = new IO();
        //IO_GUI io = new IO_GUI();

        do
        {      
            courseNumber = io.getCourseNum();
            courseName = io.getCourseName();
            firstName = io.getFirstName();
            lastName = io.getLastName();
            userName = io.getUsername();
            title = io.getTitle();
            author = io.getAuthor();
            price = io.getPrice();
            Instructor instructor = new Instructor(firstName, lastName, userName);
            TextBook textbook = new TextBook(title, author, price);
            Course newCourse = new Course(courseNumber, courseName, instructor, textbook);
            course.add(newCourse);
            reply = io.addAnother();
            System.out.println();
        } while (reply == 'y');

        io.displayAndRetail(course);
        io.delCourse(course);
        
        Course newCourse = io.addNewCourse();
        course.set(0, newCourse);

        io.displayResults(course);
    }
}