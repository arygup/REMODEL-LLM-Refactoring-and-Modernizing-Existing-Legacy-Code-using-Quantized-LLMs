public class Test_12 {

    public static int main() {
        Status s = Status.STOPPED;
        int sValue = s.getValue();
        sValue += 1;
    
        if (Status.RUNNING.getValue() == sValue) {
            System.out.println("Status is RUNNING (1)\n");
        }
    
        System.out.printf("Status int value: %d\n", sValue);
    
        return 0;
    }

}