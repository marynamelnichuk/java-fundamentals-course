package com.bobocode.cs;

import com.bobocode.cs.exception.EmptyStackException;

/**
 * {@link LinkedStack} represents a last-in-first-out (LIFO) stack of objects that is based on singly linked generic nodes.
 * A node is implemented as inner static class {@link Node<T>}.
 *
 * @param <T> generic type parameter
 */
public class LinkedStack<T> implements Stack<T> {

    private Node<T> head = null;
    private int size = 0;

    private static class Node<T> {
        private final T value;
        private Node<T> next;
        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * This method creates a stack of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new stack of elements that were passed as method parameters
     */
    public static <T> LinkedStack<T> of(T... elements) {
        LinkedStack<T> linkedStack = new LinkedStack<>();
        for(T element : elements) {
            Node<T> newNode = new Node<>(element);
            newNode.next = linkedStack.head;
            linkedStack.head = newNode;
        }
        linkedStack.size = elements.length;
        return linkedStack;
    }

    /**
     * The method pushes an element onto the top of this stack. This has exactly the same effect as:
     * addElement(item)
     *
     * @param element elements to add
     */
    @Override
    public void push(T element) {
        if(element == null) {
            throw new NullPointerException();
        } else {
            Node<T> newNode = new Node<>(element);
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    /**
     * This method removes the object at the top of this stack
     * and returns that object as the value of this function.
     *
     * @return The object at the top of this stack
     * @throws EmptyStackException - if this stack is empty
     */
    @Override
    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            T valueToReturn = head.value;
            head = head.next;
            size--;
            return valueToReturn;
        }
    }

    /**
     * Returns the number of elements in the stack
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if a stack is empty
     *
     * @return {@code true} if a stack is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}