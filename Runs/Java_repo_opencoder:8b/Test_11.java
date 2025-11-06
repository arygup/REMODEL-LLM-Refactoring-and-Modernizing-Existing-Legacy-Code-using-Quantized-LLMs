public class Test_11 {

    public static void main(String[] args) {
        byte c = 200;
        System.out.println("Unsigned char: " + (c & 0xFF));
        if (c > 150) {
            System.out.println("c is greater than 150");
        }
    }

}