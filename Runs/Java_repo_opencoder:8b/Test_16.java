public class Test_16 {

    public static int g_counter = 10;

    public static void increment_global() {
       g_counter += 5;
    }

    public static void main(String[] args) {
        g_counter = 10;
        System.out.printf("Global: %d\n", g_counter);
        increment_global();
        System.out.printf("Global after func: %d\n", g_counter);
        g_counter = 1;
        System.out.printf("Global after main: %d\n", g_counter);
    }

}