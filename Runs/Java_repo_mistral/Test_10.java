public class Test_10 {

    public static void createInt(int[] p) {
        p[0] = new int[1];
        p[0][0] = 42;
    }

    public static void main(String[] args) {
        IntegerPtr myIntPtr = new IntegerPtr();
        createInt(myIntPtr);
        if (myIntPtr.value != null) {
            System.out.printf("Value from out-param: %d\n", myIntPtr.value);
            myIntPtr.value = null;
        }
    }

}