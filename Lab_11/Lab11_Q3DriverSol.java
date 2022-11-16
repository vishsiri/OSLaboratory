import java.util.Random;
public class Lab11_Q3DriverSol {
    public static void main(String[] args) {
        int numPopper = 1;
        int numPusher = 1;
        int numTurns = 10;
        StackForConcurrent stack = new StackForConcurrent();
        Pusher[] pushArr = new Pusher[numPusher];
        Popper[] poppArr = new Popper[numPopper];
        for (int i = 0; i < numPusher; i++) {
            pushArr[i] = new Pusher(numTurns, stack);
            poppArr[i] = new Popper(numTurns, stack);
            pushArr[i].start();
            poppArr[i].start();
        }
        for (int i = 0; i < numPusher; i++) {
            try {
                pushArr[i].join();
                poppArr[i].join();
            } catch (InterruptedException ie) {
            }
        }
    }
} // class
class Node {
    int val;
    Node next;

    Node(int v) {
        val = v;
    }

    Node(int v, Node n) {
        val = v;
        this.next = n;
    }

    int getVal() {
        return val;
    }
}
class Pusher extends Thread {
    int turns;
    StackForConcurrent concurStack;

    Pusher(int t, StackForConcurrent s) {
        turns = t;
        concurStack = s;
    }

    // constructor
    /* Q5 */public void run() {
        Random rand = new Random();
        try {
            sleep(rand.nextInt(100));
        } catch (InterruptedException ie) {
        }
        for (int i = 0; i < turns; i++)
            concurStack.push(i);
    } // run
}

class Popper extends Thread {
    int turns;
    StackForConcurrent concurStack;

    Popper(int t, StackForConcurrent s) {
        turns = t;
        concurStack = s;
    }

    public void run() {
        int x = -1;
        for (int j = 0; j < turns; j++) {
            x = concurStack.pop();
            System.out.println("got " + x + " stack size = " + concurStack.size);
        }
    } // run
}
class StackForConcurrent {
    Node top;
    int size;

    StackForConcurrent() {
        top = null;
        size = 0;
    } // constructor

    synchronized void push(int n) {
        top = new Node(n, top);
        size++;
        if (top.next == null) {
            /* Q1 */ 
            notifyAll();
            
        }
        /* no_longer_empty */
    }// push
    
    /* Q2 */synchronized int pop() {
        try {
            while (top == null) {
                System.out.println("empty stack");
                /* Q3 */ wait();
            }
            /*
             * choose between Q4.1 or
             * Q4.2 inside or outside try block
             */
            size--; /* Q4.1 */
        } catch (InterruptedException e) {
            System.out.println("error");
            return 1;
        }
        //size--; /* Q4.2 */
        int n = top.val;
        top = top.next;
        return n;
    } // pop
}
// Stack