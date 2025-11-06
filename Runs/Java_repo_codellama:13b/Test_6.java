public class Test_6 {

    private static void main() {
    		int error = 1;
    		do_while_loop: do {
    			printf("Step 1\n");
    			if (error) break do_while_loop;
    			printf("Step 2 (should not run)\n");
    		} while(false);
    		printf("Cleaning up...\n");
    		printf("Exiting.\n");
    	}

}