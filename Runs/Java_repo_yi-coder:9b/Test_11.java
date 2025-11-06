public class Test_11 {

    public static void main(String[] args) {
        byte c = (byte)200;  // The byte type is equivalent to the C unsigned char.
        System.out.printf("Unsigned char: %d\n", ((int)c & 0xFF)); // Use & 0xFF to convert signed byte to unsigned.
        if (((int)c & 0xFF) > 150) {
            System.out.println("c is greater than 150\n");
        }
    }

}