public class Test_12 {

    public static void main(String[] args) {
        int s = 0; // Since STOPPED == 0 in this context
    
        s++;
    
        if (s == 1) { // RUNNING == 2 in C, but we're using enum constants here
            System.out.println("Status is RUNNING (1)");
        }
    
        System.out.println("Status int value: " + s);
    }

}