public class Test_10 {

    public static void createInt(Wrapper<Integer> p) {
      p.set((int)42);
    }

    public static void main(String[] args) {
            IntWrapper myIntPtr = new IntWrapper();
            createInt(myIntPtr);
            if (myIntPtr.value != 0) {
                System.out.printf("Value from out-param: %d\n", myIntPtr.value);
            }
        }

}