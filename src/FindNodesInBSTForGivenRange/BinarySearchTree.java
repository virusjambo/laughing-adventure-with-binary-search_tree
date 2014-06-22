package FindNodesInBSTForGivenRange;


public class BinarySearchTree<E extends Number> {


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

    //I am not giving any comments for this.Find Logic on your own.Its easy one....
    void findElementsInGivenRange(Node<E> root, E low, E high) {


        if (root == null) {
            return;
        }

        if (root.value.doubleValue() > low.doubleValue() && root.value.doubleValue() < high.doubleValue())
            System.out.println(root.value);

        if (root.value.doubleValue() > low.doubleValue() || root.value.doubleValue() > high.doubleValue()) {
            findElementsInGivenRange(root.leftRef, low, high);
        }

        if (root.value.doubleValue() < low.doubleValue() || root.value.doubleValue() < high.doubleValue()) {
            findElementsInGivenRange(root.rightRef, low, high);
        }

    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        // 20, 8, 22, 4, 12, 10, 14
        bst.insert(20, bst.root);
        bst.insert(8, bst.root);
        bst.insert(22, bst.root);
        bst.insert(4, bst.root);
        bst.insert(12, bst.root);
        bst.insert(10, bst.root);
        bst.insert(14, bst.root);

        System.out.println("-------------------------------------------");
        //if key is greater than total number of elements I am returning last node in Inorder traverse
        bst.findElementsInGivenRange(bst.root, 0, 22);

    }
}

