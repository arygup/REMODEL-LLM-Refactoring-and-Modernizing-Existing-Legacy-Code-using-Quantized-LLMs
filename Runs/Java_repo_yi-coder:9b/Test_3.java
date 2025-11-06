public class Test_3 {

    public static void main(String[] args) {
        float fVal = 123.456f;
        int iVal = Float.floatToIntBits(fVal);
        System.out.printf("Float: %f, Int bits: %d%n", fVal, iVal);
        iVal = 1098765432;
        fVal = Float.intBitsToFloat(iVal);
        System.out.printf("Int: %d, Float bits: %f%n", iVal, fVal);
    }

}