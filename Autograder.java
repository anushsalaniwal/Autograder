// Main Class File:    CSE11.java
// File:               Autograder.java
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


/* This class includes the 2 constructers and 7 methods needed 
for Autograder in CSE11 Spring quarter 2024. The constructors are listed
here: Autograder and Autograder.
The methods are listed here: submitTicket, resolveNextTicket, viewNextTicket,
isQueueLocked, getAvgWait, getTicketDetails, and getAutograderDetails.
*/
/**
 * The Autograder class acts as a mediator between the user or other components 
 * of the system and the queue of tickets. It provides methods to interact with 
 * the queue, including accepting new tickets, resolving tickets, and viewing 
 * tickets without dequeuing.
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

public class Autograder {
    private String course;
    private Queue queue;

     /*
     * Creates a new no arg constructer, Autograder, with the no parameters.
     * This initilializes the Autograder object.
     */
    public Autograder() {
        this.course = null;
        this.queue = new Queue();
    }

     /*
     * Creates an Autograder instance with the parameters course (String) and 
     * queueCapacity (integer).
     * Creates the Autogarader object for the parameters given.
     */
    public Autograder(String course, int queueCapacity) {
        this.course = course;
        this.queue = new Queue(queueCapacity);
    }

    // This method accepts and new Ticket object and enqueues it into the queue 
    // of this course. Takes in a ticket as a parameter and retunrs nothing
    public void submitTicket(Ticket ticket) {
        queue.enqueue(ticket);
    }
    
    // This method resolves the next ticket in the queue by dequeuing it and 
    // returning a string with the Ticket details. This method has no 
    // parameters and returns a String.
    public String resolveNextTicket() {
        if (queue.size() == 0) {
            return "No ticket to resolve.";
        }
        Ticket resolvedTicket = queue.dequeue();
        return getTicketDetails(resolvedTicket);
    }

    // This method returns the details of the next ticket in the queue without 
    // dequeuing it, as a String. This method takes no paramters and returns
    // a String.
    public String viewNextTicket() {
        if (queue.size() == 0) {
            return "No ticket in the queue.";
        }
        Ticket nextTicket = queue.peek();
        return getTicketDetails(nextTicket);
    }
    
    // This method checks if the queue is full. This method has no parameters
    // and returns a boolean
    public boolean isQueueLocked() {
        return queue.isLocked();
    }

    // This method takes in currentTime in 24-hour format 
    // and returns the average wait time of the queue. This method takes in 
    // an integer array as a parameter and returns an integer.
    public int getAvgWait(int[] currentTime) {
        return queue.avgWait(currentTime);
    }

     ///////////////////////////////////////////////////
     //  ****  DO NOT CHANGE THE METHODS BELOW!! ***  //
     ///////////////////////////////////////////////////
    public String getTicketDetails(Ticket ticket) {
        return ("Student Name: " + ticket.getStudentName()+ "\n" +
                "Submitted at: " + ticket.getTimeStamp()[0] + ":" + 
                ticket.getTimeStamp()[1] + "\n" +
                "Location: " + ticket.getLocation() + "\n" +
                "Description: " + ticket.getDescription());
    }

    public void getAutograderDetails(int[] currentTime) {
        System.out.println("Welcome to " + this.course + " Autograder!" + "\n"+
                           "Tickets in the queue: " + queue.size());
        if (this.queue.isLocked()){
            System.out.println("Queue is locked!!");
            return;
        } else {
            System.out.println("Queue is open! Average wait for a new ticket is"
                               + " " + getAvgWait(currentTime) + " minutes.");
        }
    }

}
