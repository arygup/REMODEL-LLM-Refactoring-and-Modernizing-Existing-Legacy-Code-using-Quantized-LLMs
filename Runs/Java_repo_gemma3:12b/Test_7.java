public class Test_7 {

    public static int add(int a, int b)
    {
      return a + b;
    }

    public static int subtract(int a, int b)
    {
      return a - b;
    }

    public static int calculate(int x, int y, java.util.function.BiFunction<Integer, Integer, Integer> op) {
        return op.apply(x, y);
    }

    public static int calculate(int a, int b, Function<Integer, Integer> operation) {
        int result = operation.apply(a, b);
        return result;
    }
    
    public static void main(String[] args) {
        int result1 = calculate(10, 5, (x, y) -> x + y);
        System.out.printf("Add: %d\n", result1);
        int result2 = calculate(10, 5, (x, y) -> x - y);
        System.out.printf("Subtract: %d\n", result2);
    }

}