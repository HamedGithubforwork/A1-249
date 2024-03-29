package library;

public class Library {
//-------------------------------------------------------------
// Assignment (1)
// Written by: (Hamed Vasheghani Farhani 40246686)
// -----------------------------------------------------------
// the following class is intended to act as a parent class for the descendants Book, Journal and Media
// it also is imported with its descendants into the client class
// the client class would hold an array of library objects to store the items the client has leased v
    // it also contains some setters and getters and equals methods to compare the objects and respect encapsulation

    // the following are the attributes of the library object
private static int identificationNumber=0; // creates a static number that will be shared with descendants.
    // It is used to give a unique identification number to each library object, private as its only used in the library class for methods
    int yearOfPublication; // stores the year of publication of the item. packaged inorder to be inherited by the descendants
    String name; // stores the name of the item. packaged inorder to be inherited by the descendants
    String authors; // stores the authors of the library. packaged inorder to be inherited by the descendants
    public Library(){ // default constructor for the library, all values set to 0 or empty string to prevent null pointer exceptions
        yearOfPublication = 0; // sets the year of publication to 0
        name = ""; // sets the name of the item to an empty string
        authors = ""; // sets the authors to an empty string
    }
    public Library clone(){ // clone method for the library object
        Library clone = new Library(this); // creates a new library object
        return clone; // returns a new library object with the same attributes as the original library object
    }
    public Library(Library object){ // copy constructor for the library object
   yearOfPublication= object.yearOfPublication;
   name = object.name;
   authors = object.authors;
    }
    public  Library(String name, String authors,int yearOfPublication){ // a constructor for the library object that initializes all the attributes of the class
        this.yearOfPublication= yearOfPublication;
        this.name = name;
        this.authors = authors;
    }
    // the following and setters and getters for the attributes of the library object
    public int getYearOfPublication() { // getter method for the year of publication of the library object
        return yearOfPublication; // returns the year of publication
    }
    public void setYearOfPublication(int yearOfPublication) { // setter method for the year of publication of the library object
        this.yearOfPublication = yearOfPublication; // sets the year of publication to the year of publication passed in
    }
    public String getName() { // getter method for the name of the library object
        return name; // returns the name
    }
    public void setName(String name) { // setter method for the name of the library object
        this.name = name; // sets the name to the name passed in
    }
    public String getAuthors() { // getter method for the authors of the library object
        return authors; // returns the authors
    }
    public void setAuthors(String authors) { // setter method for the authors of the library object
        this.authors = authors; // sets the authors to the authors passed in
    }
    public static int getIdentificationNumber() { // getter method for the identification number of the library object
        return identificationNumber; // returns the identification number
    }
    public static void setIdentificationNumber(int identificationNumber) { // setter method for the identification number of the library object
        Library.identificationNumber = identificationNumber; // sets the identification number to the identification number passed in
    }
    public static int uniqueID(){ // a static method used to give a unique identification number to each library descendant and also the Client class
        identificationNumber++; // increments the identification number
        return identificationNumber; // returns the identification number
    }
    @Override
public boolean equals(Object o) { // the following methods takes in an object and checks if that object is equal to the library object

        if (o == null || getClass() != o.getClass()) // checks if the object is null or the original class of the objects are not the same. if any true then false
            return false; // returns false to the caller when if statement is true
        Library library = (Library) o; // cast the object to a library object to be able call the attributes of the library object by name
        return yearOfPublication == library.yearOfPublication && name.equals(library.name) && authors.equals(library.authors); // return true if all attributes are the same except the ID because that must be unique
    }
    @Override
    public String toString() { // method override of string to print the library's attributes, the ID it not printed here because it has letters added to its descendants.
        return "The yearOfPublication is " + yearOfPublication + ", the name is " + name + ", the author(s) are/is " + authors;
    }
}
