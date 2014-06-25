package CheckIfAnyTripletCanAddToZeroInBST;

public class BinarySeachTree<E extends Number> {
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

	// Traverse Tree
	void printAll(Node<E> root) {
		if (root == null)
			return;
		System.out.println(root.value);
		printAll(root.leftRef);
		printAll(root.rightRef);
	}

	Node<E> prev = null;
	Node<E> dllRoot = null;
//Here We are adding each node to prev so At the end prev Become tail of DLL .
	void convertToDLL(Node<E> root) {
		if (root == null)
			return;
		convertToDLL(root.leftRef);
		if (prev == null) {
			prev = root;
			dllRoot = prev;
		} else {

			prev.rightRef = root;
			root.leftRef = prev;
			prev = root;
		}
		convertToDLL(root.rightRef);

	}

	void printDLL(Node<E> head) {
		while (head != null) {
			System.out.println(head.value);
			head = head.rightRef;
		}

	}
	
boolean	checkForTripletInDLL(double sum){
	Node<E> head=dllRoot;
	Node<E> tail=prev;
	while(head!=tail){
		double cur=head.value.doubleValue()+tail.value.doubleValue();
		if(sum==cur){
			return true;
		}else if(sum>cur){
			head=head.rightRef;
		}else{
			tail=tail.leftRef;
		}
		
	}
	return false;
		
	}
	
boolean  isContainTripletWhichAddsToZero(){
	Node<E> head=dllRoot;
	Node<E> tail=prev;
	while(head!=tail){
		if(checkForTripletInDLL(- (head.value.doubleValue()))){
			return true;
		}else
		head=head.rightRef;
		
	}
	return false;
	
}
	

	public static void main(String[] args) {
		BinarySeachTree<Integer> bst = new BinarySeachTree<>();
		bst.insert(6, bst.root);
		bst.insert(-13, bst.root);
		bst.insert(14, bst.root);
		bst.insert(-8, bst.root);
		bst.insert(15, bst.root);
		bst.insert(13, bst.root);
		bst.insert(7, bst.root);
		System.out.println("ALL NODES");
		bst.printAll(bst.root);
		System.out.println("-------------------------------------------");
		;
		bst.convertToDLL(bst.root);
		bst.printDLL(bst.dllRoot);
		System.out.println(bst.isContainTripletWhichAddsToZero());;
	}

}
