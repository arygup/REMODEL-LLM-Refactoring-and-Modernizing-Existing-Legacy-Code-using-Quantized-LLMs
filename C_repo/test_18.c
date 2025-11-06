#include <stdio.h>

// Tests the 'sizeof' operator, especially on structs.
// Java has no 'sizeof'. The translator must either fail,
// hardcode a value (brittle), or remove it if possible.
// This is a true stress test.

struct Data {
    int a;
    char b;
    double c;
};

int main() {
    // This value is platform-dependent (due to padding/alignment)
    // but its *translation* is the test.
    printf("Size of int: %lu\n", sizeof(int));
    printf("Size of Data: %lu\n", sizeof(struct Data));
    printf("Size of Data*: %lu\n", sizeof(struct Data*));
    return 0;
}