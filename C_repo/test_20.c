#include <stdio.h>

// Tests a 'switch' statement with C-style fall-through.
// Java 'switch' also has fall-through (if 'break' is
// omitted), so this should be a direct translation,
// but it's an important control flow to verify.

int main() {
    int i = 2;
    switch (i) {
        case 1:
            printf("Case 1\n");
        case 2:
            printf("Case 2 (fall-through)\n"); // Should print
        case 3:
            printf("Case 3 (fall-through)\n"); // Should also print
            break;
        case 4:
            printf("Case 4\n");
            break;
        default:
            printf("Default\n");
    }
    return 0;
}


