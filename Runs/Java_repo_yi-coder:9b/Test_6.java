public class Test_6 {

    public static void main(String[] args) {
      int error = 1;
      System.out.println("Step 1\n");
      if (error == 1) {
        breakDoWhileLoop: do { } while(false);
      } else {
        System.out.println("Step 2 (should not run)\n");
      }
      System.out.println("Cleaning up...\n");
      System.out.println("Exiting.\n");
    }

}