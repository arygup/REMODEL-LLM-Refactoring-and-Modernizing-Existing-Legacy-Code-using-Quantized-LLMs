public class Test_10 {

    public static void createInt(Integer[] p) {
        if (p == null || p.length < 1) {
            throw new IllegalArgumentException("Pointer array must be non-null and of length 1");
        }
        
        p[0] = Integer.valueOf(42);
    }

    public static void main(String[] args) {
        Integer myIntPtr = null;
        createInt(myIntPtr);
        if (myIntPtr != null) {
            System.out.println("Value from out-param: " + myIntPtr);
            free(myIntPtr);
        }
    }

}