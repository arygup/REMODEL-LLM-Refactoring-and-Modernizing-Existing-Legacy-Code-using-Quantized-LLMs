#include <stdio.h>
#include <string.h>

// Tests translation of C's string.h library.
// C 'char*' strings are null-terminated, which is
// fundamentally different from Java's 'String' objects.
// 'strcpy'/'strcat' must become Java 'String' manipulation.

int main() {
    char dest[50];
    char src[] = "World";
    
    strcpy(dest, "Hello ");
    strcat(dest, src);
    
    printf("String: %s\n", dest);
    printf("Length: %lu\n", strlen(dest));
    return 0;
}