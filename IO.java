/**
* IO.java
* Emma Lucas
* This class handles all input and output of the program.
*/

import java.util.*;

public class IO {
    Scanner s;
    boolean valid;
    String courseNumber, courseName;
    String firstName, lastName, userName; 
    String title, author;
    double price;

    public IO()
    {
        s = new Scanner(System.in);
        valid = false;
        courseNumber = "";
        courseName = "";
        firstName = "";
        lastName = "";
        userName = "";
        title = "";
        author = "";
        price = 0.0;
    }

    /**
    This method gets the course number.
    @returns course number entered by user
   */
    public String getCourseNum()
    {
        valid = false;
        while(!valid)
        {
            try {
                System.out.print("Enter the course number: ");
                courseNumber = s.nextLine();
                if (courseNumber.equals(""))
                {
                    throw(new Exception("Course number is required. Please re-enter."));
                }
                valid = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                valid = false;
            }
        }
        return courseNumber;
    }

    /**
    This method gets the course name.
    @returns course name entered by user
   */
    public String getCourseName()
    {
        valid = false;
        while(!valid)
        {
            try {
                System.out.print("Enter the course name: ");
                courseName = s.nextLine();
                if (courseName.equals(""))
                {
                    throw(new Exception("Course name is required. Please re-enter."));
                }
                valid = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                valid = false;
            }

        }
        return courseName;
    }

    /**
    This method gets the instructor's first name.
    @returns instructor's first name entered by user
   */
    public String getFirstName()
    {
        valid = false;
        while(!valid)
        {
            try 
            {
                System.out.print("Enter the instructor's first name: ");
                firstName = s.nextLine();
                if (firstName.equals(""))
                {
                    throw(new Exception("Instructor first name is required. Please re-enter."));
                }
                valid = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                valid = false;
            }
        }
        return firstName;
    }

    /**
    This method gets the instructor's last name.
    @returns instructor's last name entered by user
   */
    public String getLastName()
    {
        valid = false;
        while(!valid)
        {
            try
            {
                System.out.print("Enter the instructor's last name: ");
                lastName = s.nextLine();
                if (lastName.equals(""))
                {
                    throw(new Exception("Instructor last name is required. Please re-enter."));
                }
                valid = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                valid = false;
            }
        }
        return lastName;
    }

    /**
    This method gets the instructor's username.
    @returns instructor's username entered by user
   */
    public String getUsername()
    {
        valid = false;
        while(!valid)
        {
            try {
                System.out.print("Enter the instructor's username: ");
                userName = s.nextLine();
                if (userName.equals(""))
                {
                    throw(new Exception("Instructor username is required. Please re-enter."));
                }
                valid = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                valid = false;
            }
        }
        return userName;
    }

    /**
    This method gets the textbooks's title.
    @returns textbooks's title entered by user
   */
    public String getTitle()
    {
        valid = false;
        while(!valid)
        {
            try {
                System.out.print("Enter the textbook's title: ");
                title = s.nextLine();
                if (title.equals(""))
                {
                    throw(new Exception("Textbook title is required. Please re-enter."));
                }
                valid = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                valid = false;
            }
        }
        return title;
    }

    /**
    This method gets the textbooks's author.
    @returns textbooks's author entered by user
   */
    public String getAuthor()
    {
        valid = false;
        while(!valid)
        {
            try {
                System.out.print("Enter the textbook's author: ");
                author = s.nextLine();
                if (author.equals(""))
                {
                    throw(new Exception("Textbook author is required. Please re-enter."));
                }
                valid = true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                valid = false;
            }
        }
        return author;
    }

    /**
    This method gets the textbooks's price.
    @returns textbooks's price entered by user
   */
    public double getPrice()
    {
        valid = false;
        while(!valid)
        {
            try {
            System.out.print("Enter the textbook's price: ");
            price = Double.parseDouble(s.nextLine());
            valid = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Must enter numerical input only.");
                valid = false;
            }
        }
        return price;
    }

    /**
    This method asks the user if they want to add another course.
    @returns response entered by user
   */
    public char addAnother()
    {
        char reply;
        System.out.println("\nCourse added to the array list...");
        System.out.print("Enter another course? (y/n): ");
        reply = s.nextLine().toLowerCase().charAt(0);
        return reply;
    }

    /**
    This method gets the retail markup of a textbook.
    @param c Course object
   */
    private void getRetail(Course c)
    {
        valid = false;
        while (!valid)
        {
            System.out.print("Enter the % markup of the textbook as a whole number: ");
            String response = s.nextLine();
            if (response.equals(""))
            {
                double retail = c.getTextBook().calcRetailPrice();
                System.out.printf("Retail Price: $%.2f\n\n", retail);
                valid = true;
            }
            else if (response.matches("\\d+"))
            {
                int markup = Integer.parseInt(response);
                double retail = c.getTextBook().calcRetailPrice(markup);
                System.out.printf("Retail Price: $%.2f\n\n", retail);
                valid = (retail >= 0 && retail <= 100);
            }
            else
            {
                System.out.println("Not a valid number.");
            } 
        }
    }

    /**
    This method deletes a course from the array list.
    @param list list of Course objects
   */
    public void delCourse(ArrayList<Course> list)
    {
        boolean found = false;
        while (!found)
        {
            System.out.print("Enter a course number to delete: ");
            String newCourseNumber = s.nextLine().toUpperCase();
            for (int i = 0; i < list.size(); ++i)
            {
                if (list.get(i).getNumber().toUpperCase().equals(newCourseNumber))
                {
                    list.remove(i);
                    found = true;
                    System.out.println("Removing item array list...\n");
                }
            }
            if (!found)
            {
                System.out.println("Course number not found in the array list.");
            }
        }
    }

    /**
    This method adds a new course to the beginning of the list.
    @returns new Course object
   */
    public Course addNewCourse()
    {
        System.out.println("Enter one more course to add to the array list.");
        courseNumber = getCourseNum();
        courseName = getCourseName();
        firstName = getFirstName();
        lastName = getLastName();
        userName = getUsername();
        title = getTitle();
        author = getAuthor();
        price = getPrice();    
        Instructor instructor = new Instructor(firstName, lastName, userName);
        TextBook textbook = new TextBook(title, author, price);
        Course newCourse = new Course(courseNumber, courseName, instructor, textbook);  
        System.out.println("\nCourse added to the beginning of the array list...");
        return newCourse;  
    }

    /**
    This method displays the courses and their info.
    @param list list of Course objects
   */
    public void displayResults(ArrayList<Course> list)
    {
        for (int i = 0; i < list.size(); ++i)
        {
            System.out.println(list.get(i).toString());
        }
    }

    /**
    This method displays the courses and their info while asking for textbook retail markup.
    @param list list of Course objects
   */
    public void displayAndRetail(ArrayList<Course> list)
    {
        for (int i = 0; i < list.size(); ++i)
        {
            System.out.println(list.get(i).toString());
            getRetail(list.get(i));
        }
    }
}