public class Test_14 {

    public static void main(String[] args) {
      char dest[] = new char[50];
      String src = "World";
      System.arraycopy("Hello ".toCharArray(), 0, dest, 0, "Hello ".length());
      System.arraycopy(src.toCharArray(), 0, dest, "Hello ".length(), src.length());
      System.out.println("String: " + new String(dest));
      System.out.println("Length: " + dest.length);
    }

}