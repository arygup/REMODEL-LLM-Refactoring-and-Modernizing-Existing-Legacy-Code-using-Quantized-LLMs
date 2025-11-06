public class Test_14 {

    public static void main(String[] args) {
        char dest[50];
        char src[] = "World";
        strcpy(dest, "Hello ");
        strcat(dest, src);
        printf("String: %s\n", dest);
        printf("Length: %lu\n", strlen(dest));
        return 0;
    }

}