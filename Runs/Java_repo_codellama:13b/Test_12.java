public class Test_12 {

    public static void main(String[] args) {
        Status s = STOPPED;
        s = (Status)(s + 1);
        if (s == RUNNING) {
            System.out.println("Status is RUNNING (1)");
        }
        System.out.println("Status int value: " + s);
    }

}