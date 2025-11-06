public class Test_3 {

    public static void main(String[] args) {
      float f_val = 123.456f;
      long i_val = Float.floatToIntBits(f_val);
    
      System.out.printf("Float: %f, Int bits: %d%n", f_val, i_val);
    
      i_val = 1098765432L & 0xFFFFFFFFL;
      f_val = Float.intBitsToFloat((int)i_val);
    
      System.out.printf("Int: %d, Float bits: %f%n", (int)i_val, f_val);
    }

}