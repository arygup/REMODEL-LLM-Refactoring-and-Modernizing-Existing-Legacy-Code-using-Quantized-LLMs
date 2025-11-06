public class Test_7 {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) { return a - b; }

    public static int calculate(int x, int y, java.util.function.BiFunction<Integer, Integer, Integer> op) { return op.apply(x, y); }

    public static void main(String[] args) {
        java.util.function.BiFunction<Integer, Integer, Integer> addPtr = Add::add;
        System.out.printf("Add: %d\n", calculate(10, 5, addPtr));
        System.out.printf("Subtract: %d\n", calculate(10, 5, Subtract::subtract));
    }

}