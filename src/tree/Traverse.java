package tree;

import java.util.*;

/*********************************************************************
 * Klasse für die Traversierungs Operationen an einem Suchbaum
 * 
 * Basierned auf den Code von Derek Banas ({@link http://www.newthinktank.com})
 * 
 * @author Sven Böhrnsen
 *********************************************************************/

public class Traverse {
	/*********************************************************************
	 * Die Traverseirung Inorder. Verlauf: Links, Wurzel, Rechts
	 * 
	 * @param focusNode
	 * @return
	 *********************************************************************/

	private LinkedList<Node> output = new LinkedList<Node>();
	Iterator<Node> itr = output.iterator();

	public void inorderTraverse(Node focusNode) {
		output.clear();
		if (focusNode != null) {
			// Traversiere durch die linken Knoten
			inorderTraverse(focusNode.leftChild);
			// Nimm die Wurzel
			output.add(focusNode);
			System.out.print(focusNode);
			// Traversiere durch die rechten Knoten
			inorderTraverse(focusNode.rightChild);
		}
	}

	/*********************************************************************
	 * Die Traversierung Preorder Verlauf: Wurzel, Links, Rechts
	 * 
	 * @param focusNode
	 * @return
	 *********************************************************************/
	public void preorderTraverse(Node focusNode) {
		if (focusNode != null) {
			// Traverse the left node
			System.out.print(focusNode);
			preorderTraverse(focusNode.leftChild);
			preorderTraverse(focusNode.rightChild);
		}
	}

	/*********************************************************************
	 * Die Traversierung Postorder Verlauf: Links, Rechts, Wurzel
	 * 
	 * @param focusNode
	 * @return
	 *********************************************************************/
	public void postorderTraverse(Node focusNode) {
		if (focusNode != null) {
			// Traverse the left node

			postorderTraverse(focusNode.leftChild);
			postorderTraverse(focusNode.rightChild);
			System.out.print(focusNode);
		}
	}

}
