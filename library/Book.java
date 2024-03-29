package library;

public class Book extends Library{ //-------------------------------------------------------------
// Assignment (1)
// Written by: (Hamed Vasheghani Farhani 40246686)
// -----------------------------------------------------------
    // the book class is a descendant of the library class. It is meant to be stored in a library array.
    // it contains the attributes of its parent class and adds the number of pages and a unique book ID
    // it also contains some setters and getters and equals methods to compare the objects and respect encapsulation
    private int numberOfPages; // creates an integer for the number of pages, private to respect encapsulation
    private String bookID; // creates a string for the book ID, private to respect encapsulation
    public Book(){ // default constructor for the book
        super(); // calls the default constructor of the library class
        numberOfPages = 0; // sets the number of pages to 0
        bookID = ""; // sets the book ID to an empty string
    }
    public Book (Book object) {// copy constructor of the book object
        super(object); // calls the copy constructor of the library class
        numberOfPages = object.numberOfPages; // sets the number of pages to the number of pages of the other book
        bookID = "B"+uniqueID(); // calls the unique ID method to give a unique identification number to the book
    }
    public Book clone(){ // clone method for the book object
        Book clone = new Book(this); // creates a new book object
        clone.setBookID(this.bookID); // sets the book ID of the new book object to the book ID of the original book object
        return clone; // returns a new book object with the same attributes as the original book object
    }
    public Book(String name, String authors, int yearOfPublication, int numberOfPages) { // constructor for the book object that initializes all the attributes of the class
        super(name, authors, yearOfPublication); // calls the constructor of the library class
        this.numberOfPages = numberOfPages; // sets the number of pages to the number of pages passed in
        bookID =  "B"+uniqueID();  // calls the unique ID method to give a unique identification number to the book
    }
// the following are the getters and setters for the attributes of the book object
    public int getNumberOfPages() { // getter method for the number of pages of the book object
        return numberOfPages; // returns the number of pages
    }
    public void setNumberOfPages(int numberOfPages) { // setter method for the number of pages of the book object
        this.numberOfPages = numberOfPages; // sets the number of pages to the number of pages passed in
    }
    public String getBookID() { // getter method for the book ID of the book object
        return bookID; // returns the book ID
    }
    public void setBookID(String bookID) { // setter method for the book ID of the book object
        this.bookID = bookID; // sets the book ID to the book ID passed in
    }
    @Override
    public boolean equals(Object o){ // method that checks if the book object is equal to another object excluding the ID which is unique
        if(o== null|| getClass()!= o.getClass()) // checks if object is null or not same class originally
            return false; // if true then return false
        Book book=(Book)o; // casts the object into a book objec to be able to call the attributes by name
        return super.equals(o)&&numberOfPages==book.numberOfPages; // calls the super's equals method for readability and checks if the number of pages are the same
    }
    @Override
public String toString(){ // method that returns the attributes of the book object as a string
        return super.toString()+" the number of pages of the book is "+numberOfPages+" the ID of the book is "+bookID; // returns the attributes of the object as a string, calls the super's toString method for improved readability
    }
}
