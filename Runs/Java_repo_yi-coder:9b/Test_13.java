public class Test_13 {

    public static void main(String[] args) {
        int i = 0;
        do_while_loop: do {
            System.out.println("i = " + i);
            i++;
            if (i < 5) {
                continue do_while_loop;
            }
        } while(false);
        System.out.println("Loop finished.");
    }

}