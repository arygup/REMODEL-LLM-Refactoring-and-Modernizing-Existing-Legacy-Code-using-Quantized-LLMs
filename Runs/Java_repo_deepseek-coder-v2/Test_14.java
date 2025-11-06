public class Test_14 {

    public static void main(String[] args) {
            char[] dest = new char[50];
            char[] src = "World".toCharArray();
            System.arraycopy(new String("Hello ").toCharArray(), 0, dest, 0, 6);
            System.arraycopy(src, 0, dest, 6, src.length);
            System.out.printf("String: %s\n", new String(dest));
            System.out.printf("Length: %d\n", (int)new String(dest).length());
        }

}