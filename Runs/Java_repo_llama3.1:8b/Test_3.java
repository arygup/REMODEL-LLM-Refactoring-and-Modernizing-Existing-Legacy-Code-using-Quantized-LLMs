public class Test_3 {

    public static void main(String[] args) {
        long c_i_val = 123456;
        float c_f_val = Float.intBitsToFloat(c_i_val);
    
        System.out.printf("Float: %f, Int bits: 0x%x\n", c_f_val, c_i_val);
        
        c_i_val = 1098765432L;
        c_f_val = Float.intBitsToFloat(c_i_val);
    
        System.out.printf("Int: %d, Float bits: %f\n", (int) c_i_val, c_f_val);
    }

}