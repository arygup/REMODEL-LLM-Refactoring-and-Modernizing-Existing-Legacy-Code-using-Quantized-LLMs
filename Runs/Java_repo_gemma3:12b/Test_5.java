public class Test_5 {

    public static void main(String[] args) {
        long u_val = 0xFFFFFFFFL;
        System.out.printf("Original: %d%n", u_val);
        u_val = u_val + 1;
        System.out.printf("Overflow ( + 1): %d%n", u_val & 0xFFFFFFFFL);
        u_val = u_val - 5;
        System.out.printf("Underflow ( - 5): %d%n", u_val & 0xFFFFFFFFL);
    }

}