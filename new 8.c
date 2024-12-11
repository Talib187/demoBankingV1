#include <stdio.h>
#include <stdlib.h>

// Definition of the node
struct Node {
    int data;
    struct Node* next;
};

// Function to push an element onto the stack
void push(struct Node** top_ref, int new_data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    if (!newNode) {
        printf("Stack Overflow\n");
        return;
    }
    newNode->data = new_data;
    newNode->next = *top_ref;
    *top_ref = newNode;
}

// Function to pop an element from the stack
int pop(struct Node** top_ref) {
    if (*top_ref == NULL) {
        printf("Stack Underflow\n");
        return -1;
    }
    struct Node* temp = *top_ref;
    *top_ref = (*top_ref)->next;
    int popped = temp->data;
    free(temp);
    return popped;
}

// Function to peek at the top element of the stack
int peek(struct Node* top) {
    if (top == NULL) {
        printf("Stack is empty\n");
        return -1;
    }
    return top->data;
}

// Function to check if the stack is empty
int isEmpty(struct Node* top) {
    return top == NULL;
}

// Function to print the stack
void printStack(struct Node* top) {
    printf("Stack: ");
    while (top != NULL) {
        printf("%d -> ", top->data);
        top = top->next;
    }
    printf("NULL\n");
}

int main() {
    struct Node* stack = NULL;

    push(&stack, 10);
    push(&stack, 20);
    push(&stack, 30);

    printStack(stack);

    printf("Top element is %d\n", peek(stack));

    printf("Popped element is %d\n", pop(&stack));
    printf("Popped element is %d\n", pop(&stack));

    printStack(stack);

    printf("Is stack empty? %s\n", isEmpty(stack) ? "Yes" : "No");

    return 0;
}
