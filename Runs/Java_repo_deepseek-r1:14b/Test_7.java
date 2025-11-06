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
            int addResult = 10 + 5;
            int subtractResult = 10 - 5;
            System.out.printf("Add: %d\n", addResult);
            System.out.printf("Subtract: %d\n", subtractResult);
        }

}