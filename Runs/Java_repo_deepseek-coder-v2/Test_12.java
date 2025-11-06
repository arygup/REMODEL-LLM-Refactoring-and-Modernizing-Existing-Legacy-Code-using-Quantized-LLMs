public class Test_12 {

    public static void main(String[] args) {
      int s = STOPPED;
      s += 1;
      if (s == RUNNING) {
        System.out.println("Status is RUNNING (1)");
      }
      System.out.printf("Status int value: %d\n", s);
    }

}