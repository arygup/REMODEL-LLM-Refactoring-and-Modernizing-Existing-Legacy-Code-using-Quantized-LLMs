public class Test_3 {

    public static void main(String[] args) {
        int bits;
        bits = Float.floatToIntBits(123.456f);
        System.out.printf("Float: %f, Int bits: %d\n", Float.intBitsToFloat(bits), bits);
        bits = 1098765432;
        System.out.printf("Int: %d, Float bits: %f\n", bits, Float.intBitsToFloat(bits));
        return;
    }

}