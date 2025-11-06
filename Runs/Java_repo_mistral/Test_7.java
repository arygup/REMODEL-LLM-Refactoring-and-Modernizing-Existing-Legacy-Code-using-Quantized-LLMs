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
        int[] arr = {10, 5};
        Function<Integer, Integer> add_ptr = i -> i + i;
        System.out.printf("Add: %d\n", calculate(arr[0], arr[1], add_ptr));
        Function<Integer, Integer> subtract = i -> i - i;
        System.out.printf("Subtract: %d\n", calculate(arr[0], arr[1], subtract));
    }

}