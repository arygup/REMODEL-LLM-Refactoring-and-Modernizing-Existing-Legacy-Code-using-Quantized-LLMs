public class Test_7 {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
      return a - b;
    }

    public static int calculate(int x, int y, Operation op) {
        return op.apply(x, y);
    }

    public static int calculate(int a, int b, Calculator calculator) {
        return calculator.calculate(a, b);
    }
    
    interface Calculator {
        int calculate(int a, int b);
    }
    
    // Assuming the add and subtract functions are defined somewhere else in your program
    public static int add(int a, int b) {
      return a + b;
    }
    
    public static int subtract(int a, int b) {
        return a - b;
    }

}