public class Test_3 {

    public static void main(String[] args) {
        int p_index = 0;
        float f_val = 123.456f;
        System.out.println("Float: " + f_val + ", Int bits: " + Float.floatToIntBits(f_val));
    
        int i_val = 10_98765_432;
    
        System.out.println("Int: " + i_val + ", Float bits: " + f_val);
    
        // Assuming Point class and copy constructor exists
        Point p_val_orig = new Point(100, 200);
        move_copy(p_val_orig);
    
        return;
    }

}