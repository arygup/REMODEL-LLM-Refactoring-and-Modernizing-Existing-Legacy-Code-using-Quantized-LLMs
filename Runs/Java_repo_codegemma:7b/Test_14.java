public class Test_14 {

    public static void main(String[] args) {
        char[] dest = new char[50];
        String src = "World";
        System.arraycopy("Hello ", 0, dest, 0, 6);
        System.arraycopy(src.toCharArray(), 0, dest, 6, 5);
        System.out.printf("String: %s\n", dest);
        System.out.printf("Length: %d\n", dest.length);
    }

}