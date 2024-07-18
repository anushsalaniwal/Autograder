// Main Class File:    CSE11.java
// File:               Ticket.java
// Quarter:            CSE 11 Spring 2024
//
// Author:             Anush Salaniwal.
// Email:              ansalaniwal@ucsd.edu
// Instructor's Name:  Professor Ochoa.
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          None.
//
// Online sources:   None.


/* This class includes the 2 constructers and 11 methods needed 
for Ticket in CSE11 Spring quarter 2024. The constructors are listed
here: Ticket and Ticket.
The methods are listed here: getStudentName, getTimeStamp, getLocation,
getDescription, isDebugging, setStudentName, setTimeStamp, setLocation,
setDescription, setDebugging, totalWait.
*/
/**
 * The Ticket class, without any great functionality of its own,
 * acts as a template to model a ‘Ticket’.
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/


// Complete the class according to the specifications in the writeup
// following proper CSE 11 style guidelines (eg complete ALL headers, 
// proper indentation, etc). Do not import any additional packages. Doing so 
// may fail the Gradescope autograder. Make sure your code compiles and runs 
// on Gradescope

public class Ticket {

    private static final int TIME_FORMAT = 3;
    private static final int MIN_IN_HOUR = 60; // number of minutes in an hour

    private String studentName;
    private int[] timeStamp;
    private String location;
    private String description;
    private boolean debugging;
    /*
     * Creates a new no arg constructer, Ticket, with the no parameters.
     */
    public Ticket() {
        this.studentName = null;
        this.timeStamp = new int[TIME_FORMAT];
        for (int i = 0; i < TIME_FORMAT; i++) {
            this.timeStamp[i] = 0;
        }
        this.location = null;
        this.description = null;
        this.debugging = false;
    }
    /*
     * Creates a Ticket instance with the parameters studentName (String),
     * timeStamp (integer array), location (String), description (String), 
     * debugging (boolean).
     */
    public Ticket(String studentName, int[] timeStamp, String location,
                  String description, boolean debugging) {
        this.studentName = studentName;
        this.timeStamp = new int[TIME_FORMAT];
        for (int i = 0; i < TIME_FORMAT; i++) {
            this.timeStamp[i] = timeStamp[i];
        }
        this.location = location;
        this.description = description;
        this.debugging = debugging;
    }

    // This getter method returns the corresponding private data field,
    // studentName. This method takes in no arguments and returns a String
    public String getStudentName() {
        return studentName;
    }

    // This getter method returns a new integer array that stores the same 
    // integers referenced to by the instance variable timeStamp.
    // This method takes in no arguments and returns an integer array
    public int[] getTimeStamp() {
        int[] copy = new int[TIME_FORMAT];
        for (int i = 0; i < TIME_FORMAT; i++) {
            copy[i] = timeStamp[i];
        }
        return copy;
    }

    // This getter method returns the corresponding private data field,
    // location. This method takes in no arguments and returns a String
    public String getLocation() {
        return location;
    }

    // This getter method returns the corresponding private data field,
    // description. This method takes in no arguments and returns a String
    public String getDescription() {
        return description;
    }
    
    // This getter method returns the corresponding private data field,
    // debugging. This method takes in no arguments and returns a boolean
    public boolean isDebugging() {
        return debugging;
    }

    // This setter method sets the corresponding instance variable, studentName,
    // to the one provided as an argument to the method. This method takes 
    // in a String and returns nothing
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // This setter method performs a deep copy of the array referred to by 
    // the method parameter array reference variable to the array referred 
    // to by the instance array reference variable. This method takes 
    // in an integer array and returns nothing
    public void setTimeStamp(int[] timeStamp) {
        for (int i = 0; i < TIME_FORMAT; i++) {
            this.timeStamp[i] = timeStamp[i];
        }
    }

    // This setter method sets the corresponding instance variable, location,
    // to the one provided as an argument to the method. This method takes 
    // in a String and returns nothing
    public void setLocation(String location) {
        this.location = location;
    }

    // This setter method sets the corresponding instance variable, description,
    // to the one provided as an argument to the method. This method takes 
    // in a String and returns nothing
    public void setDescription(String description) {
        this.description = description;
    }

    // This setter method sets the corresponding instance variable, debugging,
    // to the one provided as an argument to the method. This method takes 
    // in a boolean and returns nothing
    public void setDebugging(boolean debugging) {
        this.debugging = debugging;
    }

    // This  method takes the current time in the same format as the timeStamp
    // array (24-hour format) and must return the total minutes the ticket 
    // has been in the queue since. This method takes in an integer array and 
    // returns an integer.
    public int totalWait(int[] currentTime) {
        int totalMinutes = 0;
        totalMinutes += (currentTime[0] - timeStamp[0]) * MIN_IN_HOUR;
        totalMinutes += (currentTime[1] - timeStamp[1]);
        return totalMinutes;
    }
}
