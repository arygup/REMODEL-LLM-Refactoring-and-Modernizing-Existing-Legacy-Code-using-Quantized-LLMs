public class Test_6 {

    public static void main(String[] args) {
        int error = 1;
        do {
            System.out.printf("Step 1\n");
            if (error != 0) {
                break;
            }
            System.out.printf("Step 2 (should not run)\n");
        } while (false);
        System.out.printf("Cleaning up...\n");
        System.out.printf("Exiting.\n");
    }

}