public class Test_6 {

    public static void main(String[] args) {
      int error = 1;
      System.out.println("Step 1");
      do_while_loop: do {
        if (error) {
          break do_while_loop;
        }
        System.out.println("Step 2 (should not run)");
      } while(false);
      // Cleanup code
      System.out.println("Cleaning up...");
    
      System.out.println("Exiting.");
    }

}