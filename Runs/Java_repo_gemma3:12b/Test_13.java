public class Test_13 {

    public static void main(String[] args) {
        int i = 0;
        do {
            System.out.println("i = " + i);
            i++;
            if (i < 5) {
                continue;
            }
        } while (false);
        System.out.println("Loop finished.");
    }

}