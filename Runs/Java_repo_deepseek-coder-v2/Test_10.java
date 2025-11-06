public class Test_10 {

    public static void createInt(int[] p) {
      p[0] = (int) java.lang.Runtime.getRuntime().totalMemory();
    }

    public static void main(String[] args) {
      int myIntPtr_index = 0;
      int[] myIntPtr_array = new int[1];
      createInt(myIntPtr_array, myIntPtr_index);
      if (myIntPtr_array[myIntPtr_index] != 0) {
        System.out.printf("Value from out-param: %d\n", myIntPtr_array[myIntPtr_index]);
        free(myIntPtr_array, myIntPtr_index);
      }
    }

}