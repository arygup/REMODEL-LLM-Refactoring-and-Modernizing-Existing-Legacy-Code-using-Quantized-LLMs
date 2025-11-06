public class Test_5 {

    public static void main(String[] args) {
        long u_val = 4294967295L;
        System.out.println("Original: " + u_val);
        u_val = (u_val & 0xFFFFFFFFL) + 1;
        System.out.println("Overflow ( + 1): " + u_val);
        u_val = (u_val & 0xFFFFFFFFL) - 5;
        System.out.println("Underflow ( - 5): " + u_val);
    }

}