package tree;

/*********************************************************************
 * Klasse für die Definition von Knoten in einem Baum
 * 
 * Basierned auf den Code von Derek Banas ({@link http://www.newthinktank.com})
 * 
 * @author Sven Böhrnsen
 *********************************************************************/

public class Node {
	int key;

	Node leftChild;
	Node rightChild;

	Node(Integer key) {
		this.key = key;

	}

	public String toString() {
		return key + " ";
	}

}
