public class Test_13 {

    public static void main(String[] args) {
        int i = 0;
        do_while_loop: do {
            System.out.printf("i = %d\n", i);
            
            i++;
            if (i < 5)
            {
                break do_while_loop;
            }
            System.out.println("Loop finished.");
        } while(false);
    }

}