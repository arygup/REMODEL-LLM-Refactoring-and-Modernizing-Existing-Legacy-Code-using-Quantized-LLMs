public class Test_6 {

    public static void main(String[] args) {
        int error = 1;
        System.out.println("Step 1");
        
        do {
            if (error) {
                break; // Equivalent to goto cleanup in C
            }
            
            System.out.println("Step 2 (should not run)");
        } while(false);
        
        // Cleanup section starts here
        System.out.println("Cleaning up...");
        System.out.println("Exiting.");
    }

}