class SharedNum5 {

  private int val = 0;
  Object lock;

  SharedNum5() {
    val = 0;
  }

  synchronized int getVal() {
    try {
      System.out.println("waiting");
      // waiting for notify from setVal
      this.wait();
    } catch (InterruptedException ie) {}
    return val;
  } // getVal

  synchronized void setVal(int x) {
    val = x;
    this.notifyAll();
  } // setVal
}
