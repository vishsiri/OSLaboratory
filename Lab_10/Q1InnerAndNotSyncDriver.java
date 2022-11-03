public class Q1InnerAndNotSyncDriver {

  public static void main(String[] args) {
    int nThread = 100000;
    SharedNum1 sn = new SharedNum1();
    Thread[] thr = new Thread[nThread];
    for (int i = 0; i < nThread; i++) {
      thr[i] =
        new Thread(
          new Runnable() {
            @Override
            public void run() {
              sn.increment();
            }
          }
        );
      thr[i].start();/* A */
    }
    for (int i = 0; i < nThread; i++) {
      try {
        thr[i].join();
      } catch (InterruptedException ie) {}
    }
    if (sn.getVal() < nThread) {
      System.out.printf("v1 val = %d Not ", sn.getVal());
      System.out.printf("100,000\n");
    } else {
      System.out.printf("v1 good job! %d \n", sn.getVal());
      System.out.printf("\n");
    }
  }
}
