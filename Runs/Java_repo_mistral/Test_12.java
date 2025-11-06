public class Test_12 {

    public static void main(String[] args) {
        Status s = STOPPED;
        s = (Status)(s + 1); // Need to cast because '+' does not work with enums in Java without a cast
        if (s == RUNNING) {
            System.out.println("Status is RUNNING (1)");
        }
        System.out.printf("Status int value: %d%n", s);
    }

}