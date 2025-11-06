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
        int add(int a, int b) {
            return a + b;
        }
    
        int subtract(int a, int b) {
            return a - b;
        }
    
        long calculate(long x, long y, long (*func)(long, long)) {
            return func(x, y);
        }
    
        int[] arr = new int[10];
        int p_index = 0;
        int[] p_array = arr;
        int k = add(10, 5); // Add: 15
        System.out.println("Add: " + k);
        k = subtract(10, 5); // Subtract: 5
        System.out.println("Subtract: " + k);
    }

}