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

    public static int add(int x, int y) {
            return x + y;
        }
    
        public static int subtract(int x, int y) {
            return x - y;
        }
    
        public static int calculate(int a, int b, BiFunction<Integer, Integer, Integer> operation) {
            return operation.apply(a, b);
        }
    
        public static void main(String[] args) {
            System.out.println("Add: " + calculate(10, 5, Main::add));
            System.out.println("Subtract: " + calculate(10, 5, Main::subtract));
        }

}