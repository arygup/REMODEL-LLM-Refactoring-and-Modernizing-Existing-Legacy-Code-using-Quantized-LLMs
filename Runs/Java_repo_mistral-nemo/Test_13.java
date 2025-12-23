public class Test_13 {

    public static void main(String[] args) {
      int i = 0;
      loop_start:
      System.out.println("i = " + i);
      i++;
      if (i < 5) {
        continue loop_start;
      }
      System.out.println("Loop finished.");
    }

}


