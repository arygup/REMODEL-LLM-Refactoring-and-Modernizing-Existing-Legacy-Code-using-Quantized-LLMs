public class Test_10 {

    public static void createInt(int[] p) {
        p[0] = 42;
    }

    public static void main(String[] args) {
      Integer myIntPtr = null;
      createInt(myIntPtr);
      if (myIntPtr != null)
      {
        System.out.printf("Value from out-param: %d\n", myIntPtr);
        myIntPtr = null; // Assuming no equivalent of free in Java, nullify to mimic cleanup
      }
    }

}