/**
 * @Original Author: Tony Gaddis
 * @Modified heavily by: Dennis Lang
 * 
 * Textbook.java 
 * Class stores data about the textbook required for the course
 * which includes title, author and price.
*/


public class TextBook {
    private String title;    // Title of the book
    private String author;   // Author's last name
    private double price; 	// Wholesale cost of the book
 
    /**
       This constructor initializes the title,
       author, and price fields
       @param t - The book's title.
       @param a - The author's name.
       @param p - Wholesale cost.
    */
    public TextBook(String t, String a, double p) {
       title = t;
       author = a;
       price = p;
    }
 
    /**
       The copy constructor initializes the object
       as a copy of another TextBook object
       @param object2 - The object to copy
    */
    public TextBook(TextBook object2) {
       title = object2.title;
       author = object2.author;
       price = object2.price;
    }
 
     /**
       calcRetailPrice() calculates the retail price using the default markup of 25%
       @return price * 1.25 - the retail price of the textbook
    */
     public double calcRetailPrice() {
        return price * 1.25;
     }
     
     /**
       calcRetailPrice() 1-arg verison calculates the retail price of the passsed in markup
       @return price * (((double)percentMarkup / 100) + 1) - the retail price of the textbook
    */
    public double calcRetailPrice(int percentMarkup) {
        return price * (((double)percentMarkup / 100) + 1);
    }
    /**
       toString method returns the textbook informaiton
       @return str - a string containing textbook information
    */
    public String toString() {
       // Create a string representing the object.
       //String str = "Title: " + title + "\nAuthor: " + author + "\nWhole Sale Price: " + price;
        String str = (title + ", " + author + ", $" + price + "\n");
       // Return the string.
       return str;
    }
 }