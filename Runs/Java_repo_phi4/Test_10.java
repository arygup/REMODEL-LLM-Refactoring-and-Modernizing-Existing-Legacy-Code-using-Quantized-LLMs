public class Test_10 {

    public static void createInt(Integer[] p) {
        if (p == null || p.length != 1) {
            throw new IllegalArgumentException("Expected a single-element array reference");
        }
        
        // Allocate memory for an integer and initialize it to 42
        p[0] = 42;
    }

    public static void main(String[] args) {
            int myIntPtrIndex = 0;
            int[] myIntPtrArray = createInt();
            if (myIntPtrArray != null) {
                System.out.printf("Value from out-param: %d\n", myIntPtrArray[myIntPtrIndex]);
            }
        }

}