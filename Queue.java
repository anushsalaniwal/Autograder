// Main Class File:    CSE11.java
// File:               Queue.java
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

/* This class includes the 2 constructers and 6 methods needed 
for Queue in CSE11 Spring quarter 2024. The constructors are listed
here: Queue and Queue.
The methods are listed here: enqueue, peek, dequeue, size, avgWait, isLocked.
*/

/**
 * The Queue class represents a first-in-first-out (FIFO) data structure 
 * for managing a collection of Ticket objects. FIFO order in this scenario 
 * means that the ticket that has an earlier timeStamp should be at the front 
 * of the queue, before other tickets.This class is implemented using an array 
 * to store objects of class Ticket in the explained FIFO order.
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

public class Queue {
    // Constants
    private int capacity;
    private int size; 
    private Ticket[] ticketQueue; 
    private boolean isLocked;

    //Printed when queue is empty 
    private static final String EMPTY_Q_ERROR = "queue is empty";

    //Printed when trying to add a ticket to a queue that has reached capacity
    private static final String LOCKED_Q_ERROR = "queue is locked!!";

     /*
     * Creates a new no arg constructer, Queue, with the no parameters.
     */
    public Queue() {
        this.capacity = 0;
        this.size = 0;
        this.ticketQueue = null;
        this.isLocked = false;
    }

     /*
     * Creates a Queue instance with the parameters capacity (integer).
     */

    public Queue(int capacity) {
        if (capacity < 0) {
            this.capacity = 0;
            this.ticketQueue = null;
            this.isLocked = false;
        } else {
            this.capacity = capacity;
            this.ticketQueue = new Ticket[capacity];
            this.isLocked = false;
        }
        this.size = 0;
    }
    
    // A method to add a Ticket object, ticket, to the back of the Queue. 
    // If the Queue is already full or is null, then this method prints
    // the contents of the LOCKED_Q_ERROR string and return. If upon adding a
    // new Ticket, the ticketQueue gets full, the isLocked flag is set to true.
    // This method takes in ticket as a parameter.
    public void enqueue(Ticket ticket) {
        if (isLocked || ticketQueue == null || size >= capacity) {
            System.out.println(LOCKED_Q_ERROR);
            return;
        }
        ticketQueue[size++] = ticket;
        if (size == capacity) {
            isLocked = true;
        }
    }

    // The peek method returns the FRONT Ticket from the Queue without 
    // deleting the Ticket from the Queue. This method takes in no parameters.
    // If Queue is empty or it is null, then this method prints
    // the contents of EMPTY_Q and return null.
    public Ticket peek() {
        if (size == 0 || ticketQueue == null) {
            System.out.println(EMPTY_Q_ERROR);
            return null;
        }
        return ticketQueue[0];
    }

    // The dequeue method deletes the front Ticket from the Queue, 
    // shifts the remaining Tickets towards the front of the Queue, 
    // and updates the size. This method takes in no parameters.
    // If ticketQueue is empty or is null, then this method prints the contents 
    // of EMPTY_Q and return null. This method also checks if isLocked has 
    // been set to true and updates it upon removing the ticket. 
    public Ticket dequeue() {
        if (size == 0 || ticketQueue == null) {
            System.out.println(EMPTY_Q_ERROR);
            return null;
        }
        Ticket dequeuedTicket = ticketQueue[0];
        // Shift remaining tickets towards the front
        for (int i = 0; i < size - 1; i++) {
            ticketQueue[i] = ticketQueue[i + 1];
        }
        ticketQueue[size - 1] = null; // Set the last element to null
        size--;
        isLocked = false; // Reset lock status
        return dequeuedTicket;
    }

    // A method that returns the current size of the Queue based on how many 
    // tickets are currently in the Queue. This method has no parameters.
    public int size() {
        return size;
    }

    // This method calculates the average wait time for an incoming ticket 
    // by averaging the totalWait() of current Tickets in the Queue.
    // If there are no tickets in the queue, return 0.
    // THis method takes in an integer array as a parameter
    public int avgWait(int[] currentTime) {
        if (size == 0 || ticketQueue == null) {
            return 0;
        }

        int tWait = 0;
        int counter = 0;

        for (Ticket ticket : ticketQueue) {
            if (ticket!= null){
                tWait += ticket.totalWait(currentTime);
                counter++;
            }
        }
        return tWait / counter;
    }
    
    // This method that simply returns the current flag(value) of 
    // isLocked variable of the Queue object.
    public boolean isLocked() {
        return isLocked;
    }
}
