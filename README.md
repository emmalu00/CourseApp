# CourseApp Program
This program is an object-oriented program that utilizes MVC architecture. There are 6 classes in total. 

### Model
The **_Course_** class, **_Instructor_** class, and **_TextBook_** class all act as model classes. These three classes were already provided to me, and I only made slight modifications to them. The **_TextBook_** class stores all data about a textbook, including title, and price. The **_Instructor_** class stores all data about an instructor, including first name, last name, and username. The **_Course_** class stores all data about a course, including the course number, course name, textbook information, and instructor information. 

### View
The **_IO_** class and **_IO_GUI_** class function as the view for the program, and handle all of the input and output. Error handling is used to properly deal with any invalid input entries.
The **_IO_** class handles all input and output to the console. The **_IO_GUI_** class can be utilized to handle all input and output via a GUI. 

### Controller
The CourseApp class acted as the controller class. The CourseApp class creates an _ArrayList_ of Course objects. Using an _ArrayList_ allows the user to enter information for as many courses as they would like. First, the user is asked to enter the information for as many courses as they would like. All of the information for each course is stored into a Course object and added to the _ArrayList_. Next, the program then displays the information for each course, and asks the user to enter the retail markup for each textbook. Then, user is asked to enter a course to delete from the ArrayList. Finally, the user is asked to add one more course, which is added to the beginning of the ArrayList.
