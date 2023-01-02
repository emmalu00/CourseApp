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
        boolean number = false, name = false;
        boolean first = false, last = false, user = false;
        boolean bookTitle = false, bookAuthor = false, cost = false;

        do
        {        
            while(!number)
            {
                try {
                    System.out.print("Enter the course number: ");
                    courseNumber = s.nextLine();
                    if (courseNumber.equals(""))
                    {
                        throw(new Exception("Course number is required. Please re-enter."));
                    }
                    number = true;
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    number = false;
                }
            }

            while(!name)
            {
                try {
                    System.out.print("Enter the course name: ");
                    courseName = s.nextLine();
                    if (courseName.equals(""))
                    {
                        throw(new Exception("Course name is required. Please re-enter."));
                    }
                    name = true;
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    name = false;
                }

            }

            while(!first)
            {
                try 
                {
                    System.out.print("Enter the instructor's first name: ");
                    firstName = s.nextLine();
                    if (firstName.equals(""))
                    {
                        throw(new Exception("Instructor first name is required. Please re-enter."));
                    }
                    first = true;
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    first = false;
                }
            }

            while(!last)
            {
                try
                {
                    System.out.print("Enter the instructor's last name: ");
                    lastName = s.nextLine();
                    if (lastName.equals(""))
                    {
                        throw(new Exception("Instructor last name is required. Please re-enter."));
                    }
                    last = true;
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    last = false;
                }
            }

            while(!user)
            {
                try {
                    System.out.print("Enter the instructor's username: ");
                    userName = s.nextLine();
                    if (userName.equals(""))
                    {
                        throw(new Exception("Instructor username is required. Please re-enter."));
                    }
                    user = true;
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    user = false;
                }
            }

            while(!bookTitle)
            {
                try {
                    System.out.print("Enter the textbook's title: ");
                    title = s.nextLine();
                    if (title.equals(""))
                    {
                        throw(new Exception("Textbook title is required. Please re-enter."));
                    }
                    bookTitle = true;
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    bookTitle = false;
                }
            }

            while(!bookAuthor)
            {
                try {
                    System.out.print("Enter the textbook's author: ");
                    author = s.nextLine();
                    if (author.equals(""))
                    {
                        throw(new Exception("Textbook author is required. Please re-enter."));
                    }
                    bookAuthor = true;
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    bookAuthor = false;
                }
            }

            while(!cost)
            {
                try {
                System.out.print("Enter the textbook's price: ");
                price = Double.parseDouble(s.nextLine());
                cost = true;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Must enter numerical input only.");
                    cost = false;
                }
            }
            Instructor instructor = new Instructor(firstName, lastName, userName);
            TextBook textbook = new TextBook(title, author, price);
            Course newCourse = new Course(courseNumber, courseName, instructor, textbook);
            course.add(newCourse);
            System.out.println("\nCourse added to the array list...");
            System.out.print("Enter another course? (y/n): ");
            reply = s.nextLine().toLowerCase().charAt(0);
            System.out.println();

            if (reply == 'y')
            {
                number = false;
                name = false;
                first = false;
                last = false;
                user = false;
                bookTitle = false;
                bookAuthor = false;
                cost = false;
            }
        } while (reply == 'y');

        for (int i = 0; i < course.size(); ++i)
        {
            System.out.println(course.get(i).toString());
            boolean valid = false;

            while (!valid)
            {
                System.out.print("Enter the % markup of the textbook as a whole number: ");
                String response = s.nextLine();
                if (response.equals(""))
                {
                    double retail = course.get(i).getTextBook().calcRetailPrice();
                    System.out.printf("Retail Price: $%.2f\n\n", retail);
                    valid = true;
                }
                else if (response.matches("\\d+"))
                {
                    int markup = Integer.parseInt(response);
                    double retail = course.get(i).getTextBook().calcRetailPrice(markup);
                    System.out.printf("Retail Price: $%.2f\n\n", retail);
                    valid = (retail >= 0 && retail <= 100);
                }
                else
                {
                    System.out.println("Not a valid number.");
                } 
            }
        }

        boolean found = false;
        while (!found)
        {
            System.out.print("Enter a course number to delete: ");
            String newCourseNumber = s.nextLine().toUpperCase();
            for (int i = 0; i < course.size(); ++i)
            {
                if (course.get(i).getNumber().toUpperCase().equals(newCourseNumber))
                {
                    course.remove(i);
                    found = true;
                    System.out.println("Removing item array list...\n");
                }
            }
            if (!found)
            {
                System.out.println("Course number not found in the array list.");
            }
        }
        
        number = false;
        name = false;
        first = false;
        last = false;
        user = false;
        bookTitle = false;
        bookAuthor = false;
        cost = false;      
        System.out.println("Enter one more course to add to the array list.");
      
        while(!number)
        {
            try {
                System.out.print("Enter the course number: ");
                courseNumber = s.nextLine();
                if (courseNumber.equals(""))
                {
                    throw(new Exception("Course number is required. Please re-enter."));
                }
                number = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                number = false;
            }
        }

        while(!name)
        {
            try {
                System.out.print("Enter the course name: ");
                courseName = s.nextLine();
                if (courseName.equals(""))
                {
                    throw(new Exception("Course name is required. Please re-enter."));
                }
                name = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                name = false;
            }

        }

        while(!first)
        {
            try 
            {
                System.out.print("Enter the instructor's first name: ");
                firstName = s.nextLine();
                if (firstName.equals(""))
                {
                    throw(new Exception("Instructor first name is required. Please re-enter."));
                }
                first = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                first = false;
            }
        }

        while(!last)
        {
            try
            {
                System.out.print("Enter the instructor's last name: ");
                lastName = s.nextLine();
                if (lastName.equals(""))
                {
                    throw(new Exception("Instructor last name is required. Please re-enter."));
                }
                last = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                last = false;
            }
        }

        while(!user)
        {
            try {
                System.out.print("Enter the instructor's username: ");
                userName = s.nextLine();
                if (userName.equals(""))
                {
                    throw(new Exception("Instructor username is required. Please re-enter."));
                }
                user = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                user = false;
            }
        }

        while(!bookTitle)
        {
            try {
                System.out.print("Enter the textbook's title: ");
                title = s.nextLine();
                if (title.equals(""))
                {
                    throw(new Exception("Textbook title is required. Please re-enter."));
                }
                bookTitle = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                bookTitle = false;
            }
        }

        while(!bookAuthor)
        {
            try {
                System.out.print("Enter the textbook's author: ");
                author = s.nextLine();
                if (author.equals(""))
                {
                    throw(new Exception("Textbook author is required. Please re-enter."));
                }
                bookAuthor = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                bookAuthor = false;
            }
        }

        while(!cost)
        {
            try {
            System.out.print("Enter the textbook's price: ");
            price = Double.parseDouble(s.nextLine());
            cost = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Must enter numerical input only.");
                cost = false;
            }
        }
        Instructor instructor = new Instructor(firstName, lastName, userName);
        TextBook textbook = new TextBook(title, author, price);
        Course newCourse = new Course(courseNumber, courseName, instructor, textbook);
        course.set(0, newCourse);
        System.out.println("\nCourse added to the beginning of the array list...");

        for (int i = 0; i < course.size(); ++i)
        {
            System.out.println(course.get(i).toString());
        }
    }
}