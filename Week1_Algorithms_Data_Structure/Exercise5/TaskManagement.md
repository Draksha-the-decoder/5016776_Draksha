# Linked Lists

This repository contains implementations and descriptions of two fundamental types of linked lists: Singly Linked List and Doubly Linked List. Linked lists are common data structures used to store sequences of elements where each element points to the next one in the sequence.

## Singly Linked List

A singly linked list is a type of data structure that consists of nodes. Each node contains two elements: data and a reference (or link) to the next node in the sequence. The list starts with a head node, which is the first node in the list, and the last node points to null, indicating the end of the list. Operations like insertion and deletion are efficient in singly linked lists because they do not require shifting elements as in arrays.

### Structure

- **Node**: Contains the data and a reference to the next node.
- **Head**: The first node in the list.
- **Tail**: The last node in the list, which points to null.

### Operations

- **Insertion**: Add a new node at the beginning, end, or a specific position.
- **Deletion**: Remove a node from the beginning, end, or a specific position.
- **Traversal**: Navigate through the list from the head to the end.