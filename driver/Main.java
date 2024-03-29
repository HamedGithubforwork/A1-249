package driver;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import library.*;
import java.util.Scanner;
import client.Client;
public class Main {
    //-------------------------------------------------------------
// Assignment (1)
// Written by: (Hamed Vasheghani Farhani 40246686)
// -----------------------------------------------------------
    //  the driver class of the program. It contains the main method and is used to test the library and client classes
    // it contains the hardCodeScenario method that contains a premade scenario to demonstrate the functions
    // the premade scenario has 3 objects of each class and tests their equlaity excluding their identification number.
    // it also converts the object's data to a string and lastly the hard code scenario copies the array media and prints the copy to string
    // there is also an inputScenario method that takes user input to create a scenario
    // the inputScenario method contains the displayMainMenu method that displays the main menu
    // in the scenario the user can add, delete, change information, list all items in a specific category, print all items,
    // add a client, edit a client, delete a client, lease an item to a client, return an item from a client, show all items leased by a client,
    // show all items leased by all clients, display the biggest book and make a copy of the books array
    // this program doesn't fully check for correct user inputs. It assumes the user will input the correct data type and format
    // Therefore if a user tries to input the wrong datatype, a null error will occcur

private static void allClientsToString(Client[] clientArrayInputScenarioNew) {
    for(int i=0; i<clientArrayInputScenarioNew.length;i++) // loops through the client array displaying all client objects to string
        System.out.println(clientArrayInputScenarioNew[i].toString()); // prints the information of the client object
}
    private static int findFreeIndex(Object[] o) { // method that increments the place in library array by 1. private because only used in main and static to be called by name.
        for(int i=0;i<o.length;i++) // loops through the library array
            if(o[i]==null) // checks if the current index is empty
                  // sets the free index to the current index
                return i; // returns the index of the empty space
        return(-1); // returns -1 if there is no empty space
    }

    private static void displayOption1Menu() { // method that displays the first option menu of the program. private because only used in main and static to be called by name.
        System.out.println("Which operation would you like to perform?"); // asks the user which operation they would like to perform
        System.out.println("1. add an item?"); // description of the first option
        System.out.println("2. delete an item?"); // description of the second option
        System.out.println("3. change information of an item?"); // description of the third option
        System.out.println("4. list all items in a specific category (book, journal, or media)?"); // description of the fourth option
        System.out.println("5. print all items (from all categories)?"); // description of the fifth option
    }

    private static void displayMainMenu() { // method that displays the main menu of the program. private because only used in main and static to be called by name.
        System.out.println("Welcome to the User input scenario!"); // tells the user that the program has started
        System.out.println("select which function you wish to use "); // asks the user which scenario they would like to enter
        System.out.println("1.add an item, delete an item, change information of an item, list all items in a specific\n" + // description of the first option
                "category (book, journal, or media), and print all items (from all categories)."); //
        System.out.println("2.add a client, edit a client, and delete a client. "); // description of the second option
        System.out.println("3.lease an item to a client and return an item from a client."); // description of the third option
        System.out.println("4.show all items leased by a client."); // description of the fourth option
        System.out.println("5.show all items leased by all clients"); // description of the fifth option
        System.out.println("6.Display the biggest book"); // description of the sixth option
        System.out.println("7.Make a copy of the books array"); // description of the seventh option
    }
public static void deleteItemFromClient(Client[] clientArrayInputScenarioNew, int indexOfItemToDelete) { // method that takes in an array of client objects and an index and returns a new array with the object at the index removed
    Client[] tempArray = new Client[clientArrayInputScenarioNew.length]; // creates a temporary array to store the library objects
    for (int i = 0; i < indexOfItemToDelete; i++) { // the array copies in 2 parts. before the index and after the index that we exclude
        tempArray[i] = clientArrayInputScenarioNew[i]; // copies the library objects before the index to the temporary array
    }
    for (int i = indexOfItemToDelete + 1; i < clientArrayInputScenarioNew.length; i++) {  // the 2nd part of the array being copied
        tempArray[i - 1] = clientArrayInputScenarioNew[i]; // copies the library objects after the index to the temporary array
    }
    for (int i = 0; i < tempArray.length; i++) { // the original array is being updated with the replacement
        clientArrayInputScenarioNew[i] = tempArray[i]; // the original array is being updated with the deletion
    }
}

    private static void displayAllBooksToString(Library[] libraryArrayInputScenarionew) {
        for (int i = 0; i < libraryArrayInputScenarionew.length; i++) { // loops through the library array displaying all book objects to string
            if (libraryArrayInputScenarionew[i] instanceof Book) { // checks if the array is a book or not null is not a book so it will be skipped
                System.out.println("the book at index " + i + "'s information is: "); // prints the information of the library object
                System.out.println(libraryArrayInputScenarionew[i].toString()); // prints the information of the library object that are books
            }
        }
    }

    private static void displayAllMediaToString(Library[] libraryArrayInputScenarionew) {
        for (int i = 0; i < libraryArrayInputScenarionew.length; i++) { // loops through the library array displaying all media objects to string
            if (libraryArrayInputScenarionew[i] instanceof Media) { // checks if the array is a Media or not
                System.out.println("the Media at index " + i + "'s information is: "); // prints the information of the library objet
                System.out.println(libraryArrayInputScenarionew[i].toString()); // prints the information of the library object that are Media
            }
        }
    }

