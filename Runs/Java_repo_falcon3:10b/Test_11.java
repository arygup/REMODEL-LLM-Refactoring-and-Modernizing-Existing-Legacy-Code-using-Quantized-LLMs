public class Test_11 {

    public static void main(String[] args) {
      byte c = (byte) 200;
      System.out.printf("Unsigned char: %u\n", c & 0xFF);
      if (c > 150) {
        System.out.printf("c is greater than 150\n");
      }
    }

}