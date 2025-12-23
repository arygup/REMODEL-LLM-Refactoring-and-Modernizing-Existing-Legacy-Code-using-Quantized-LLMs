#include <stdio.h>

// Tests handling of bitfields in a struct.
// Java has no bitfields, so this requires complex
// private data members with manual bit-masking and shifting.

struct Flags {
    unsigned int a : 1;
    unsigned int b : 3;
    unsigned int c : 7;
};

int main() {
    struct Flags f;
    f.a = 1;
    f.b = 5; // 101 in binary
    f.c = 100; // 1100100 in binary
    
    printf("Flag a: %u\n", f.a);
    printf("Flag b: %u\n", f.b);
    printf("Flag c: %u\n", f.c);
    
    // Test overflow
    f.b = 10; // 1010 in binary, should be truncated to 010 (2)
    printf("Flag b (overflow): %u\n", f.b);
    return 0;
}



