public class Test_3 {

    public static void main(String[] args) {
        float f_val = 123.456f;
        int i_val = Float.floatToIntBits(f_val);
        System.out.println("Float: " + f_val + ", Int bits: " + i_val);
    
        i_val = 1098765432;
        f_val = Float.intBitsToFloat(i_val);
        System.out.println("Int: " + i_val + ", Float bits: " + f_val);
    }

}