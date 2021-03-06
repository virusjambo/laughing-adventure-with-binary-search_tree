package FindInorderSuccessorOfGivenNode;


public class BinarySearchTrees<E extends Number> {
    //In Binary Tree, Inorder successor of a node is the next node in
    // Inorder traversal of the Binary Tree. Inorder Successor is NULL for the last node in Inoorder traversal.
    //To store Root of BST
    Node<E> root;

    //Inner class to hold value of Node in a tree
    class Node<E> {
        Node<E> leftRef;
        Node<E> rightRef;
        E value;

        Node() {

        }

        Node(E value) {
            this.leftRef = null;
            this.rightRef = null;
            this.value = value;
        }

    }

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

    //////Lets think
    //Logic?
    //Check for given Node has right ref.If it has lets get Min value of that node which wll be our inorder successor.
    //if not then traverse a BST and each time when you pass through left edge of any node change the successor.
    // The last successor will be your inorder successor of given Node
    Node<E> findMinvalue(Node<E> root) {
        while (root.leftRef != null)
            root = root.leftRef;
        return root;

    }

    Node<E> findInorderSuccessor(Node<E> root, Node<E> givNode) {
        if (root == null)
            return null;
        if (givNode.rightRef != null) {
            return findMinvalue(givNode.rightRef);
        }
        Node<E> succ = null;
        while (root != null) {
            if (root.value.doubleValue() > givNode.value.doubleValue()) {
                root = root.leftRef;
                succ = root;
            } else if (root.value.doubleValue() < givNode.value.doubleValue()) {
                root = root.rightRef;
            } else
                break;
        }

        return succ;
    }


    public static void main(String[] args) {
        BinarySearchTrees<Integer> bst = new BinarySearchTrees<Integer>();
        bst.insert(7, bst.root);
        bst.insert(8, bst.root);
        bst.insert(9, bst.root);
        bst.insert(1, bst.root);
        bst.insert(2, bst.root);
        bst.insert(3, bst.root);

        BinarySearchTrees.Node node = null;
        node = bst.root.leftRef;
        System.out.println("-------------------------------------------");

        System.out.println( bst.findInorderSuccessor(bst.root, node).value);

    }


}

