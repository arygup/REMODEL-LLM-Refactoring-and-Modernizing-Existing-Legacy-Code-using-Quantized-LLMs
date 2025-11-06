public class Test_5 {

    public static void main(String[] args) {
        long u_val = 4294967295L;
        System.out.println("Original: " + Long.toHexString(u_val & 0xFFFFFFFFL));
        u_val = (u_val + 1) & 0xFFFFFFFFL;
        System.out.println("Overflow ( + 1): " + Long.toHexString(u_val & 0xFFFFFFFFL));
        u_val = (u_val - 5) & 0xFFFFFFFFL;
        System.out.println("Underflow ( - 5): " + Long.toHexString(u_val & 0xFFFFFFFFL));
        return 0;
      }

}