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

    public static void main(String[] args) {
      BinaryOperation add_ptr = Calculator::add;
      System.out.println("Add: " + calculate(10, 5, add_ptr));
      System.out.println("Subtract: " + calculate(10, 5, Calculator::subtract));
    }

}