public class Test_10 {

    public static void createInt(int[][] p) {
      p[0][0] = 42;
    }

    public static void createInt(int[] ptr) {
        ptr[0] = 10;
    }
    
    public static void main(String[] args) {
        int[] myIntPtr = new int[1];
        createInt(myIntPtr);
        if (myIntPtr[0] != 0) {
            System.out.println("Value from out-param: " + myIntPtr[0]);
            myIntPtr[0] = 0;
        }
    }

}