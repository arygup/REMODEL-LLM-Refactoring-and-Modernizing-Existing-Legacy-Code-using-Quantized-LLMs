public class Test_20 {

    public static void main(String[] args) {
        int i = 2;
        switch (i) {
            case 1:
                System.out.printf("Case 1\n");
            case 2:
                System.out.printf("Case 2 (fall-through)\n");
            case 3:
                System.out.printf("Case 3 (fall-through)\n");
                break;
            case 4:
                System.out.printf("Case 4\n");
                break;
            default:
                System.out.printf("Default\n");
        }
    }

}