    private static void displayAllJournalToString(Library[] libraryArrayInputScenarionew) {
        for (int i = 0; i < libraryArrayInputScenarionew.length; i++) { // loops through the library array displaying all media objects to string
            if (libraryArrayInputScenarionew[i] instanceof Journal) { // checks if the array is a Media or not
                System.out.println("the Journal at index " + i + "'s information is: "); // prints the information of the library objet
                System.out.println(libraryArrayInputScenarionew[i].toString()); // prints the information of the library object that are journals
            }
        }
    }

    private static void hardCodeScenario() { // method that contains the hard coded scenario. private because only used in main and static to be called by name.
        // creates 3 client objects for hard code scenario
        Client c1 = new Client(5142221122L, "email@forwork"); // creates a client object with a phone number and email address
        Client c2 = new Client(c1); // creates a client object with the same attributes as the first client except ID
        Client c3 = new Client(5148899112L, "2ndemail@forwork"); // creates a client object with a different phone number and email address
        // creates 3 library objects for hard code scenario
        Book b1 = new Book("The Greatest Book Ever", "The Legendary Author x", 1999, 9999); // creates a book object with a name, author, year of publication and number of pages
        Book b2 = new Book(b1); // creates a book object with the same attributes as the first book except ID
        Book b3 = new Book("The worst book ever", "The Legendary Author x", 2420, 6969); // creates a book object with a different name, year of publication and number of pages
        // creates 3 media objects for hard code scenario
        Media m1 = new Media("The Greatest CD Ever", "The Greatest Worst Singer x", 80085, "CD"); // creates a media object with a name, author, year of publication and type
        Media m2 = new Media(m1); // creates a media object with the same attributes as the first media except ID
        Media m3 = new Media("The worst CD ever now on DVD", "The Greatest Worst Singer x", 800850, "DVD"); // creates a media object with a different name, year of publication and type
        // creates 3 journal objects for hard code scenario
        Journal j1 = new Journal("The Greatest Journal Ever", "xyz", 2050, 3); // creates a journal object with a name, author, year of publication and number of pages
        Journal j2 = new Journal(j1); // creates a journal object with the same attributes as the first journal except ID
        Journal j3 = new Journal("The worst Journal ever", "xyzBAD", 5555, 1); // creates a journal object with a different name, year of publication and number of pages

        // the following section is just filling the arrays with the created objects, there is an array for each class + a Library class array that stores its descendants
        // fills the library array with the descendant objects
        Library[] libraryArray = new Library[9]; // creates an array of library objects
        libraryArray[0] = b1;
        libraryArray[1] = b2;
        libraryArray[2] = b3;
        libraryArray[3] = m1;
        libraryArray[4] = m2;
        libraryArray[5] = m3;
        libraryArray[6] = j1;
        libraryArray[7] = j2;
        libraryArray[8] = j3;
        Client[] clientArray = new Client[3]; // creates an array of client objects
        clientArray[0] = c1; // sets the first element of the array to the first client object
        clientArray[1] = c2; // sets the second element of the array to the second client object
        clientArray[2] = c3; // sets the third element of the array to the third client object
        Journal[] journalArray = new Journal[3]; // creates an array of journal objects
        journalArray[0] = j1; // sets the first element of the array to the first journal object
        journalArray[1] = j2; // sets the second element of the array to the second journal object
        journalArray[2] = j3; // sets the third element of the array to the third journal object
        Media[] mediaArray = new Media[3]; // creates an array of media objects
        mediaArray[0] = m1; // sets the first element of the array to the first media object
        mediaArray[1] = m2; // sets the second element of the array to the second media object
        mediaArray[2] = m3; // sets the third element of the array to the third media object
        Book[] bookArray = new Book[3]; // creates an array of book objects
        bookArray[0] = b1; // sets the first element of the array to the first book object
        bookArray[1] = b2; // sets the second element of the array to the second book object
        bookArray[2] = b3; // sets the third element of the array to the third book object
        // the following section is just printing the objects to the console for the hard coded scenario
        System.out.println("Thank you for choosing the hardcoded scenario!"); // tells the user that the hardcoded scenario is being used
        System.out.println(); // prints a blank line for readability
        System.out.println("We are now displaying the client's information"); // tells user what is being displayed
        for (int i = 0; i < clientArray.length; i++) { // iterates through the client array
            System.out.println("Client " + (i + 1) + " information: "); // tells user what is being displayed
            System.out.println(clientArray[i].toString()); // prints the information of the client
            System.out.println(); // prints a blank line for readability
        }
        System.out.println("We are now displaying the book's information"); // tells user what is being displayed
        for (int i = 0; i < bookArray.length; i++) { // iterates through the book array
            System.out.println("book " + (i + 1) + " information: "); // prints the information of the book
            System.out.println(bookArray[i].toString()); // prints the information of the book
            System.out.println(); // prints a blank line for readability
        }
        System.out.println("We are now displaying the media's information"); // tells user what is being displayed
        for (int i = 0; i < mediaArray.length; i++) { // iterates through the media array
            System.out.println("Media " + (i + 1) + " information: "); // tells user what is being displayed
            System.out.println(mediaArray[i].toString()); // prints the information of the media
            System.out.println(); // prints a blank line for readability
        }
        System.out.println("We are now displaying the journal's information");// tells user what is being displayed
        for (int i = 0; i < journalArray.length; i++) { // iterates through the journal array
            System.out.println("book " + (i + 1) + " information: "); // prints the information of the journal
            System.out.println(journalArray[i].toString()); // prints the information of the journal
            System.out.println(); // prints a blank line for readability
        }
        System.out.println("We are now displaying the name of the biggest book in the library"); // tells user what is being displayed
        System.out.println(); // prints a blank line for readability
        System.out.println("The biggest book in library is" + getBiggestBook(libraryArray)); // prints the name of the biggest book in the library
        System.out.println(); // prints a blank line for readability
        System.out.println("We will now be testing the equality of one book object with a media object");
        System.out.println(); // prints a blank line for readability
        System.out.println("The book object's information is:"); // tells user what is being displayed
        System.out.println(bookArray[0].toString()); // prints the information of the first book
        System.out.println(); // prints a blank line for readability
        System.out.println("The media object's information is:"); // tells user what is being displayed
        System.out.println(mediaArray[0].toString()); // prints the information of the first media
        System.out.println(); // prints a blank line for readability
        System.out.println("The result of the equality test is " + bookArray[0].equals(mediaArray[0]) + " because a book and a CD are not the same thing!"); // prints the result of the equality test
        System.out.println(); // prints a blank line for readability
        System.out.println("We will now be testing the equality of one book object with a copy of itself");
        System.out.println(); // prints a blank line for readability
        System.out.println("The book object's information is:"); // tells user what is being displayed
        System.out.println(bookArray[0].toString()); // prints the information of the first book
        System.out.println(); // prints a blank line for readability
        System.out.println("The copy book object's information is:"); // tells user what is being displayed
        System.out.println(bookArray[1].toString()); // prints the information of the second book
        System.out.println(); // prints a blank line for readability
        System.out.println("The result of the equality test is " + bookArray[0].equals(bookArray[1]) + " because they're the same book ID doesnt matter!"); // prints the result of the equality test
        System.out.println(); // prints a blank line for readability
        System.out.println("We will now be testing the equality of one book object with a different book object");
        System.out.println(); // prints a blank line for readability
        System.out.println("The book object's information is:"); // tells user what is being displayed
        System.out.println(bookArray[0].toString()); // prints the information of the first book
        System.out.println(); // prints a blank line for readability
        System.out.println("The different book object's information is:"); // tells user what is being displayed
        System.out.println(bookArray[2].toString()); // prints the information of the second book
        System.out.println(); // prints a blank line for readability
        System.out.println("The result of the equality test is " + bookArray[0].equals(bookArray[2]) + " because they're different Books!"); // prints the result of the equality test
        System.out.println(); // prints a blank line for readability
        System.out.println("we will now be creating a clone of the book array");
        System.out.println("We are now displaying the media array's information"); // tells user what is being displayed
        for (int i = 0; i < mediaArray.length; i++) { // iterates through the media array
            System.out.println("Media " + (i + 1) + " information: "); // tells user what is being displayed
            System.out.println(mediaArray[i].toString()); // prints the information of the media
            System.out.println(); // prints a blank line for readability
        }
        System.out.println("We are now displaying the copy of the media array's information"); // tells user what is being displayed
        Media[] copyMediaArray = copyBooks(mediaArray); // creates a deep copy of the media array
        for (int i = 0; i < copyMediaArray.length; i++) { // iterates through the media array
            System.out.println("Media " + (i + 1) + " information: "); // tells user what is being displayed
            System.out.println(copyMediaArray[i].toString()); // prints the information of the media
            System.out.println(); // prints a blank line for readability
        }
    }

