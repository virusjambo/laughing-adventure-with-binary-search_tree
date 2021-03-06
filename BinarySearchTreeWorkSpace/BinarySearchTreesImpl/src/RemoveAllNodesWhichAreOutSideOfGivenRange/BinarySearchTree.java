package RemoveAllNodesWhichAreOutSideOfGivenRange;





public class BinarySearchTree<E extends Number> {
	
	Node<E> root;

	// Inner class to hold value of Node in a tree
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

	Node<E> insert(E value, Node<E> node) {
		// Only executes if Root is null
		if (root == null)
			return root = new Node<E>(value);
		// return Leaf Node
		if (node == null)
			return new Node<E>(value);

		if (node.value.doubleValue() > value.doubleValue())
			node.leftRef = insert(value, node.leftRef);
		else
			node.rightRef = insert(value, node.rightRef);
		return node;
	}
	//Traverse Tree
void 	printAll(Node<E> root){
	if(root==null)
		return;
	System.out.println(root.value);	
	printAll(root.leftRef);
	printAll(root.rightRef);
	}
//Logic is here...
//Here I have not deleted any nodes just I am playing with references.
Node<E> deleteAllNumbers(Node<E> root,E min,E max){
	if(root==null)
		return null;
	root.leftRef=deleteAllNumbers(root.leftRef,min,max);
	root.rightRef=deleteAllNumbers(root.rightRef,min,max);
	//If Node values is less than MIN then its out of our range/
	//We will take right of node and return
	if(root.value.doubleValue()<min.doubleValue()){
		Node<E> temp=root;		
		return temp.rightRef;
	}
	//If Node values is greater than MAX then its out of our range/
		//We will take left of node and return
	if(root.value.doubleValue()>max.doubleValue()){
		Node<E> temp=root;
		return temp.leftRef;
	}
	//else return node
	return root;
		
	
	
	
}

public static void main(String[] args) {
	BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	bst.insert(50, bst.root);
	bst.insert(30, bst.root);
	bst.insert(20, bst.root);
	bst.insert(40, bst.root);
	bst.insert(70, bst.root);
	bst.insert(60, bst.root);
	bst.insert(80, bst.root);
	System.out.println("ALL NODES");
	bst.printAll(bst.root);
	System.out.println("----------------RESULT--------------------");
	bst.deleteAllNumbers(bst.root,20,50);
	bst.printAll(bst.root);
}

}
