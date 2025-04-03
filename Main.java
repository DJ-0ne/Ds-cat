/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.main;


//This is the code for a binary search tree and all its operations with explanation:
/*group members are:
    CHRISPINE OKELLO EDS/B/01-04472/2024
    Alvin Makongele Com/b/01-55681/2022
    DAVID JAOKO SIT/B/01-03271/2023
    AARON MUTUA SIT/B/01-03253/2023
*/

class Node {
    int v;       
    Node l;      
    Node r;    

  
    public Node(int value) {
        this.v = value;
        l = null;
        r = null;
    }
}

class BinaryTree {

    // Insert a node into the binary tree
    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);  // If the tree is empty, create a new node
        }
        if (value < root.v) {
            root.l = insert(root.l, value);
        } else {
            root.r = insert(root.r, value); 
        }
        return root;
    }

    // Inorder Traversal: Left ->
    public void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.l);         
            System.out.print(root.v + " ");  
            inorderTraversal(root.r);        
        }
    }
    public void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.v + " "); 
            preorderTraversal(root.l);       
            preorderTraversal(root.r);     
        }
    }

    // Postorder Traversal: Left -> Right -> Root
    public void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.l);      
            postorderTraversal(root.r);    
            System.out.print(root.v + " ");
        }
    }

    // Binary search
    public boolean search(Node root, int value) {
        if (root == null) {
            return false;  
        }
        if (root.v == value) {
            return true;   
        }
        if (value < root.v) {
            return search(root.l, value); 
        }
        return search(root.r, value);   
    }

    // Delete a node from the binary tree
    public Node delete(Node root, int value) {
        if (root == null) {
            return null; 
        }

        // Traverse the tree to find the node to delete
        if (value < root.v) {
            root.l = delete(root.l, value);  
        } else if (value > root.v) {
            root.r = delete(root.r, value);
        } else {
            // Node to be deleted found
            if (root.l == null) {
                return root.r;  
            } else if (root.r == null) {
                return root.l;   
            }

            // Case: Node with two children
            Node successor = findMin(root.r); 
            root.v = successor.v;         
            root.r = delete(root.r, successor.v); 
        }
        return root;
    }

    // Find the minimum value node in a subtree
    private Node findMin(Node root) {
        while (root.l != null) {
            root = root.l;
        }
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a binary tree
        BinaryTree tree = new BinaryTree();
        Node root = null;

        // Insert nodes into the binary tree
        root = tree.insert(root, 22);
        root = tree.insert(root, 25);
        root = tree.insert(root, 4);
        root = tree.insert(root, 3);
        root = tree.insert(root, 7);
        root = tree.insert(root, 27);
        root = tree.insert(root, 18);
        
         System.out.println("\nSearch for value 7:");
        System.out.println(tree.search(root, 7));  

        // Display the tree using different traversals

          System.out.println("\nPreorder Traversal:");
        tree.preorderTraversal(root);

        System.out.println("\nPostorder Traversal:");
        tree.postorderTraversal(root);
        
    System.out.println("Inorder Traversal:");
        tree.inorderTraversal(root);  

        // Delete a node from the binary tree
        System.out.println("\nDeleting node with value 80:");
        root = tree.delete(root, 80);

        // Display the tree after deletion
        System.out.println("Inorder Traversal after deletion:");
           tree.inorderTraversal(root);  
    }
}