    private static String getBiggestBook(Library[] libraryArray) { // method that takes in an array of library objects and returns the book with the most pages. only returns one book private becuase only the driver needs it
        Book biggestBook = new Book(); // creates a book object to store the biggest book
        for (int i = 0; i < libraryArray.length; i++) { // iterates through the array of library objects

            if (libraryArray[i] instanceof Book) { // checks if the object is an instance of book object if true then checks their pages
                if (biggestBook.getNumberOfPages() < ((Book) libraryArray[i]).getNumberOfPages()) // checks if the number of pages of the biggest book is less than the number of pages of the current book
                    biggestBook = (Book) libraryArray[i]; // if true then sets the biggest book to the current book
            }
        }
        return biggestBook.getName();
    }

    private static Media[] copyBooks(Media[] bookArray) { // method that takes in an array of media objects and returns a deep copy of that array
        Media[] copyArray = new Media[bookArray.length]; // creates an array of media objects with the same length as the original array
        for (int i = 0; i < bookArray.length; i++) { // iterates through the original array
            if (bookArray[i] != null) {
                copyArray[i] = new Media(bookArray[i]); // sets the current element of the copy array to a new Media  object with the same attributes as the current element of the original array
            }
        }
        return copyArray; // returns the deepcopy of the array
    }

