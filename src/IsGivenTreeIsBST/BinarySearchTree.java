package IsGivenTreeIsBST;

public class BinarySearchTree<E extends Number> {

	// what will be good solution K just a moment write a solution which comes
	// first on your mind.
	// We will go with recursion by comparing root with child.
	// lets write it and see how it behaves?



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
	// Method 1:But this solution will  fail for some condition ......Think..Find it out 
	//on your own.So I will go with second solution which is effective .
	boolean isBinaryTreeMethod1(Node<E> root) {
		if (root == null)
			return true;
		if ((root.leftRef != null && !(root.leftRef.value.doubleValue() < root.value
				.doubleValue()))) {
			return false;
		}
		if (root.rightRef != null
				&& !(root.rightRef.value.doubleValue() > root.value
						.doubleValue())) {
			return false;
		}

		return isBinaryTreeMethod1(root.leftRef)
				&& isBinaryTreeMethod1(root.rightRef);

	}
	
	//Method2: traverses down the tree keeping track of the narrowing min 
	//and max allowed values as it goes, looking at each node only once. 
	
	//Lets write it down
	boolean isBSTMethod2(Node<E> root,int min,int max){
		if(root==null)
			return true;
		if(root.value.intValue()<min || root.value.intValue()>max){
			return false;
		}
		return isBSTMethod2(root.leftRef,min,root.value.intValue()-1) && isBSTMethod2(root.rightRef,root.value.intValue()+1,max);
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

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(7, bst.root);
		bst.insert(8, bst.root);
		bst.insert(9, bst.root);
		bst.insert(1, bst.root);
		bst.insert(2, bst.root);
		bst.insert(3, bst.root);
		// System.out.println("ALL NODES");
		// bst.printAll(bst.root);
		System.out.println("-------------------------------------------");
		System.out.println(bst.isBSTMethod2(bst.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}
}
