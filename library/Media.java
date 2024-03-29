package library;

public class Media extends Library {
    //-------------------------------------------------------------
// Assignment (1)
// Written by: (Hamed Vasheghani Farhani 40246686)
// -----------------------------------------------------------
    // the Media class is a descendant of the library class. It is meant to be stored in a library array.
    // it contains the attributes of its parent class and has a new type attribute and a unique Media ID
    // it also contains some setters and getters and equals methods to compare the objects and respect encapsulation
   private String type; // the type of the media object private to respect encapsulation
   private String mediaID; // the media ID of the media object private to respect encapsulation
    public Media(){ // default constructor for the media object
        super(); // calls the default constructor of the library class
        type = ""; // sets type to an empty string
        mediaID = ""; // sets media ID to an empty string
    }
   public Media(Media object){ //copy constructor of media object
         super(object); // calls the copy constructor of the library class
         type = object.type; // sets the type to the type of the other media
         mediaID = "M"+uniqueID(); // calls the unique ID method to give a unique identification number to the Media
    }
     public Media(String name, String authors, int yearOfPublication, String type) { // constructor for the media object that initializes all the attributes of the class
         super(name, authors, yearOfPublication); // calls the constructor of the library class to initialize the variables from the library class
         this.type = type; // sets the type to the type passed in
         mediaID = "M" + uniqueID(); // calls the unique ID method to give a unique identification number to the Media
     }
     public Media clone(){ // clone method for the media object
         Media clone = new Media(this); // creates a new media object
         clone.setMediaID(this.mediaID); // sets the media ID of the new media object to the media ID of the original media object
         return clone; // returns a new media object with the same attributes as the original media object
     }
     // the following are the getters and setters for the attributes of the media object
     public String getType() { // getter method for the type of the media object
          return type; // returns the type
     }
     public void setType(String type) { // setter method for the type of the media object
          this.type = type; // sets the type to the type passed in
     }
     public String getMediaID() { // getter method for the media ID of the media object
          return mediaID; // returns the media ID
     }
     public void setMediaID(String mediaID) { // setter method for the media ID of the media object
          this.mediaID = mediaID; // sets the media ID to the media ID passed in
   }
   public boolean equals(Object o){ // method that checks if the media object is equal to another object excluding the ID which is unique
         if(o== null|| getClass()!= o.getClass()) // checks if object is null or not same class originally
             return false; // if true then return false
         Media media=(Media)o; // casts the object into a media object to be able to call the attributes by name
         return super.equals(o)&&type.equals(media.type); // calls the super's equals method for readability and checks if the type are the same through .equals method as its a string
     }
     public String toString(){ // method that returns the attributes of the media object as a string
         return super.toString()+" the type of the media is "+type+" the ID of the media is "+mediaID; // returns the attributes of the object as a string, calls the super's toString method for improved readability
     }

}
