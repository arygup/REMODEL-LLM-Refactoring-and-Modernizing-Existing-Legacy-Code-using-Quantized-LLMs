public class Test_5 {

    public static void main(String[] args) {
            unsigned int u_val = 4294967295L;
            System.out.printf("Original: %u\n", u_val);
            u_val = u_val + 1;
            System.out.printf("Overflow ( + 1): %u\n", u_val);
            u_val = u_val - 5;
            System.out.printf("Underflow ( - 5): %u\n", u_val);
        }

}