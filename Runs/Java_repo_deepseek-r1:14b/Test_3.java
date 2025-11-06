public class Test_3 {

    public static void main(String[] args) {
        float f = 123.456f;
        int i = Float.floatToIntBits(f);
        System.out.printf("Float: %f, Int bits: %d\n", f, i);
        int ii = 1098765432;
        float fi = Float.intBitsToFloat(ii);
        System.out.printf("Int: %d, Float bits: %f\n", ii, fi);
    }

}