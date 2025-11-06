public class Test_14 {

    public static void main(String[] args) {
        char[] dest = new char[50];
        char[] src = {'W', 'o', 'r', 'l', 'd', '\0'};
        System.arraycopy(new char[]{'H', 'e', 'l', 'l', 'o', ' '}, 0, dest, 0, 6);
        System.arraycopy(src, 0, dest, 6, src.length);
        System.out.print("String: ");
        System.out.print(new String(dest));
        System.out.println();
        System.out.println("Length: " + (dest.length));
    }

}