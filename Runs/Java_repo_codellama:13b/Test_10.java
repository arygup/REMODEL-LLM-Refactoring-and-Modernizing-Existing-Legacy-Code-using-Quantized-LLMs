public class Test_10 {

    public static void createInt(int[] p) {
      int p_index = 0;
      int[] p_array = p;
      p_array[p_index] = 42;
    }

    public static int main() {
      long myIntPtr = 0; // Translate to Java's Long type, as it is guaranteed to be at least 32-bit
      createInt(&myIntPtr);
      if (myIntPtr != 0) {
        System.out.printf("Value from out-param: %d\n", myIntPtr); // Use Java's printf-style method
        free(myIntPtr);
      }
      return 0;
    }

}