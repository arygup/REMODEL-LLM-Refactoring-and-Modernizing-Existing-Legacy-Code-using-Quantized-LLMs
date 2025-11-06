public class Test_3 {

    public static void main(String[] args) {
        float f_val = 123.456f;
        int i_bits = Float.floatToIntBits(f_val);
        System.out.printf("Float: %f, Int bits: %d\n", f_val, i_bits);
        f_val = Float.intBitsToFloat(1098765432);
        System.out.printf("Int: %d, Float bits: %f\n", 1098765432, f_val);
    }

}