public class Test_16 {

    public static final int g_counter = 10;

    public static void increment_global() {
        g_counter += 5;
    }

    public static void main(String[] args) {
        int g_counter = 10;
        
        System.out.println("Global: %d".formatted(g_counter));
        incrementGlobal();
        System.out.println("Global after func: %d".formatted(g_counter));
        g_counter = 1;
        System.out.println("Global after main: %d".formatted(g_counter));
    }

}