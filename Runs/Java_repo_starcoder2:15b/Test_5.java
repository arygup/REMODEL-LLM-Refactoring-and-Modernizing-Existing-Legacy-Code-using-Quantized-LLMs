public class Test_5 {

    public static int main() {
      long u_val = 4294967295L & 0xFFFFFFFFL;
      System.out.printf("Original: %d%n", (int)u_val);
      u_val = ((u_val + 1L) & 0xFFFFFFFFL);
      System.out.printf("Overflow (+1): %d%n", (int)u_val);
      u_val = ((u_val - 5L) & 0xFFFFFFFFL);
      System.out.printf("Underflow (-5): %d%n", (int)u_val);
      return 0;
    }

}