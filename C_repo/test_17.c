#include <stdio.h>

// Tests a multi-line macro.
// The translator must correctly handle the '\' line
// continuations and inline the entire block.

#define PRINT_VALUES(a, b) \
    printf("Value A: %d\n", a); \
    printf("Value B: %d\n", b); \
    printf("Sum: %d\n", a + b)

int main() {
    int x = 10;
    int y = 20;
    PRINT_VALUES(x, y);
    return 0;
}