public class Test_6 {

    public static void main(String[] args) {
        int error = 1;
        System.out.println("Step 1");
        do {
          if (error)
            break;
          System.out.println("Step 2 (should not run)");
        } while(false);
        System.out.println("Cleaning up...");
        System.out.println("Exiting.");
    }

}