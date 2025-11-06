public class Test_12 {

    public static void main() {
      int s = 0; // Initialize s to STOPPED
      s += 1; // Increment s by 1
      if (s == 1) { // Check if s is RUNNING
        System.out.println("Status is RUNNING (1)"); // Print the status
      }
      System.out.println("Status int value: " + s); // Print the status integer value
    }

}