public class Test_7 {

    public static int add(int a, int b) {
      return a + b;
    }

    public static int subtract(int a, int b) {
      return a - b;
    }

    public static int calculate(int x, int y, Function<Integer, Integer> op) {
      return op.apply(x, y);
    }

    public static void main(String[] args) {
        int add_ptr = add(0, 0);
        System.out.println("Add: " + calculate(10, 5, add_ptr));
        int subtract_ptr = subtract(0, 0);
        System.out.println("Subtract: " + calculate(10, 5, subtract_ptr));
    }

}