public class Test_7 {

    public static int add(int a, int b) {
            return a + b;
        }

    public static int subtract(int a, int b) {
      return a - b;
    }

    public static int calculate(int x, int y, java.util.function.IntBinaryOperator op) {
      return op.applyAsInt(x, y);
    }

    public static int add(int a, int b) {
        return a + b;
      }
    
      public static int subtract(int a, int b) {
        return a - b;
      }
    
      public static int calculate(int a, int b, int (*func)(int, int)) {
        return func(a, b);
      }
    
      public static void main(String[] args) {
        int (*add_ptr)(int, int) = &add;
        System.out.println("Add: " + calculate(10, 5, add_ptr));
        System.out.println("Subtract: " + calculate(10, 5, &subtract));
      }

}