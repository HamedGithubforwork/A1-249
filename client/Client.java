package client;
import library.Library;
public class Client {
    //-------------------------------------------------------------
// Assignment (1)
// Written by: (Hamed Vasheghani Farhani 40246686)
// -----------------------------------------------------------
    // the Client class imports all the classes in the library package and is meant to store the information of the client and a lease of library objects
    // it contains the attribute lease which is an array of library objects and the attributes clientID, phoneNumber and emailAddress
    // it also contains some setters and getters and equals methods to compare the objects and respect encapsulation
    private  Library[] lease; // creates an array of library objects to store the items the client has leased, private to respect encapsulation
    private int clientID; // unique identification number for the client private to respect encapsulation
   private long phoneNumber; // phone number of the client private to respect encapsulation, long because most numbers are 10 digits long and int can only store 9 digits
   private String emailAddress; // email address of the client private to respect encapsulation
    public Client(){ // default constructor for the client
        clientID = 0; // sets the identification number to 0
        phoneNumber = 0; // sets the phone number to 0
        emailAddress = ""; // sets the email address to an empty string
    }
    public Client( long phoneNumber, String emailAddress) { // constructor for the client, initializes all the attributes of the class
        clientID=Library.uniqueID(); // calls the unique ID static method from Library class to give a unique identification number to the client
        this.phoneNumber = phoneNumber; // sets the phone number to the phone number passed in
        this.emailAddress = emailAddress; // sets the email address to the email address passed in
        lease = new Library[20]; // initializes the lease array to an array of size 20
    }
    public Client(Client other) { // copy constructor for the client, however the identification number is unique therefore it is not copied and must be manually inserted
        clientID = Library.uniqueID(); //calls the unique ID static method from Library class to give a unique identification number to the client
        this.phoneNumber = other.phoneNumber; // sets the phone number to the phone number of the other client
        this.emailAddress = other.emailAddress; // sets the email address to the email address of the other client
    }

    // the following are the getters and setters for the attributes of the client object
    public int getClientID() { // getter method for the client's identification number
        return clientID; // returns the identification number
    }
    public void setClientID(int clientID) { // setter method for the client's identification number
        this.clientID = clientID; // sets the identification number to the identification number passed in
    }
    public long getPhoneNumber() { // getter method for the client's phone number
        return phoneNumber; // returns the phone number
    }
    public void setPhoneNumber(long phoneNumber) { // setter method for the client's phone number
        this.phoneNumber = phoneNumber; // sets the phone number to the phone number passed in
    }
    public String getEmailAddress() { // getter method for the client's email address
        return emailAddress; // returns the email address
    }
    public void setEmailAddress(String emailAddress) { // setter method for the client's email address
        this.emailAddress = emailAddress; // sets the email address to the email address passed in
    }
    public Library[] getLease() { // getter method for the items the client has leased
        return lease; // returns the items the client has leased
    }
    public void setLease(Library[] lease) { // setter method for the items the client has leased
        this.lease = lease; // sets the items the client has leased to the items the client has leased passed in
    }
    @Override
    public boolean equals(Object o){ // method that checks if the client object is equal to another object excluding the ID which is unique
        if(o== null|| getClass()!= o.getClass()) // checks if object is null or not same class originally
            return false; // if true then return false
        Client client=(Client)o; // casts the object into a client object to be able to call the attributes by name
        return phoneNumber==client.phoneNumber&&emailAddress.equals(client.emailAddress); // checks if the phone number and email address are the same
    }
    @Override
    public String toString() { // method that returns the attributes of the client object as a string
        return  "The client's ID is "+clientID+" the phone number of the client is "+phoneNumber+" the email address of the client is "+emailAddress; // returns the attributes of the object as a string
    }


}
