public class Test_10 {

    public static void createInt(int[] p) {
            p = new int[1];
            p[0] = 42;
        }

    public static void main(String[] args) {
        int myIntPtr = 0;
        createInt(myIntPtr);
        if (myIntPtr != 0) {
          System.out.printf("Value from out-param: %d\n", myIntPtr);
          free(myIntPtr);
        }
      }

}