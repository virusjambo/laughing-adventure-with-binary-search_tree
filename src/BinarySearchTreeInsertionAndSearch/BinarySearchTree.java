package BinarySearchTreeInsertionAndSearch;

public class BinarySearchTree<E extends Number> {
	
	
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
	

}
