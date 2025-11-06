#include <stdio.h>

// Tests a 'goto' that jumps backward to create a loop.
// This is harder than the simple error-cleanup 'goto' and
// must be translated into a 'while' or 'do-while' loop.

int main() {
    int i = 0;
    
loop_start:
    printf("i = %d\n", i);
    i++;
    
    if (i < 5) {
        goto loop_start;
    }
    
    printf("Loop finished.\n");
    return 0;
}