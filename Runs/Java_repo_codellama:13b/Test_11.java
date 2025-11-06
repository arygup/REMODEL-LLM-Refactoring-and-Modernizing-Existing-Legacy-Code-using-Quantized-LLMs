public class Test_11 {

    public static void main(String[] args) {
      // unsigned char c = 200;
      byte c = (byte) 200;
      System.out.println("Unsigned char: " + c);
      if ((c & 0xFF) > 150) {
        System.out.println("c is greater than 150");
      }
    }

}