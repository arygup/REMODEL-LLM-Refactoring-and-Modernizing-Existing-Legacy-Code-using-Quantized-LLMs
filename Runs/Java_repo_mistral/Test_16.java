public class Test_16 {

    In Java, the given C global variable "int g_counter = 10" would be translated as a public static field with the initial value maintained. Given our translation rules:
    
    Type: `int` -> `int` (no change required)
    const: Not present in this example, but if it were, it would translate to no change since there's no equivalent keyword for 'const' in Java.
    unsigned: Not present in this example, but if `unsigned int` appeared, it would translate to `long`. If `unsigned char` appeared, it would translate to `int`.
    Visibility: All globals become 'public static'. In this case, since there's no qualifier (i.e., `static` or `extern`) in the C code, we assume it's a global variable and translate it to `public static int`.
    Output: `public static final int g_counter = 10;`

    private static int g_counter = 10;
    
      public static void increment_global() {
        g_counter += 5;
      }

    public static void main(String[] args) {
        int g_counter = 10;
        System.out.println("Global: " + g_counter);
        increment_global();
        System.out.println("Global after func: " + g_counter);
        g_counter = 1;
        System.out.println("Global after main: " + g_counter);
    }

}