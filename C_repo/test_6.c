#include <stdio.h>

int main() {
    int error = 1; // Simulate an error
    
    printf("Step 1\n");
    
    if (error) {
        goto cleanup;
    }
    
    printf("Step 2 (should not run)\n");

cleanup:
    printf("Cleaning up...\n");
    printf("Exiting.\n");
    
    return 0;
}