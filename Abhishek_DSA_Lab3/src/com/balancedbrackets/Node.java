package com.balancedbrackets;


import java.util.Stack;

public class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class FindPairInBST {

    private Node root;

    // Function to insert a new node into the BST
    private Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // Function to find a pair with a given sum in the BST
    private boolean findPair(Node root, int sum) {
        if (root == null) {
            return false;
        }

        Node left = root;
        Node right = root;

        // Use two stacks for inorder traversal
        Stack<Node> stackLeft = new Stack<>();
        Stack<Node> stackRight = new Stack<>();

        // Initialize inorder traversal from both sides
        while (true) {
            while (left != null) {
                stackLeft.push(left);
                left = left.left;
            }

            while (right != null) {
                stackRight.push(right);
                right = right.right;
            }

            // Check if stacks are empty
            if (stackLeft.isEmpty() || stackRight.isEmpty()) {
                break;
            }

            Node currentLeft = stackLeft.pop();
            Node currentRight = stackRight.pop();

            if (currentLeft.data + currentRight.data == sum) {
                System.out.println("Pair found: (" + currentLeft.data + ", " + currentRight.data + ")");
                return true;
            } else if (currentLeft.data + currentRight.data < sum) {
                left = currentLeft.right;
            } else {
                right = currentRight.left;
            }
        }

        System.out.println("Nodes with the given sum not found");
        return false;
    }

    public static void main(String[] args) {
        FindPairInBST tree = new FindPairInBST();
        int sum = 130;

        // Insert elements into the BST
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);

        // Find pair with the given sum
        tree.findPair(tree.root, sum);
    }
}
