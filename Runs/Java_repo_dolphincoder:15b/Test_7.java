public class Test_7 {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
      return a - b;
    }

    public static int calculate(int x, int y, IntBinaryOperator op) {
      return op.applyAsInt(x, y);
    }

    public static int calculate(int a, int b, Function<Integer, Integer> func) {
      return func.apply(a + b);
    }
    
    // C function add
    public static int add(int a, int b) {
      return a + b;
    }
    
    // C function subtract
    public static int subtract(int a, int b) {
      return a - b;
    }
    
    public static void main(String[] args) {
      Function<Integer, Integer> add_ptr = DolphinCoder::add;
    
      System.out.printf("Add: %d\n", calculate(10, 5, add_ptr));
      System.out.printf("Subtract: %d\n", calculate(10, 5, DolphinCoder::subtract));
    }

}