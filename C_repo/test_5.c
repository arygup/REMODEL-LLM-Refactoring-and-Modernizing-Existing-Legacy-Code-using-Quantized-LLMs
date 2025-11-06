#include <stdio.h>

int main() {
    unsigned int u_val = 4294967295; // (2^32 - 1)
    
    printf("Original: %u\n", u_val);
    
    // Test overflow
    u_val = u_val + 1;
    printf("Overflow ( + 1): %u\n", u_val); // Wraps to 0
    
    // Test underflow
    u_val = u_val - 5;
    printf("Underflow ( - 5): %u\n", u_val); // Wraps to 4294967291
    
    return 0;
}