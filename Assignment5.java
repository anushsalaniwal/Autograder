// Main Class File:    CSE11.java
// File:               Assignment5.java
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


// This is the class where the main method, 
//along with all applicable unit tests, 
//are executed in CSE11 Spring quarter 2024.

/**
 * The Assignment5 class, simply runs the unit tests for Ticket, Autograder,
 * and Queue. Once all the unit tests are run, if they are all passed, 
 * the main method will return, "All unit tests passed". If not it will return
 * "ERROR: Failed test".
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

public class Assignment5 {
    // This method tests the correctness of the Ticket, Autograder, and Queue.
    // This is also where they are all executed. This method takes has no
    // parameters and returns a boolean.
    public static boolean unitTests() {

        // Ticket.java test cases

        // Ticket test case 1 
        Ticket ticket = new Ticket(); 
        ticket.setStudentName("Jon Snow");
        if (!ticket.getStudentName().equals("Jon Snow")) {
            System.out.println("Ticket test case 1 failed!"); 
            return false; 
        }

        // Ticket test case 2 
        int[] timeStamp = {16,20,34}; 
        int[] currentTime = {18,14,55};
        ticket = new Ticket("Jon Snow", timeStamp, "B250A", 
                              "I need help debugging a problem", true); 
        
        if (ticket.totalWait(currentTime) != 114) {
            System.out.println("Ticket test case 2 failed!"); 
            return false; 
        }
        // TODO: Ticket test case 3
        // Testing getter/setter methods
        Ticket ticket3 = new Ticket();
        ticket3.setStudentName("Daenerys Targaryen");
        ticket3.setTimeStamp(new int[]{10, 15, 30});
        ticket3.setLocation("Dragonstone");
        ticket3.setDescription("Need help with dragons.");
        ticket3.setDebugging(true);

        if (!ticket3.getStudentName().equals("Daenerys Targaryen") ||
                ticket3.getTimeStamp()[0] != 10 ||
                !ticket3.getLocation().equals("Dragonstone") ||
                !ticket3.getDescription().equals("Need help with dragons.") ||
                !ticket3.isDebugging()) {
            System.out.println("Ticket test case 3 failed!");
            return false;
        }

        // TODO: Ticket test case 4
        // Testing totalWait() method
        Ticket ticket4 = new Ticket("Tyrion Lannister", new int[]{12, 30, 45},
                "King's Landing", "Need help with political intrigue.", false);
        int[] currentTime4 = new int[]{13, 0, 0}; // 13:00:00
        if (ticket4.totalWait(currentTime4) != 30) {
            System.out.println("Ticket test case 4 failed!");
            return false;
        }

        // TODO: Ticket test case 5
        // Testing combination of constructor and getter methods
        Ticket ticket5 = new Ticket("Arya Stark", new int[]{9, 0, 0},
                "Winterfell", "Need help with sword fighting techniques.", 
                false);
        if (!ticket5.getStudentName().equals("Arya Stark") ||
                ticket5.getTimeStamp()[0] != 9 ||
                !ticket5.getLocation().equals("Winterfell") ||
                !ticket5.getDescription().equals(
                    "Need help with sword fighting techniques.") ||
                ticket5.isDebugging()) {
            System.out.println("Ticket test case 5 failed!");
            return false;
        }

        // Queue.java test cases

        // Queue test case 1
        Queue cse11 = new Queue(5);
        Ticket st1 = new Ticket("Bob Button", new int[]{11,25,33},"Basement",
                                "How to get started", false);
        Ticket st2 = new Ticket("Sponge Bob", new int[]{13,24,46},
                                "Under the sea", "I need help debugging Gary",
                                true);
        cse11.enqueue(st1);
        cse11.enqueue(st2);  
        if (cse11.peek() != st1) {
            System.out.println("Queue test case 1-1 failed!"); 
            return false; 
        }
        if (cse11.size() != 2) {
            System.out.println("Queue test case 1-2 failed!"); 
            return false; 
        }

        // TODO: Queue test case 2
        Queue queue2 = new Queue(3);
        Ticket st3 = new Ticket("Alice", new int[]{8, 30, 0}, "Library", 
        "Need help with research", false);
        Ticket st4 = new Ticket("Bob", new int[]{9, 0, 0}, "Computer Lab", 
        "Issue with software installation", true);
        Ticket st5 = new Ticket("Charlie", new int[]{9, 30, 0}, "Classroom", 
        "Can't access course materials", false);

        queue2.enqueue(st3);
        queue2.enqueue(st4);
        queue2.enqueue(st5);

        if (queue2.size() != 3) {
            System.out.println("Queue test case 2-1 failed!");
            return false;
        }

        queue2.dequeue();
        queue2.dequeue();

        if (queue2.size() != 1) {
            System.out.println("Queue test case 2-2 failed!");
            return false;
        }

        // TODO: Queue test case 3
        // Invoke constructor, enqueue operations, test peek() method
        Queue queue3 = new Queue(2);
        Ticket st6 = new Ticket("David", new int[]{10, 0, 0}, "Dorm", 
        "Internet connection issue", false);
        Ticket st7 = new Ticket("Emily", new int[]{10, 30, 0}, "Library", 
        "Need help finding books", true);

        queue3.enqueue(st6);
        queue3.enqueue(st7);

        if (queue3.peek() != st6) {
            System.out.println("Queue test case 3-1 failed!");
            return false;
        }

        // TODO: Queue test case 4
        // Invoke constructor, enqueue operations, test avgWait() method
        Queue queue4 = new Queue(4);
        Ticket st8 = new Ticket("Frank", new int[]{11, 0, 0}, "Lab", 
        "Issue with experiment setup", false);
        Ticket st9 = new Ticket("Grace", new int[]{11, 30, 0}, 
        "Classroom", "Forgot password", true);
        Ticket st10 = new Ticket("Henry", new int[]{12, 0, 0}, 
        "Library", "Can't print", false);

        queue4.enqueue(st8);
        queue4.enqueue(st9);
        queue4.enqueue(st10);

        int[] currentTime5 = new int[]{12, 30, 0};
        if (queue4.avgWait(currentTime5) != 60) {
            System.out.println("Queue test case 4-1 failed!");
            return false;
        }

        //Autogrrader.java test cases 

        // Autograder test case 1
        Autograder cse11AG = new Autograder("CSE11", 20); 
        Ticket st11 = new Ticket("Sponge Bob", new int[]{14,24,46},
                                "Under the sea", "I need help debugging Gary", 
                                true);
        cse11AG.submitTicket(st11); 

        if (cse11AG.isQueueLocked()) {
            System.out.println("Autogrdaer test case 1-1 failed!"); 
            return false; 
        }
        if (cse11AG.getAvgWait(new int[]{15,24,55}) != 60) {
            System.out.println("Autogrdaer test case 1-2 failed!"); 
            return false; 
        }
        String output= "Student Name: Sponge Bob\n" +
                       "Submitted at: 14:24\n" +
                       "Location: Under the sea\n" +
                       "Description: I need help debugging Gary";
        if (!cse11AG.viewNextTicket().equals(output)) {
            System.out.println("Autogrdaer test case 1-3 failed!"); 
            return false; 
        }
        Ticket st12 = new Ticket("Patrick Star", new int[]{13,59,02}, 
                                "Bikini Bottom",
                                "Can you help me find sponge Bob?", false);
        cse11AG.submitTicket(st12);
        if (!cse11AG.resolveNextTicket().equals(output)) {
            System.out.println("Autograder test case 1-4 failed!"); 
            return false; 
        }

        //Print Autograder
        cse11AG.getAutograderDetails(new int[]{16,17,18});


        // Autograder test case 2
        Autograder autograder2 = new Autograder("CSE12", 15);
        Ticket ticket1 = new Ticket("Alice", new int[]{9, 0, 0}, "Library", 
        "Need help with research", false);
        Ticket ticket2 = new Ticket("Bob", new int[]{9, 30, 0}, "Computer Lab", 
        "Issue with software installation", true);

        autograder2.submitTicket(ticket1);
        autograder2.submitTicket(ticket2);

        if (autograder2.isQueueLocked()) {
            System.out.println("Autograder test case 2-1 failed!");
            return false;
        }

        String output2 = autograder2.viewNextTicket();
        if (!output2.contains("Student Name: Alice")) {
            System.out.println("Autograder test case 2-2 failed!");
            return false;
        }

        autograder2.resolveNextTicket();

        if (autograder2.getAvgWait(new int[]{10, 0, 0}) != 30) {
            System.out.println("Autograder test case 2-3 failed!");
            return false;
        }

        autograder2.getAutograderDetails(new int[]{11, 0, 0});

        // Autograder test case 3
        Autograder autograder3 = new Autograder("CSE13", 10);
        Ticket st13 = new Ticket("Charlie", new int[]{10, 30, 0}, "Classroom",
         "Need help with assignments", false);

        autograder3.submitTicket(st13);

        if (autograder3.isQueueLocked()) {
            System.out.println("Autograder test case 3-1 failed!");
            return false;
        }

        String output3 = autograder3.viewNextTicket();
        if (!output3.contains("Student Name: Charlie")) {
            System.out.println("Autograder test case 3-2 failed!");
            return false;
        }

        autograder3.resolveNextTicket();

         if (autograder3.getAvgWait(new int[]{10, 0, 0}) != 0) {
            System.out.println("Autograder test case 3-3 failed!");
            return false;
        }

        autograder3.getAutograderDetails(new int[]{11, 0, 0});

        // Autograder test case 4
        Autograder autograder4 = new Autograder("CSE14", 20);
        Ticket st14 = new Ticket("Anush", new int[]{12, 0, 0}, "Lab", 
        "Helping with research", false);

        autograder4.submitTicket(st14);
        autograder4.resolveNextTicket();

        if (autograder4.isQueueLocked()) {
            System.out.println("Autograder test case 4-1 failed!");
            return false;
        }

        if (autograder4.getAvgWait(new int[]{12, 0, 0}) != 0) {
            System.out.println("Autograder test case 4-3 failed!");
            return false;
        }

        String output5 = autograder4.viewNextTicket();
        if (output5.equals("queue is empty")) {
            System.out.println("Autograder test case 4-2 failed!");
            return false;
        }

        autograder4.getAutograderDetails(new int[]{13, 0, 0});

        return true; 
    }
    // This method prints out all unit tests passed if all the unit test passed 
    // and prints Error: Failed test if not all the unit tests were passed.
    // This method takes in a String array and returns nothing.
    public static void main(String[] args) {
        // Perform unitTests 
        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("ERROR: Failed test.\n");
            return;
        }
    }
}