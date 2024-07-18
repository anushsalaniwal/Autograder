# Autograder System

This project is an implementation of a simplified autograder system that manages a tutor help queue. It is designed to simulate a system where students can submit support tickets during office hours. The system consists of three main components: Ticket, Queue, and Autograder classes.

## Project Structure

- **Ticket.java**: Represents the properties of a support ticket.
- **Queue.java**: Manages a queue of tickets using a first-in-first-out (FIFO) data structure.
- **Autograder.java**: Acts as a mediator between the user and the queue of tickets.

## Features

### Ticket Class
The `Ticket` class represents the main properties of a support ticket with the following fields:
- `studentName`: The name of the student submitting the ticket.
- `timeStamp`: An array of integers representing the time the ticket was submitted (in 24-hour format).
- `location`: The student's location.
- `description`: A brief description of the issue.
- `debugging`: A boolean indicating whether the ticket is for debugging help.

**Methods:**
- Constructors for creating `Ticket` objects.
- Getter and setter methods for each field.
- `totalWait(int[] currentTime)`: Calculates the total wait time in minutes since the ticket was submitted.

### Queue Class
The `Queue` class represents a FIFO queue for managing `Ticket` objects with the following fields:
- `capacity`: The maximum number of tickets the queue can hold.
- `size`: The current number of tickets in the queue.
- `ticketQueue`: An array of `Ticket` objects.
- `isLocked`: A boolean indicating whether the queue is full.

**Methods:**
- Constructors for creating `Queue` objects.
- `enqueue(Ticket ticket)`: Adds a ticket to the back of the queue.
- `dequeue()`: Removes and returns the ticket from the front of the queue.
- `peek()`: Returns the ticket at the front of the queue without removing it.
- `size()`: Returns the current size of the queue.
- `avgWait(int[] currentTime)`: Calculates the average wait time for tickets in the queue.
- `isLocked()`: Returns whether the queue is full.

### Autograder Class
The `Autograder` class manages the queue of tickets for a course with the following fields:
- `course`: The name of the course.
- `queue`: An instance of the `Queue` class.

**Methods:**
- Constructors for creating `Autograder` objects.
- `submitTicket(Ticket ticket)`: Submits a new ticket to the queue.
- `resolveNextTicket()`: Resolves the next ticket in the queue and returns its details.
- `viewNextTicket()`: Returns the details of the next ticket in the queue without dequeuing it.
- `isQueueLocked()`: Checks if the queue is full.
- `getAvgWait(int[] currentTime)`: Returns the average wait time for tickets in the queue.

## Unit Tests

Unit tests are provided in the `Assignment5.java` file. The tests include:
- Testing getter and setter methods of the `Ticket` class.
- Testing enqueue and dequeue operations of the `Queue` class.
- Testing the submission and resolution of tickets in the `Autograder` class.

## Compilation and Execution

To compile the project, navigate to the directory containing the Java files and run:
```sh
javac *.java
