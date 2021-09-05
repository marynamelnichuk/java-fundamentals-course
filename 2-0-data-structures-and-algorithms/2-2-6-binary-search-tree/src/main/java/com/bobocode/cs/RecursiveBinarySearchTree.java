package com.bobocode.cs;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class RecursiveBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {

    private static class Node<T> {
        T value;
        Node<T> right;
        Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> root = null;
    private int size = 0;

    public static <T extends Comparable<T>> RecursiveBinarySearchTree<T> of(T... elements) {
        RecursiveBinarySearchTree<T> tree = new RecursiveBinarySearchTree<>();
        Stream.of(elements).forEach(tree::insert);
        return tree;
    }

    @Override
    public boolean insert(T element) {
        if (Objects.isNull(root)) {
            root = new Node<>(element);
            size++;
            return true;
        } else {
            return insert(element, root);
        }
    }

    private boolean insert(T element, Node<T> node) {
        if (element.compareTo(node.value) == -1) { //elem less
            if (node.left == null) {
                node.left = new Node<>(element);
                size++;
                return true;
            } else {
                return insert(element, node.left);
            }
        } else if (element.compareTo(node.value) == 1) {
            if (node.right == null) {
                node.right = new Node<>(element);
                size++;
                return true;
            } else {
                return insert(element, node.right);
            }
        } else {
            return false; //element already exists
        }
    }

    @Override
    public boolean contains(T element) {
        return contains(element, root);
    }

    public boolean contains(T element, Node<T> node) {
        if (element.compareTo(node.value) == 0) {
            return true;
        } else {
            if (node.left != null) {
                return contains(element, node.left);
            } else if (node.right != null) {
                return contains(element, node.right);
            } else {
                return false;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int depth() {
        return root != null ? depth(root) - 1 : 0;
    }

    private int depth(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(node.left), depth(node.right));
        }
    }

    @Override
    public void inOrderTraversal(Consumer<T> consumer) {
        inOrderTraversal(consumer, root);
    }

    private void inOrderTraversal(Consumer<T> consumer, Node<T> node) {
        if (node != null) {
            inOrderTraversal(consumer, node.left);
            consumer.accept(node.value);
            inOrderTraversal(consumer, node.right);
        }
    }
}
