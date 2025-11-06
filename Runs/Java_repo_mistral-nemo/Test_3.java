public class Test_3 {

    public static void main(String[] args) {
      float f = 123.456f;
      int i = Float.floatToIntBits(f);
      System.out.printf("Float: %.3f, Int bits: %d%n", f, i);
    
      i = 1098765432;
      f = Integer.toUnsignedLong(i).bitCount();
      System.out.printf("Int: %d, Float bits: %.3f%n", i, f);
    }

}