public class Test_12 {

    public static void main(String[] args) {
      Status s = Status.STOPPED;
      s = (Status.valueOf(s.name()).ordinal() + 1);
      if (s == Status.RUNNING) {
        System.out.println("Status is RUNNING (1)");
      }
      System.out.println("Status int value: " + s.ordinal());
    }

}