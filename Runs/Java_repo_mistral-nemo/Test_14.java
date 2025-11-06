public class Test_14 {

    public static void main(String[] args) {
      char[] dest = new char[50];
      String src = "World";
      System.arraycopy("Hello ".toCharArray(), 0, dest, 0, "Hello ".length());
      for (int i = "Hello ".length(); i < dest.length; i++) {
        dest[i] = '\u0000';
      }
      int srcLength = Math.min(dest.length - String.valueOf(dest).lastIndexOf('\u0000'), src.length());
      System.arraycopy(src.toCharArray(), 0, dest, "Hello ".length(), srcLength);
      System.out.println("String: " + new String(dest));
      System.out.println("Length: " + new String(dest).length());
    }

}