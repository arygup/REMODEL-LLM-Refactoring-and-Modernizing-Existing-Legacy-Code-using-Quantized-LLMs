public class Test_5 {

    public static void main(String[] args) {
        long u_val = 4294967295L;
        System.out.printf("Original: %u\n", u_val);
        u_val  = (u_val + 1) & 0xFFFFFFFFL; // Adding one to unsigned int, which is emulated as a Java long with 32 bit length.
        System.out.printf("Overflow (+ 1): %u\n", u_val);
        u_val  = (u_val - 5) & 0xFFFFFFFFL; // Subtracting five from an unsigned int, which is emulated as a Java long with 32 bit length.
        System.out.printf("Underflow (- 5): %u\n", u_val);
    }

}