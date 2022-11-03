class SharedNum4 { // synchronized block

  private int val = 0;

  void increment() {
    synchronized (this) {
      val++;
    }
  }

  int getVal() {
    return val;
  }
}
