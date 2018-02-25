package tree;

/*********************************************************************
 * Die Klasse für die Umsetzung von einem binären Suchbaumes. Umgesetzte
 * Operationen sind Suchen, Einfügen und Entfernen. Traversierungen: inorder,
 * Preorder und Postorder.
 * 
 * Basierned auf den Code von Derek Banas ({@link http://www.newthinktank.com})
 * 
 * @author Sven Böhrnsen
 *********************************************************************/
public class BinaryTree extends Traverse {

	Node root;
	

	/**
	 * getter Methode für den Aufruf der Wurzel
	 * 
	 * @return
	 */
	public Node getRoot() {
		return root;
	}

	/*********************************************************************
	 * Die Grund-Operation "Suchen" von einem Wert in einem Suchbaum.
	 * 
	 * @param key
	 * @return
	 *********************************************************************/
	public Node searchNote(Integer key) {
		Node focusNode = root;

		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}
			if (focusNode == null) {
				System.out.println(key + " konnte nicht gefunden werden.");
				return null; // Ausgabe in der Konsole bzw. History
			}
		}
		System.out.println("Gefunden!: " + focusNode.key);
		return focusNode;
	}

	/*********************************************************************
	 * Die Operation "Einfügen" eines Knoten in einen Suchbaum.
	 * 
	 * @param key
	 * @return
	 *********************************************************************/
	public void addNode(Integer key) {
		Node newNode = new Node(key);

		// Wenn noch kein Wurzelknoten existiert
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;

			while (true) {
				parent = focusNode;

				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;

					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;

					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
		System.out.println(key + " In den Baum hinzugefügt!");
	}

	/*********************************************************************
	 * Die Operation "Entfernen" eines Knoten in einem Suchbaum
	 * 
	 * @param key
	 * @return
	 *********************************************************************/
	public boolean removeNode(Integer key) {
		Node focusNode = root;
		Node parent = root;

		boolean isLeftChild = true;

		// Auffinden des Schlüsselwerts
		while (focusNode.key != key) {
			parent = focusNode;

			if (key < focusNode.key) {
				isLeftChild = true;
				focusNode = focusNode.leftChild;
			} else {
				isLeftChild = false;
				focusNode = focusNode.rightChild;
			}

			// Wenn der Schlüsselwert nicht vorhanden ist
			if (focusNode == null)
				return false;
		}

		// Knoten hat keine Nachfolger
		if (focusNode.leftChild == null && focusNode.rightChild == null) {
			// Ist es die Wurzel
			if (focusNode == root)
				root = null;
			else
			// Es ist ein linker Kindsknoten
			if (isLeftChild)
				parent.leftChild = null;
			// Es ist ein rechter Kindsknoten
			else
				parent.rightChild = null;
		}

		// wenn kein rechter Nachfolger vorhanden sind
		else if (focusNode.rightChild == null) {
			if (focusNode == root)
				root = focusNode.leftChild;

			else if (isLeftChild)
				parent.leftChild = focusNode.leftChild;

			else
				parent.rightChild = focusNode.leftChild;
		}

		// wenn kein linker Nachfolger vorhanden sind
		else if (focusNode.leftChild == null) {
			if (focusNode == root)
				root = focusNode.rightChild;
			// Wenn der betrachtete Knoten ein linker Nachfolger ist
			else if (isLeftChild)
				parent.leftChild = focusNode.rightChild;
			else
				parent.rightChild = focusNode.rightChild;
		}

		else {
			Node replacement = getReplacementNode(focusNode);
			if (focusNode == root)
				root = replacement;

			else if (isLeftChild)
				parent.leftChild = replacement;

			else
				parent.rightChild = replacement;
			replacement.leftChild = focusNode.leftChild;
		}
		System.out.println(key + " wurde entfernt");
		return true;
	}

	/*********************************************************************
	 * Diese Funktion behandelt den Fall, wenn zwei Kindsknoten vorhanden sind
	 * es sucht in den Teilbäumen den Ersatz für den zu entfernenden Knoten
	 * 
	 * @param replacedNode
	 * @return
	 *********************************************************************/
	public Node getReplacementNode(Node replacedNode) {
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;

		Node focusNode = replacedNode.rightChild;

		// Solange keine weiteren linke Kindsknoten existieren
		while (focusNode != null) {
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.leftChild;
		}

		// Wenn der ausgetauschte Knoten kein rechter KIndsknoten ist
		// schiebe den Ersatz an die Stelle des linkes Nachfolger vom
		// Vaterknoten und schiebe den vom ersetzen rechten
		// Nachfolgerknoten an dessen Ersatz
		if (replacement != replacedNode.rightChild) {
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}
		return replacement;
	}

	/**
	 * Methode um den größten Knoten in einem Baum zu bekommen
	 * 
	 * @param focusNode
	 */
	public void getMax(Node focusNode) {
		if (focusNode.rightChild != null) {
			getMax(focusNode.rightChild);
		} else {
			System.out.println("Der größte Wert im Baum ist: " + focusNode);

		}

	}
	
	/**
	 * Methode um den kleinsten Knoten in einem Baum zu bekommen
	 * 
	 * @param focusNode
	 */
	public void getMin(Node focusNode) {
		if (focusNode.leftChild != null) {
			getMin(focusNode.leftChild);
		} else {
			System.out.println("Der kleinste Wert im Baum ist: " + focusNode);

		}

	}

	/**
	 * Main Klasse zum testen der Methoden in der Konsole
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree theTree = new BinaryTree();

		theTree.addNode(18);
		theTree.addNode(11);
		theTree.addNode(31);
		theTree.addNode(9);
		theTree.addNode(14);
		theTree.addNode(27);
		theTree.addNode(38);
		theTree.addNode(13);
		theTree.addNode(15);
		theTree.addNode(26);
		theTree.addNode(28);

		System.out.println("Inorder:");
		theTree.inorderTraverse(theTree.root);
		System.out.println();
		System.out.println("Preorder:");
		theTree.preorderTraverse(theTree.root);
		System.out.println("");
		System.out.println("Postorder:");
		theTree.postorderTraverse(theTree.root);

		System.out.println("");
		System.out.println("Test: Max und Min");
		theTree.getMax(theTree.root);
		theTree.getMin(theTree.root);
	}

	/**
	 * @param object
	 * @return
	 */
	public Object setRoot() {
		return null;
	}
}
