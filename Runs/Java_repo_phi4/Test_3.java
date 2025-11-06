public class Test_3 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(4).order(ByteOrder.nativeOrder());
    
        // Float: 123.456000, Int bits: 1065353216
        float fVal = 123.456f;
        buffer.clear();
        buffer.putFloat(fVal);
        int iBitsFromFloat = buffer.getInt();
        System.out.printf("Float: %f, Int bits: %d\n", fVal, iBitsFromFloat);
    
        // Set integer value and get back the float representation
        buffer.clear();
        buffer.putInt(1098765432);
        float fValFromInt = buffer.getFloat();
    
        // Int: 1098765432, Float bits: 3.603390E-19
        System.out.printf("Int: %d, Float bits: %f\n", 1098765432, fValFromInt);
    }

}