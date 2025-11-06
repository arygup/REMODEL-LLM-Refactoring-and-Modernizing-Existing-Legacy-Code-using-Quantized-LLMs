public class Test_20 {

    public static void main(String[] args) {
        int i = 2;
        String[] cases = {"Case 1\n", "Case 2 (fall-through)\n", "Case 3 (fall-through)\n", "Case 4\n"};
        for (int j = 0; j < cases.length; j++) {
            if (i == j + 1) {
                System.out.println(cases[j]);
                if (j != cases.length - 1) break; // Break if it's not the last case
            }
        }
        if (i > cases.length) {
            System.out.println("Default");
        }
    }

}