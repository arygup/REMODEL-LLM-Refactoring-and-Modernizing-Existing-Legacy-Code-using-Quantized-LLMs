public class Test_10 {

    public static void createInt(Integer[] p) {
        p[0] = new Integer(42);
    }

    public static void main(String[] args) {
            // Simulate a pointer using an int array of size 1
            int[] myIntPtr = new int[1];
    
            // Call createInt, which will modify the value of myIntPtr[0]
            createInt(myIntPtr);
    
            // Check if the pointer was successfully allocated
            if (myIntPtr[0] != 0) {
                System.out.printf("Value from out-param: %d\n", myIntPtr[0]);
            }
        }

}