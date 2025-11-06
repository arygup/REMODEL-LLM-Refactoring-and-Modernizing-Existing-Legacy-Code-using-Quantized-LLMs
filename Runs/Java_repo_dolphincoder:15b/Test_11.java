public class Test_11 {

    public static void main(String[] args) {
      byte c = (byte)200;
      System.out.format("Unsigned char: %u\n", c & 0xFF);
      if ((c & 0xFF) > 150) {
        System.out.println("c is greater than 150");
      }
    }

}