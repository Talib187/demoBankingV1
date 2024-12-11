#include <stdio.h>

int main() {
    int number;

    printf("Enter a non-negative integer: ");
    scanf("%d", &number);

    long factorial = 1;
    for (int i = 1; i <= number; ++i) {
        factorial = factorial*i;
    }

    printf("Factorial of %d = %ld\n", number, factorial);

    return 0;
}
