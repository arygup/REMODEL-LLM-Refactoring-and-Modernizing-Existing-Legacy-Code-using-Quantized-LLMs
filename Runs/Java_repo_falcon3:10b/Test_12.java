public class Test_12 {

    public static void main(String[] args) {
        enum Status { STOPPED, RUNNING }
        Status s = Status.STOPPED;
        s = Status.values()[(s.ordinal() + 1) % Status.values().length];
        if (s == Status.RUNNING) {
            System.out.printf("Status is RUNNING (1)\n");
        }
        System.out.printf("Status int value: %d\n", s.ordinal());
    }

}