public class Test_3 {

    public static void main(String[] args) {
      float f_val = 123.456f;
      int i = Float.floatToIntBits(f_val);
      System.out.printf("Float: %f, Int bits: %d\n", f_val, i);
    
      long l_val = 1098765432L;
      int i_masked = (int)(l_val & 0xFFFFFFFFL);
      System.out.printf("Int: %d, Float bits: %f\n", i_masked, Float.intBitsToFloat(i_masked));
    }

}