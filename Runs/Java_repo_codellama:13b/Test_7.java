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
        int (*add_ptr)(int, int) = &add;
        System.out.printf("Add: %d\n", calculate(10, 5, add_ptr));
        System.out.printf("Subtract: %d\n", calculate(10, 5, &subtract));
    }

}