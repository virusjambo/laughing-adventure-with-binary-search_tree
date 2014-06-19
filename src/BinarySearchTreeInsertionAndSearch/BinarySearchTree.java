package BinarySearchTreeInsertionAndSearch;

public class BinarySearchTree<E extends Number> {
	//To store Root of BST
	Node<E> root;
	
	//Inner class to hold value of Node in a tree
	class Node<E>{
		Node<E> leftRef;
		Node<E> rightRef;
		E value;
		Node(E value){
			this.leftRef=null;
			this.rightRef=null;
			this.value=value;			
		}
		
	}
//The left subtree of a node contains only nodes with keys less than the node’s key.
	/*1.The right subtree of a node contains only nodes with keys greater than the node’s key.
	2.The left and right subtree each must also be a binary search tree.
	3.There must be no duplicate nodes.*/

//Insertion Of Key
	/*Insertion of a key
	A new key is always inserted at leaf. We start searching a key from root till we hit a leaf node. 
	Once a leaf node is found, the new node is added as a child of the leaf node.

	         100                               100
	        /   \        Insert 40            /    \
	      20     500    --------->          20     500 
	     /  \                              /  \  
	    10   30                           10   30
	                                              \   

	                                              40*/
	 Node<E> insert(E value,Node<E> node){
		 //Only executes if Root is null
	if(root==null)
			 return root=new Node<E>(value);
	//return Leaf Node
	if(node==null)
		return new Node<E>(value);
	
	if(node.value.doubleValue()>value.doubleValue())
		node.leftRef=insert(value,node.leftRef);
	else
		node.rightRef=insert(value,node.rightRef);
	  return node;	
	}
	
	/* Searching a key:
	 * 
	 To search a given key in Bianry Search Tree, we first compare it with root, if the key is present at root, we return root. 
	 If key is greater than root’s key, we recur for right subtree of root node. Otherwise we recur for left subtree.
	 
	 */
	boolean search(E value,Node<E> root){
		if(root==null)
			return false;
		if(root.value.doubleValue()==value.doubleValue())
		return true;
		if(root.value.doubleValue()>value.doubleValue())
		return	search(value,root.leftRef);
		else{
		return	search(value,root.rightRef);	
		}
		
	}
	
	//Traverse Tree
void 	printAll(Node<E> root){
	if(root==null)
		return;
	System.out.println(root.value);	
	printAll(root.leftRef);
	printAll(root.rightRef);
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst=new BinarySearchTree<>();
		bst.insert(7, bst.root);
		bst.insert(8, bst.root);
		bst.insert(9, bst.root);
		bst.insert(1, bst.root);
		bst.insert(2, bst.root);
		bst.insert(3, bst.root);
		System.out.println("ALL NODES");
		bst.printAll(bst.root);
		System.out.println("-------------------------------------------");
		System.out.println("Search Results:");
		System.out.println("Search 3:" +bst.search(3,bst.root));
		System.out.println("Search 3:" +bst.search(9,bst.root));
		System.out.println("Search 3:" +bst.search(11,bst.root));
	}
	 
}
