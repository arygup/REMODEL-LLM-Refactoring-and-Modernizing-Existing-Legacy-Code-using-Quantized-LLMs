public class Test_12 {

    public static void main(String[] args) {
        Status s = Status.STOPPED;
        s = s + 1;
        if (s == Status.RUNNING) {
            System.out.println("Status is RUNNING (1)");
        }
        System.out.printf("Status int value: %d\n", s);
    }

}