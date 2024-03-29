package library;

public class Journal extends Library {
    //-------------------------------------------------------------
// Assignment (1)
// Written by: (Hamed Vasheghani Farhani 40246686)
// -----------------------------------------------------------
    // the  Journal class is a descendant of the library class. It is meant to be stored in a library array.
    // it contains the attributes of its parent class and has a new volume number attribute and a unique journal ID
    // it also contains some setters and getters and equals methods to compare the objects and respect encapsulation
    private int volumeNumber; // creates an integer for the volume number, private to respect encapsulation
    private String JournalID; // creates a string for the journal ID, private to respect encapsulation

    public Journal(){ // default constructor for the journal
    super(); // calls the default constructor of the library class
    volumeNumber = 0; // sets the volume number to 0
    JournalID = ""; // sets the journal ID to an empty string
    }
    public Journal (Journal object) {// copy constructor of the journal object
        super(object); // calls the copy constructor of the library class
        volumeNumber = object.volumeNumber; // sets the volume number to the volume number of the other journal
        JournalID = "J"+uniqueID(); // calls the unique ID method to give a unique identification number to the journal
    }
    public Journal(String name, String authors, int yearOfPublication, int volumeNumber) { // constructor for the journal object that initializes all the attributes of the class
        super(name, authors, yearOfPublication); // calls the constructor of the library class
        this.volumeNumber = volumeNumber; // sets the volume number to the volume number passed in
        JournalID = "J"+uniqueID(); // calls the unique ID method to give a unique identification number to the journal
    }
    public Journal clone(){ // clone method for the journal object
        Journal clone = new Journal(this); // creates a new journal object
        clone.setJournalID(this.JournalID); // sets the journal ID of the new journal object to the journal ID of the original journal object
        return clone; // returns a new journal object with the same attributes as the original journal object
    }
    // the following are the getters and setters for the attributes of the journal object
    public int getVolumeNumber() { // getter method for the volume number of the journal object
        return volumeNumber; // returns the volume number
    }
    public void setVolumeNumber(int volumeNumber) { // setter method for the volume number of the journal object
        this.volumeNumber = volumeNumber; // sets the volume number to the volume number passed in
    }
    public String getJournalID() { // getter method for the journal ID of the journal object
        return JournalID; // returns the journal ID
    }
    public void setJournalID(String JournalID) { // setter method for the journal ID of the journal object
        this.JournalID = JournalID; // sets the journal ID to the journal ID passed in
    }
    @Override
    public boolean equals(Object o){ // method that checks if the journal object is equal to another object excluding the ID which is unique
        if(o== null|| getClass()!= o.getClass()) // checks if object is null or not same class originally
            return false; // if true then return false
        Journal journal=(Journal)o; // casts the object into a journal object to be able to call the attributes by name
        return super.equals(o)&&volumeNumber==journal.volumeNumber; // calls the super's equals method for readability and checks if the volume number are the same
    }
    @Override
    public String toString() { // method that returns the attributes of the journal object as a string
        return super.toString()+" the volume number of the journal is "+volumeNumber+" the ID of the journal is "+JournalID; // returns the attributes of the object as a string, calls the super's toString method for improved readability
    }
}
