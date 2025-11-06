public class Test_3 {

    public static void main(String[] args) {
            union {
                float f;
                int i;
            } c;
    
            c.f = 123.456f;
            System.out.printf("Float: %.2f, Int bits: %d\n", c.f, c.i);
    
            c.i = 1098765432;
            System.out.printf("Int: %d, Float bits: %.2f\n", c.i, c.f);
        }

}