public class Test_14 {

    public static void main(String[] args) {
      String dest = "Hello ";
      String src = "World";
      dest += src;
      System.out.printf("String: %s\n", dest);
      System.out.printf("Length: %lu\n", (long) dest.length());
    }

}