public class Test_6 {

    public static void main(String[] args) {
        int error = 1;
        System.out.println("Step 1");
        
        if (error != 0) { // C-style `if` statement becomes a regular Java `if` condition.
            break do_while_loop; // Instead of using goto, we use the 'do-while loop' to perform cleanup actions.
        }
        System.out.println("Step 2 (should not run)");
        
        System.out.println("Cleaning up...");
        System.out.println("Exiting.");
    }

}