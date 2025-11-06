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

    public static int calculate(int a, int b, IntegerFunction func) {
      return func.applyAsInt(a, b);
    }
    
    interface IntegerFunction {
      int applyAsInt(int a, int b);
    }

}