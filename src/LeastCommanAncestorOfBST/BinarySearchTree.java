package LeastCommanAncestorOfBST;

public class BinarySearchTree<E extends Number> {

	// What is LCA ?
	// we start here
	/*
	 * 50 
	 / \ 
	30 70
        / \ / \ 
      20 40 60 80
	 */
	 

	// if given node are 20 and 80 LCA is 50
	// (20,40)=LCA 30
	// K lets start coding
	// Logic?
	// Just think if nodes given are 30 and 70 then nodes lies in roots left and
	// right so LCA is 50 so its ROOT
	// if 20 and 40 both lies in left leg.
	// if 60 and 80 both lies in right leg.
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

	// Recursive way to solve this
	Node<E> findLCARecursive(Node<E> root, E key, E key1) {
		// if given keys are not present
		if (root == null)
			return null;
		// if both keys lies left
		if (root.value.doubleValue() > key.doubleValue()
				&& root.value.doubleValue() > key1.doubleValue())
			return findLCARecursive(root.leftRef, key, key1);
		// if both keys lies right
		if (root.value.doubleValue() < key.doubleValue()
				&& root.value.doubleValue() < key1.doubleValue())
			return findLCARecursive(root.rightRef, key, key1);
		// else we got what we want
		return root;

	}
	//Iterative way to find LCA
	Node<E> findLCAIterativeMethod2(Node<E> root, E key, E key1) {
		
		while(root!=null){
			if (root.value.doubleValue() > key.doubleValue()
					&& root.value.doubleValue() > key1.doubleValue())
				 root=root.leftRef;
			// if both keys lies right
			else if (root.value.doubleValue() < key.doubleValue()
					&& root.value.doubleValue() < key1.doubleValue())
				root=root.rightRef;
			else
				//else we are done..say bye bye
				break;
			
			
		}
		return root;

	}
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(7, bst.root);
		bst.insert(8, bst.root);
		bst.insert(9, bst.root);
		bst.insert(1, bst.root);
		bst.insert(2, bst.root);
		bst.insert(3, bst.root);

		System.out.println("-------------------------------------------");
		System.out.println(bst.findLCARecursive(bst.root, 8, 9).value);
		System.out.println(bst.findLCARecursive(bst.root, 8, 1).value);
		System.out.println(bst.findLCAIterativeMethod2(bst.root, 2, 3).value);
		System.out.println(bst.findLCARecursive(bst.root, 10, 11));
	}
}
