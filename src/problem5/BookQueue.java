package problem5;

import java.util.LinkedList;

public class BookQueue {
    private LinkedList<Book> queue;

    public BookQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(Book book) {
        queue.addLast(book); // FIFO
    }

    public Book dequeue() {
        return queue.removeFirst(); // remove from front
    }

    public Book peek() {
        return queue.getFirst(); // front of queue
    }

    public void display() {
        System.out.println("Queue contents (front to back):");
        for (Book book : queue) {
            System.out.println("- " + book);
        }
    }

    public LinkedList<Book> getQueue() {
        return queue;
    }
}
