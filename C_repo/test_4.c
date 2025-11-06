#include <stdio.h>
// A macro with dangerous side effects
#define MAX(a,b) ((a) > (b) ? (a) : (b))

int main() {
    int i = 5;
    int j = 10;
    
    // C code expands to: k = ((i++) > (j++) ? (i++) : (j++));
    // 1. (5 > 10) is false. i becomes 6, j becomes 11.
    // 2. The result is (j++), which is 11. k becomes 11.
    // 3. j becomes 12.
    int k = MAX(i++, j++);
    
    printf("k: %d, i: %d, j: %d\n", k, i, j);
    return 0;
}