    private static void deleteItemFromLibrary(Library[] libraryArrayInputScenarionew, int indexOfItemToDelete) { // method that takes in an array of library objects and an index and returns a new array with the object at the index removed
        Library[] tempArray = new Library[libraryArrayInputScenarionew.length]; // creates a temporary array to store the library objects
        for (int i = 0; i < indexOfItemToDelete; i++) { // the array copies in 2 parts. before the index and after the index that we exclude
            tempArray[i] = libraryArrayInputScenarionew[i]; // copies the library objects before the index to the temporary array
        }
        for (int i = indexOfItemToDelete + 1; i < libraryArrayInputScenarionew.length; i++) {  // the 2nd part of the array being copied
            tempArray[i - 1] = libraryArrayInputScenarionew[i]; // copies the library objects after the index to the temporary array
        }
        for (int i = 0; i < tempArray.length; i++) { // the original array is being updated with the replacement
            libraryArrayInputScenarionew[i] = tempArray[i]; // the original array is being updated with the deletion
        }
    }

    public static void main(String[] args) {
        Library[] libraryArrayInputScenarionew = new Library[20]; // a library array created for the input scenario
        Client[] clientArrayInputScenarioNew = new Client[20]; // a client array created for the input scenario
        boolean loopProgram = true; // creates a boolean to loop the program , packaged visibility to be used in the main method
        Scanner scan = new Scanner(System.in); // creates a scanner object to take in user input
        System.out.println("Welcome to the library program!"); // tells the user that the program has started

        while (loopProgram) {
            System.out.println("which scenario would you like to enter? 1 for hard code, 2 for user input and 3 to end the program"); // asks the user which scenario they would like to enter
            int response = scan.nextInt(); // takes in the user's response
            if (response == 1) { // starts the hardcode scenario if the user enters 1
                hardCodeScenario(); // calls the hard code scenario method to run the hard code scenario for the user
            } else if (response == 2) { // starts the user input scenario if the user enters 2
                displayMainMenu(); // calls the display main menu method to display the main menu to the user
                response = scan.nextInt(); // takes in the user's response
                if (response == 1) { // if the user enters 1 then brings the options for menu 1 which has 5 options
                    displayOption1Menu();  // brings the options for menu 1
                    response = scan.nextInt(); // takes in the user's response
                    if (response == 1) { // if the user enters 1 then adds an item to the library

                        System.out.println("What type of item would you like to add? 1 for book, 2 for journal, 3 for media"); // asks the user what type of item they would like to add
                        response = scan.nextInt(); // takes in the user's response
                        if (response == 1) { // if the user enters 1 then adds a book to the library
                            System.out.println("Enter the name of the book"); // asks the user for the name of the book
                            String bookName = scan.next(); // takes in the user's response
                            System.out.println("Enter the author of the book"); // asks the user for the author of the book
                            String bookAuthor = scan.next(); // takes in the user's response
                            System.out.println("Enter the year of publication of the book"); // asks the user for the year of publication of the book
                            int bookYear = scan.nextInt(); // takes in the user's response
                            System.out.println("Enter the number of pages of the book"); // asks the user for the number of pages of the book
                            int bookPages = scan.nextInt(); // takes in the user's response
                            int freeIndex = findFreeIndex(libraryArrayInputScenarionew); // finds the first free index in the library array
                            libraryArrayInputScenarionew[freeIndex] = new Book(bookName, bookAuthor, bookYear, bookPages); // adds a book to the library
                            System.out.println("The book has been added to the library, its information is:"); // tells the user that the book has been added to the library
                            System.out.println(libraryArrayInputScenarionew[freeIndex].toString()); // prints the information of the book
                        } else if (response == 2) { // if the user enters 2 then adds a journal to the library
                            System.out.println("Enter the name of the journal"); // asks the user for the name of the journal
                            String journalName = scan.next(); // takes in the user's response
                            System.out.println("Enter the author of the journal"); // asks the user for the author of the journal
                            String journalAuthor = scan.next(); // takes in the user's response
                            System.out.println("Enter the year of publication of the journal"); // asks the user for the year of publication of the journal
                            int journalYear = scan.nextInt(); // takes in the user's response
                            System.out.println("Enter the volume number of the journal"); // asks the user for the volume number of the journal
                            int journalVolume = scan.nextInt(); // takes in the user's response
                            int freeIndex = findFreeIndex(libraryArrayInputScenarionew); // finds the first free index in the library array
                            libraryArrayInputScenarionew[freeIndex] = new Journal(journalName, journalAuthor, journalYear, journalVolume); // adds a journal to the library
                            System.out.println("The journal has been added to the library, its information is:"); // tells the user that the journal has been added to the library
                            System.out.println(libraryArrayInputScenarionew[freeIndex].toString()); // prints the information of the journal
                        } else if (response == 3) { // if the user enters 3 then adds a media to the library
                            System.out.println("Enter the name of the media"); // asks the user for the name of the media
                            String mediaName = scan.next(); // takes in the user's response
                            System.out.println("Enter the author of the media"); // asks the user for the author of the media
                            String mediaAuthor = scan.next(); // takes in the user's response
                            System.out.println("Enter the year of publication of the media"); // asks the user for the year of publication of the media
                            int mediaYear = scan.nextInt(); // takes in the user's response
                            System.out.println("Enter the type of the media"); // asks the user for the type of the media
                            String mediaType = scan.next(); // takes in the user's response
                            int freeIndex = findFreeIndex(libraryArrayInputScenarionew); // finds the first free index in the library array
                            libraryArrayInputScenarionew[freeIndex] = new Media(mediaName, mediaAuthor, mediaYear, mediaType); // adds a media to the library
                            System.out.println("The media has been added to the library, its information is:"); // tells the user that the media has been added to the library
                            System.out.println(libraryArrayInputScenarionew[freeIndex].toString()); // prints the information of the media

                        }

                    } else if (response == 2) { // if the user enters 2 then deletes an item from the library
                        System.out.println("Which category would you like to delete from? 1 for book, 2 for journal, 3 for media"); // asks the user which category they would like to delete from
                        response = scan.nextInt(); // takes in the user's response
                        if (response == 1) { // if the user enters 1 then deletes a book from the library
                            System.out.println("Enter the index of the book you would like to delete"); // asks the user for the index of the book they would like to delete
                            displayAllBooksToString(libraryArrayInputScenarionew); // displays all books to string
                            response = scan.nextInt(); // takes in the user's response
                            deleteItemFromLibrary(libraryArrayInputScenarionew, response); // deletes the book from the library
                        } else if (response == 2) { // if the user enters 2 then deletes a journal from the library
                            System.out.println("Enter the index of the journal you would like to delete"); // asks the user for the index of the journal they would like to delete
                            displayAllJournalToString(libraryArrayInputScenarionew); // displays all journals to string
                            response = scan.nextInt(); // takes in the user's response
                            deleteItemFromLibrary(libraryArrayInputScenarionew, response); // deletes the journal from the library
                        } else if (response == 3) { // if the user enters 3 then deletes a media from the library
                            System.out.println("Enter the index of the media you would like to delete"); // asks the user for the index of the media they would like to delete
                            displayAllMediaToString(libraryArrayInputScenarionew); // displays all media to string
                            response = scan.nextInt(); // takes in the user's response
                            deleteItemFromLibrary(libraryArrayInputScenarionew, response); // deletes the media from the library
                        }
                    } else if (response == 3) { // if the user enters 3 change the information of the item
                        System.out.println("Which category would you like to change from? 1 for book, 2 for journal, 3 for media"); // asks the user which category they would like to delete from
                        response = scan.nextInt(); // takes in the user's response
                        if (response == 1) { // if the user enters 1 displays all books and asks witch one to change
                            displayAllBooksToString(libraryArrayInputScenarionew); // displays all books to string
                            System.out.println("Enter the index of the book you would like to change"); // asks the user for the index of the book they would like to change
                            int indexToChange = scan.nextInt(); // takes in the user's response
                            System.out.println("What would you like to change? 1 for name, 2 for author, 3 for year of publication, 4 for number of pages"); // asks the user what they would like to change
                            response = scan.nextInt(); // takes in the user's response
                            if (response == 1) { // if the user enters 1 change the name of the book
                                System.out.println("Enter the new name of the book"); // asks the user for the new name of the book
                                String bookName = scan.next(); // takes in the user's response
                                libraryArrayInputScenarionew[indexToChange].setName(bookName); // changes the name of the book
                            }
                            else if (response == 2) { // if the user enters 2 change the author of the book
                                System.out.println("Enter the new author of the book"); // asks the user for the new author of the book
                                String bookAuthor = scan.next(); // takes in the user's response
                                libraryArrayInputScenarionew[indexToChange].setAuthors(bookAuthor); // changes the author of the book
                            }
                            else if (response == 3) { // if the user enters 3 change the year of publication of the book
                                System.out.println("Enter the new year of publication of the book"); // asks the user for the new year of publication of the book
                                int bookYear = scan.nextInt(); // takes in the user's response
                                libraryArrayInputScenarionew[indexToChange].setYearOfPublication(bookYear); // changes the year of publication of the book
                            }
                            if (response == 4) { // if the user enters 4 change the number of pages of the book
                                System.out.println("Enter the new number of pages of the book"); // asks the user for the new number of pages of the book
                                int bookPages = scan.nextInt(); // takes in the user's response
                                ((Book) libraryArrayInputScenarionew[indexToChange]).setNumberOfPages(bookPages); // changes the number of pages of the book
                            }
                        }
                        else if (response == 2) { // displays all journals and asks witch one to change
                            displayAllJournalToString(libraryArrayInputScenarionew);
                            System.out.println("Enter the index of the journal you would like to change"); // asks the user for the index of the journal they would like to change
                            int indexToChange = scan.nextInt(); // takes in the user's response
                            System.out.println("What would you like to change? 1 for name, 2 for author, 3 for year of publication, 4 for volume number"); // asks the user what they would like to change
                            response = scan.nextInt(); // takes in the user's response
                            if (response == 1) { // if the user enters 1 change the name of the journal
                                System.out.println("Enter the new name of the journal"); // asks the user for the new name of the journal
                                String journalName = scan.next(); // takes in the user's response
                                libraryArrayInputScenarionew[indexToChange].setName(journalName); // changes the name of the journal
                            }
                            else if (response == 2) { // if the user enters 2 change the author of the journal
                                System.out.println("Enter the new author of the journal"); // asks the user for the new author of the journal
                                String journalAuthor = scan.next(); // takes in the user's response
                                libraryArrayInputScenarionew[indexToChange].setAuthors(journalAuthor); // changes the author of the journal
                            }
                           else if (response == 3) { // if the user enters 3 change the year of publication of the journal
                                System.out.println("Enter the new year of publication of the journal"); // asks the user for the new year of publication of the journal
                                int journalYear = scan.nextInt(); // takes in the user's response
                                libraryArrayInputScenarionew[indexToChange].setYearOfPublication(journalYear); // changes the year of publication of the journal
                            }
                          else  if (response == 4) { // if the user enters 4 change the volume number of the journal
                                System.out.println("Enter the new volume number of the journal"); // asks the user for the new volume number of the journal
                                int journalVolume = scan.nextInt(); // takes in the user's response
                                ((Journal) libraryArrayInputScenarionew[indexToChange]).setVolumeNumber(journalVolume); //changes the volume number of the journal

                            }

                        }
                      else  if (response == 3) { // if 3 select displays all media to string and asks which index to change
                            displayAllMediaToString(libraryArrayInputScenarionew); // displays all media to string
                            System.out.println("Enter the index of the media you would like to change"); // asks the user for the index of the media they would like to change
                            int indexToChange = scan.nextInt(); // takes in the user's response
                            System.out.println("What would you like to change? 1 for name, 2 for author, 3 for year of publication, 4 for type"); // asks the user what they would like to change
                            response = scan.nextInt(); // takes in the user's response
                            if (response == 1) { // if the user enters 1 change the name of the media
                                System.out.println("Enter the new name of the media"); // asks the user for the new name of the media
                                String mediaName = scan.next(); // takes in the user's response
                                libraryArrayInputScenarionew[indexToChange].setName(mediaName); // changes the name of the media
                            }
                           else if (response == 2) { // if the user enters 2 change the author of the media
                                System.out.println("Enter the new author of the media"); // asks the user for the new author of the media
                                String mediaAuthor = scan.next(); // takes in the user's response
                                libraryArrayInputScenarionew[indexToChange].setAuthors(mediaAuthor); // changes the author of the media
                            }
                         else   if (response == 3) // if the user enters 3 change the year of publication of the media
                            {
                                System.out.println("Enter the new year of publication of the media"); // asks the user for the new year of publication of the media
                                int mediaYear = scan.nextInt(); // takes in the user's response
                                libraryArrayInputScenarionew[indexToChange].setYearOfPublication(mediaYear); // changes the year of publication of the media
                            }
                          else  if (response == 4) { // if the user enters 4 change the type of the media
                                System.out.println("Enter the new type of the media"); // asks the user for the new type of the media
                                String mediaType = scan.next(); // takes in the user's response
                                ((Media) libraryArrayInputScenarionew[indexToChange]).setType(mediaType); // changes the type of the media has to be casted because the ancestor never had this method
                                // therefore it won't be accesible to an overide.
                            }
                        }
                    } else if (response == 4) { // if the user enters 4 list all items in a specific category
                        System.out.println("Which category would you like to list? 1 for book, 2 for journal, 3 for media"); // asks the user which category they would like to list
                        response = scan.nextInt(); // takes in the user's response
                        if (response == 1) { // if the user enters 1 list all books in the library
                            displayAllBooksToString(libraryArrayInputScenarionew); // displays all books to string
                        } else if (response == 2) { // if the user enters 2 list all journals in the library
                            displayAllJournalToString(libraryArrayInputScenarionew); // displays all journals to string
                        } else if (response == 3) { // if the user enters 3 list all media in the library
                            displayAllMediaToString(libraryArrayInputScenarionew); // displays all media to string
                        }
                    } else if (response == 5) {// if the user enters 5 list all items in the library
                        displayAllMediaToString(libraryArrayInputScenarionew); // displays all media to string
                        displayAllJournalToString(libraryArrayInputScenarionew); // displays all journals to string
                        displayAllBooksToString(libraryArrayInputScenarionew); // displays all books to string
                    }
                }
                else if (response == 2) { // shows 3 options for the user to add/edit/delete a client
                    System.out.println("would you like to 1. add a client, 2. edit a client, 3. delete a client"); // asks the user which category they would like to list
                    response = scan.nextInt(); // takes in the user's response
                    if (response == 1) { // if the user enters 1 then adds a client to the library
                        String email; // creates a string to store the email of the client
                        long phoneNumber; // creates a long to store the phone number of the client
                        System.out.print("Enter the email of the client: "); // asks the user for the email of the client
                        email = scan.next(); // takes in the user's response
                        System.out.print("Enter the phone number of the client: "); // asks the user for the phone number of the client
                        phoneNumber = scan.nextLong(); // takes in the user's response
                        int freeIndex = findFreeIndex(clientArrayInputScenarioNew); // finds the first free index in the client array
                        clientArrayInputScenarioNew[freeIndex] = new Client(phoneNumber, email); // creates a client object to add to client array
                  System.out.println("The client has been added to the library, its information is:"); // tells the user that the client has been added to the library
                        System.out.println(clientArrayInputScenarioNew[freeIndex].toString()); // prints the information of the client
                    }
                    else if (response == 2) { // if the user enters 2 then edits a client in the library
                        for (int i = 0; i < clientArrayInputScenarioNew.length; i++) {// displays all clients to string
                            if(clientArrayInputScenarioNew[i] != null) {
                                System.out.println("Client at index " + i + " information: "); // tells the user what is being displayed
                                System.out.println(clientArrayInputScenarioNew[i].toString()); // prints the information of the client to string
                            }
                        }
                        System.out.println("Enter the index of the client you would like to change"); // asks the user for the index of the client they would like to change
                        int indexToChange = scan.nextInt(); // takes in the user's response
                        System.out.println("What would you like to change? 1 for email, 2 for phone number"); // asks the user what they would like to change
                        response = scan.nextInt(); // takes in the user's response
                        if (response == 1) { // if the user enters 1 change the email of the client
                            System.out.println("Enter the new email of the client"); // asks the user for the new email of the client
                            String email = scan.next(); // takes in the user's response
                            clientArrayInputScenarioNew[indexToChange].setEmailAddress(email); // changes the email of the client
                        }
                       else if (response == 2) { // if the user enters 2 change the phone number of the client
                            System.out.println("Enter the new phone number of the client"); // asks the user for the new phone number of the client
                            long phoneNumber = scan.nextLong(); // takes in the user's response
                            clientArrayInputScenarioNew[indexToChange].setPhoneNumber(phoneNumber); // changes the phone number of the client
                        }

                    }
                    else if (response == 3) { // if the user enters 3 then displays all clients to string and asks which one to delete based on index
                        for (int i = 0; i < clientArrayInputScenarioNew.length; i++) {// displays all clients to string
                            if(clientArrayInputScenarioNew[i] != null) {
                                System.out.println("Client at index " + i + " information: "); // tells the user what is being displayed
                                System.out.println(clientArrayInputScenarioNew[i].toString()); // prints the information of the client to string
                            }
                        }
                        System.out.println("Enter the index of the client you would like to delete"); // asks the user for the index of the client they would like to delete
                        int indexToDelete = scan.nextInt(); // takes in the user's response
                        deleteItemFromClient(clientArrayInputScenarioNew, indexToDelete); // deletes the client at the index

                    }
                }
              else if (response == 3) { // displays the items in the library and their index and asks the user which item to add a lease to
                    System.out.println("would you like to return an item or add a lease? 1 for return, 2 for lease"); // asks the user which category they would like to list
                    response = scan.nextInt(); // takes in the user's response
                    if (response == 1) {
                        for (int i = 0; i < clientArrayInputScenarioNew.length; i++) {// displays all clients to string and their index
                            if (clientArrayInputScenarioNew[i] != null) { // checks if the client is not null
                                System.out.println("Client at index " + i + " information: "); // tells the user what is being displayed
                                System.out.println(clientArrayInputScenarioNew[i].toString()); // prints the information of the client to string
                            }
                        }
                            System.out.println("Enter the index of the client you would like to return an item for"); // asks the user for the index of the client they would like to return an item for
                            int indexOfClientToReturn = scan.nextInt(); // takes in the user's response
                            for (int j = 0; j < clientArrayInputScenarioNew[indexOfClientToReturn].getLease().length; j++) { // iterates through the lease array of the client
                                if (clientArrayInputScenarioNew[indexOfClientToReturn].getLease()[j] != null) { // checks if the lease is not null
                                    System.out.print("Lease at index " + (j) + ":"); // indicates the index of the object
                                    System.out.println(clientArrayInputScenarioNew[indexOfClientToReturn].getLease()[j].toString()); // prints the lease of the client to string where its not null
                                }
                            }
                            System.out.println("Enter the index of the item you would like to return"); // asks the user for the index of the item they would like to return
                            int indexToReturn = scan.nextInt(); // takes in the user's response
                            Library itemToReturn = clientArrayInputScenarioNew[indexOfClientToReturn].getLease()[indexToReturn].clone(); // stores the deep copy of the object
                            deleteItemFromLibrary(clientArrayInputScenarioNew[indexOfClientToReturn].getLease(), indexToReturn); // deletes the item from the lease library array
                            libraryArrayInputScenarionew[findFreeIndex(libraryArrayInputScenarionew)] = itemToReturn; // adds the item to the library


                    }
                   else if (response == 2) { // displays all clients and their index and asks the user which client to add a lease to
                        for (int i = 0; i < clientArrayInputScenarioNew.length; i++) {// displays all clients to string and their index
                            if (clientArrayInputScenarioNew[i] != null) {
                                System.out.println("Client at index " + i + " information: "); // tells the user what is being displayed
                                System.out.println(clientArrayInputScenarioNew[i].toString()); // prints the information of the client to string
                            }
                        }
                        System.out.println("Enter the index of the client you would like to add a lease to"); // asks the user for the index of the client they would like to add a lease to
                        int indexToAddLease = scan.nextInt(); // takes in the user's response
                        for (int i = 0; i < libraryArrayInputScenarionew.length; i++) {// displays all library items to string and their index
                            if (libraryArrayInputScenarionew[i] != null) { // checks if the library item is not null
                                System.out.println("Library item at index " + i + " information: "); // tells the user what is being displayed
                                System.out.println(libraryArrayInputScenarionew[i].toString()); // prints the information of the library item to string
                            }
                        }
                        System.out.println("Enter the index of the item you would like to add to the lease"); // asks the user for the index of the item they would like to add to the lease
                        int indexToAddToLease = scan.nextInt(); // takes in the user's response
                        Library itemToAdd = libraryArrayInputScenarionew[indexToAddToLease].clone(); //stores a deep copy of the library item to add to the lease
                        Library[] leaseToModify = clientArrayInputScenarioNew[indexToAddLease].getLease(); // stores the reference of the lease
                        leaseToModify[findFreeIndex(leaseToModify)] = itemToAdd; // adds the item to the lease array
                        deleteItemFromLibrary(libraryArrayInputScenarionew, indexToAddLease); // deletes the item from the library
                    }
                }


                else if (response == 4) {// if chosen, displays all clients and their index. Then asks the User which client to see their lease of
                    for (int i = 0; i < clientArrayInputScenarioNew.length; i++) {// displays all clients to string
                        if (clientArrayInputScenarioNew[i] != null) { // checks if the client is not null
                            System.out.println("Client at index " + i + " information: "); // tells the user what is being displayed
                            System.out.println(clientArrayInputScenarioNew[i].toString()); // prints the information of the client to string
                        }
                    }
                    System.out.println("Enter the index of the client you would like to see the lease of"); // asks the user for the index of the client they would like to see the lease of
                    int indexToSeeLease = scan.nextInt(); // takes in the user's response
                    if(clientArrayInputScenarioNew[indexToSeeLease].getLease()!=null){
                    for (int i = 0; i < clientArrayInputScenarioNew[indexToSeeLease].getLease().length; i++) { // iterates through the lease array of the client
                        if (clientArrayInputScenarioNew[indexToSeeLease].getLease()[i] != null) { // checks if the lease is not null
                            System.out.print("Lease at index " + (i) + ":"); // indicates the index of the object
                            System.out.println(clientArrayInputScenarioNew[indexToSeeLease].getLease()[i].toString()); // prints the lease of the client to string where its not null
                        }
                    }
                    }
                    else {
                        System.out.println("Client has no lease"); // tells the user that there is no lease at the index
                    }
                }
               else if (response == 5) {// if the user enters 5 lease all the clients info
                    for (int i = 0; i < clientArrayInputScenarioNew.length; i++) {// displays all clients to string
                        if (clientArrayInputScenarioNew[i] != null) { // checks if the client is not null
                            System.out.println("Client at index " + i + " information: "); // tells the user what is being displayed
                            System.out.println(clientArrayInputScenarioNew[i].toString()); // prints the information of the client to string
                            if (clientArrayInputScenarioNew[i].getLease() != null) {
                                for (int j = 0; j < clientArrayInputScenarioNew[i].getLease().length; j++) // iterates through the lease array of the client
                                    if (clientArrayInputScenarioNew[i].getLease()[j] != null) { // checks if the lease is not null
                                        System.out.print("Lease at index " + (j) + ":"); // indicates the index of the object
                                        System.out.println(clientArrayInputScenarioNew[i].getLease()[j].toString());// prints the lease of the client to string where its not null
                                    }
                            }else{
                                System.out.println("The Client has no lease"); // tells the user that there is no lease at the index
                            }
                        }


                    }
                }
                else if(response==6){ // if the user enters 6 display the biggest book
                    System.out.println("The biggest book in the library is: " + getBiggestBook(libraryArrayInputScenarionew)); // prints the biggest book in the library
                }
                else if(response==7){ // if the user enters 7 make a copy of the books array
                    Media[] copyMediaArray= new Media[libraryArrayInputScenarionew.length]; // creates a copy of the media array
                    for (int i=0; i<libraryArrayInputScenarionew.length;i++){ // iterates through library array to find media objects
                        if(libraryArrayInputScenarionew[i]!=null) {
                            if (libraryArrayInputScenarionew[i] instanceof Media) {
                                copyMediaArray[findFreeIndex(copyMediaArray)] = (Media) libraryArrayInputScenarionew[i];
                            }
                        }
                    }
                    copyMediaArray= copyBooks(copyMediaArray); // creates a new copy of the media array but with unique ids
                    displayAllMediaToString(copyMediaArray); // displays the copy of the media array
                }

            } else if (response == 3) { // starts the user input scenario if the user enters 2
                loopProgram = false; // sets the loop program to false inorder to end the program
                System.out.println("Goodbye!"); // tells the user that the program has ended
            } else {
                System.out.println("Invalid input, please enter 1 or 2"); // tells the user that the input is invalid
            }

        }
            }
        }


