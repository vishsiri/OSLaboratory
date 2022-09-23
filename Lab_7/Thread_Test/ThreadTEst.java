public class ThreadTEst {

    public static void main(String[] args) {

        final int NUM_THREAD = 10;

        for (int i = 0; i < NUM_THREAD; i++) {
            Thread t1 = new Thread(new PrimeThread(i + 1));
            t1.start();
        }

    }

}

class PrimeThread implements Runnable {

    public int threadNum;

    public static int number = 1;
    public static int MAX_NUMBER = 500000;

    public PrimeThread(int threadNum) {
        this.threadNum = threadNum;
    }

    @Override
    public void run() {

        while (true) {
            int n = ++number;
            if (n <= MAX_NUMBER) {
                if (IsPrime(n)) {
                    System.out.println("Thread " + threadNum +
                            ": " + n + " is prime number");
                }
            } else {
                break;
            }
        }
    }

    public boolean IsPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0 && i != number)
                return false;
        }
        return true;
    }

}
