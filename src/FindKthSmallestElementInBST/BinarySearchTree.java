package FindKthSmallestElementInBST;


import java.util.Stack;

public class BinarySearchTree<E extends Number> {
          //Given root of binary search tree and K as input, find K-th smallest element in BST
         //Logic is go with inOrder traverse
   // Method 1: Using Inorder Traversal.

   // Inorder traversal of BST retrieves elements of tree in the sorted order. The inorder traversal uses stack
  //  to store to be explored nodes of tree (threaded tree avoids stack and recursion for traversal).
  // The idea is to keep track of
   //   popped elements which participate in the order statics. Hypothetical algorithm is provided below,

    Stack< Node<E>>  stack=new Stack<Node<E>>();
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
 //Logic
    Node<E> findASmallestKthElement(Node<E> root,int key){
        //For tree if it is null
        Node<E> node=root;
        if(node==null)
         return null;
      //first traverse left subtree
       while(node!=null){
           stack.push(node);
           node=node.leftRef;
       }
        //now start popping elements from stack
      while(!stack.isEmpty()){
          node=stack.pop();
          key--;
       //We are decrementing key value if it reaches 0 we found our element........Yeah we got it here
       if(key==0)
           break;
       //if popped node has right edge then push right element on stack then traverse
       // left subtree and push each element on stack
         if(node.rightRef!=null){
             node=node.rightRef;
             while(node!=null){
                 stack.push(node);
                 node=node.leftRef;
             }
         }

      }
      return node ;
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
        System.out.println( bst.findASmallestKthElement(bst.root, 13).value);

    }
}

