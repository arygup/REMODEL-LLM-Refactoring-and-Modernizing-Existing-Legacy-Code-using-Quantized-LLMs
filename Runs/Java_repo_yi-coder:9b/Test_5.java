public class Test_5 {

    public static void main(String[] args) {
        long u_val = 4294967295L; //Java doesn't have an unsigned int type, so we use long and mask arithmetic with & 0xFFFFFFFFL.
        System.out.printf("Original: %u\n", u_val);
        u_val = (u_val + 1) & 0xFFFFFFFFL; //Add one while ensuring the result remains unsigned.
        System.out.printf("Overflow ( + 1): %u\n", u_val);
        u_val = (u_val - 5) & 0xFFFFFFFFL;  //Subtract five and ensure the result remains unsigned.
        System.out.printf("Underflow ( - 5): %u\n", u_val);
    }

}