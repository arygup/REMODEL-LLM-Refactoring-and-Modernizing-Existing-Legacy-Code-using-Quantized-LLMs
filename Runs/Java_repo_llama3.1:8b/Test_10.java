public class Test_10 {

    public static void createInt(int[] p)
    {
      p[0] = new Integer(42);
    }

    public static void main(String[] args) {
      int myIntPtr = 0;
      createInt(myIntPtr);
      if (myIntPtr != 0) {
        System.out.println("Value from out-param: " + myIntPtr);
        do_while_loop:
        do {
          free(myIntPtr);
          break do_while_loop;
        } while(false); // Ensure cleanup is executed even after the loop
      }
      return;
    }

}