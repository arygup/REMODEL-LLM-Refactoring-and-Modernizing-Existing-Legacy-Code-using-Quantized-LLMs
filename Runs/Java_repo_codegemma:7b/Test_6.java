public class Test_6 {

    public static void main(String[] args) {
            int error = 1;
            System.out.println("Step 1");
            if (error) {
                do_while_loop: do {
                    break do_while_loop;
                } while (false);
            }
            System.out.println("Step 2 (should not run)");
            System.out.println("Cleaning up...");
            System.out.println("Exiting.");
        }

}