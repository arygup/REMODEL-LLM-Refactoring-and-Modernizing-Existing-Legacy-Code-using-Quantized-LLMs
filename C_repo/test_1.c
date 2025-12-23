#include <stdio.h>

int main() {
    int arr[] = {10, 20, 30, 40, 50};
    int *p = arr; // p points to arr[0]

    printf("%d\n", *p); // 10

    // Test pointer increment
    p++; // p now points to arr[1]
    printf("%d\n", *p); // 20

    // Test pointer addition
    printf("%d\n", *(p + 2)); // arr[1 + 2] = arr[3] = 40

    return 0;
}



