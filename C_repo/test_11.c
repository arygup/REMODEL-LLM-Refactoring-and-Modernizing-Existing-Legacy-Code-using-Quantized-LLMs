#include <stdio.h>

// Tests handling of 'unsigned char'.
// C 'unsigned char' (0 to 255) is often used for binary data.
// Java's 'byte' is signed (-128 to 127).
// A naive cast will corrupt data. Correct translation requires
// using a Java 'int' and masking with '& 0xFF'.

int main() {
    unsigned char c = 200; // 200 is a valid unsigned char
    
    printf("Unsigned char: %u\n", c);
    
    if (c > 150) {
        printf("c is greater than 150\n");
    }
    return 0;
}