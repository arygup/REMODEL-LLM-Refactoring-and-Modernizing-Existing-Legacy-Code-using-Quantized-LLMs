public class Test_6 {

    public static void main(String[] args) {
      int error = 1;
      System.out.println("Step 1");
      
      do_while_loop:
      do {
        if (error != 0) {
          break do_while_loop;
        }
        System.out.println("Step 2 (should not run)");
        
      } while(false);
    
      System.out.println("Cleaning up...");
    
      System.out.println("Exiting.");
    }

}