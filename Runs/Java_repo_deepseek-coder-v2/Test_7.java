public class Test_7 {

    public static int add(int a, int b) {
      return a + b;
    }

    public static int subtract(int a, int b) {
      return a - b;
    }

    public static int calculate(int x, int y, java.util.function.BiFunction<Integer, Integer, Integer> op) {
        return op.apply(x, y);
    }

    public static void main(String[] args) {
      int add_result = calculate(10, 5, new IntBinaryOperator() {
        public int applyAsInt(int a, int b) {
          return a + b;
        }
      });
      System.out.println("Add: " + add_result);
      
      int subtract_result = calculate(10, 5, new IntBinaryOperator() {
        public int applyAsInt(int a, int b) {
          return a - b;
        }
      });
      System.out.println("Subtract: " + subtract_result);
    }

}