public class Test_10 {

    public static void createInt(int[] p) {
        if (p != null && p.length > 0) {
            p[0] = 42;
        }
    }

    public static void main(String[] args) {
            Integer[] myIntPtrRef = new Integer[1];
            createInt(myIntPtrRef);
            
            if (myIntPtrRef[0] != null) {
                System.out.println("Value from out-param: " + myIntPtrRef[0]);
            }
        }

}