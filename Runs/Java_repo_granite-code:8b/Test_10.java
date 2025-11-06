public class Test_10 {

    public static void createInt(long[] p) {
            p[0] = (long) (int) (Math.random() * 2147483648); // Java's int range is -2147483648 to 2147483647
        }

    public static void main(String[] args) {
      long myIntPtr = 0;
      createInt(myIntPtr);
      if (myIntPtr != 0) {
        System.out.println("Value from out-param: " + ((int) (myIntPtr)));
        free(myIntPtr);
      }
    }

}