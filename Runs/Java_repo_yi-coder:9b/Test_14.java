public class Test_14 {

    public static void main(String[] args) {
      char[] dest = new char[50];
      char[] src = "World".toCharArray();
      System.arraycopy("Hello ".toCharArray(), 0, dest, 0, "Hello ".length());
      for (int i=0; i<src.length; ++i) {
        dest[i+"Hello ".length()] = src[i];
      }
      System.out.printf("String: %s\n", new String(dest, 0, dest.length));
      System.out.printf("Length: %d\n", dest.length);
    }

}