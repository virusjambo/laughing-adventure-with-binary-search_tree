package deleteGivenNodeInBST;

public class BinarySearchTree<E extends Number> {

    /* 1*//*) Node to be deleted is leaf: Simply remove from the tree.

              50                            50
             /     \         delete(20)      /   \
            30      70       --------->    30     70
            /  \    /  \                     \    /  \
            20   40  60   80                   40  60   80
       2) Node to be deleted has only one child: Copy the child to the node and delete the child

              50                             50
            /     \         delete(30)      /   \
           30      70       --------->    40     70
            \    /  \                          /  \
            40  60   80                       60   80
       3) Node to be deleted has two children: Find inorder successor of the node. Copy contents of the inorder successor to the node and delete the inorder successor. Note that inorder predecessor can also be used.

               50                            60
            /     \         delete(50)      /   \
            30      70       --------->    40    70
            \    /  \                            \
            40  60   80                           80
    The important thing to note is, inorder successor is needed only when right child is not empty. In this particular case, inorder successor can be obtained by finding the minimum value in right child of the node.
*//*
*/
    //To store Root of BST
    Node<E> root;

    //Inner class to hold value of Node in a tree
    class Node<E> {
        Node<E> leftRef;
        Node<E> rightRef;
        E value;

        Node(E value) {
            this.leftRef = null;
            this.rightRef = null;
            this.value = value;
        }

    }

    //To insert elements
    Node<E> insert(E value, Node<E> node) {
        //Only executes if Root is null
        if (root == null)
            return root = new Node<E>(value);
        //return Leaf Node
        if (node == null)
            return new Node<E>(value);

        if (node.value.doubleValue() > value.doubleValue())
            node.leftRef = insert(value, node.leftRef);
        else
            node.rightRef = insert(value, node.rightRef);
        return node;
    }

    //Function to delete given node in BST
    Node<E> delete(E value, Node<E> node) {
        if (node == null)
            return null;
        //if node value is lesser than root node
        if (node.value.doubleValue() > value.doubleValue()) {
            node.leftRef = delete(value, node.leftRef);
            // else if node value is greater than root node
        } else if (node.value.doubleValue() < value.doubleValue()) {
            node.rightRef = delete(value, node.rightRef);
        } else {
            // else if node value is equal to root node
            //if roots left is null copy right node value to current Node
            if (node.leftRef == null) {
                Node<E> temp = node.rightRef;
                node = null;
                return temp;
            }
            //if roots right  is null copy  left node value to current Node
            if (node.rightRef == null) {
                Node<E> temp = node.leftRef;
                node = null;
                return temp;
            }
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            Node<E> temp = findMinValue(node.rightRef);
            node.value = temp.value;
            // Delete the inorder successor
            node.rightRef = delete(node.value, temp.rightRef);

        }
        return node;
    }

    //Traverse Tree
    void printAll(Node<E> root) {
        if (root == null)
            return;
        System.out.println(root.value);
        printAll(root.leftRef);
        printAll(root.rightRef);
    }

    /* Given a non-empty binary search tree, return the node with minimum
key value found in that tree. Note that the entire tree does not
need to be searched. */
    Node<E> findMinValue(Node<E> root) {
        while (root.leftRef != null) {
            root = root.leftRef;
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(50, bst.root);
        bst.insert(45, bst.root);
        bst.insert(40, bst.root);
        bst.insert(48, bst.root);
        bst.insert(38, bst.root);
        bst.insert(65, bst.root);
        bst.insert(58, bst.root);
        bst.insert(66, bst.root);
        System.out.println("ALL NODES");
        bst.printAll(bst.root);
        System.out.println("-------------------------------------------");
        System.out.println("Delete Results:");
        System.out.println("Deleting  root:");
        bst.delete(50, bst.root);
        bst.printAll(bst.root);
        System.out.println("Deleting  left leaf:");
        bst.delete(38, bst.root);
        bst.printAll(bst.root);
        System.out.println("Deleting  right leaf:");
        bst.delete(66, bst.root);
        bst.printAll(bst.root);

    }
}

