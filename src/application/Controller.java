package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import tree.*;

/*********************************************************************
 * Controller Klasse für die GUI
 * 
 * @author Sven Böhrnsen
 *********************************************************************/

public class Controller {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML
	private AnchorPane apDraw;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="taHistory"
	private TextArea taHistory; // Value injected by FXMLLoader

	@FXML // fx:id="bSearch"
	private Button bSearch; // Value injected by FXMLLoader

	@FXML // fx:id="bInsert"
	private Button bInsert; // Value injected by FXMLLoader

	@FXML // fx:id="bDelete"
	private Button bDelete; // Value injected by FXMLLoader

	@FXML // fx:id="tfSearch"
	private TextField tfSearch; // Value injected by FXMLLoader

	@FXML // fx:id="tfInsert"
	private TextField tfInsert; // Value injected by FXMLLoader

	@FXML // fx:id="tfDelete"
	private TextField tfDelete; // Value injected by FXMLLoader

	@FXML // fx:id="bPreorder"
	private Button bPreorder; // Value injected by FXMLLoader

	@FXML // fx:id="bInorder"
	private Button bInorder; // Value injected by FXMLLoader

	@FXML // fx:id="bPostorder"
	private Button bPostorder; // Value injected by FXMLLoader

	@FXML // fx:id="bLevelorder"
	private Button bLevelorder; // Value injected by FXMLLoader

	@FXML // fx:id="bTreeHigh"
	private Button bTreeHigh; // Value injected by FXMLLoader

	@FXML // fx:id="bClearTree"
	private Button bClearTree; // Value injected by FXMLLoader

	@FXML // fx:id="tOutput"
	private Text tOutput; // Value injected by FXMLLoader

	// ein neu erstellten Baum beim Start
	public BinaryTree bsTree = new BinaryTree();

	int treeSize;
	int hoehe;

	Integer value;

	@FXML
	void clearTree(ActionEvent event) {
		bsTree.setRoot();
		apDraw.getChildren().clear();
		hoehe = 0;
		treeSize = 0;
		bsTree.setRoot();
		taHistory.appendText("- Baum geleert!\n");
	}

	@FXML
	void closeOnAction(ActionEvent event) {
		System.exit(0);
	}

	/**
	 * Entfernen in der GUI
	 * 
	 * @param event
	 */
	@FXML
	void deleteNote(ActionEvent event) {
		value = Integer.parseInt(tfDelete.getText());
		// bsTree.removeNode(value);
		if (bsTree.removeNode(value)) {
			taHistory.appendText("- Wert " + tfDelete.getText() + " entfernt.\n");
			tfDelete.clear();
			treeSize--;

		} else {
			taHistory.appendText("- Wert " + tfDelete.getText() + " nicht Vorhanden.\n");
		}

	}

	@FXML
	void highTree(ActionEvent event) {
		taHistory.appendText("- Die Höhe des Baumes: " + treeSize + "\n");
	}

	@FXML
	void inorder(ActionEvent event) {
		bsTree.inorderTraverse(bsTree.getRoot());
		System.out.println("");
		taHistory.appendText("- Ausgabe der Inorder\n");
		tOutput.setText("Inorder: ");
	}

	/**
	 * Einfügen in der GUI
	 * 
	 * @param event
	 */
	@FXML
	void insertNote(ActionEvent event) {
		value = Integer.parseInt(tfInsert.getText());

		if (value < 1 || value > 999) {
			System.out.println("Der Wert kann nur zwischen 1 und 999 betragen!");
		} else if (bsTree.getRoot() == null) {
			bsTree.addNode(value);
			taHistory.appendText("- Wert " + tfInsert.getText() + " hinzugefügt.\n");
			tfInsert.clear();
			// Line line1 = new Line(200, 20, 300, 20);
			// apDraw.getChildren().add(line1);
			treeSize++;

			// Test Knoten
			final Circle circle = new Circle(24);
			circle.setStroke(Color.BLACK);
			circle.setStrokeWidth(2);
			circle.setStrokeType(StrokeType.INSIDE);
			circle.setFill(Color.CADETBLUE);
			final Text text = new Text(value.toString());
			text.setFont(Font.font(null, FontWeight.BOLD, 15));
			text.setFill(Color.BLACK);
			text.setX(circle.getCenterX());
			text.setY(circle.getCenterX());
			final StackPane stack = new StackPane();
			stack.getChildren().addAll(circle, text);
			stack.setLayoutX(apDraw.getPrefWidth() / 2);
			stack.setLayoutY(hoehe);
			apDraw.getChildren().addAll(stack);
			apDraw.getMaxHeight();
		} else if (treeSize != 6) {
			bsTree.addNode(value);
			taHistory.appendText("- Wert " + tfInsert.getText() + " hinzugefügt.\n");
			tfInsert.clear();
			// Line line1 = new Line(200, 20, 300, 20);
			// apDraw.getChildren().add(line1);
			treeSize++;

			final Circle circle = new Circle(24);
			circle.setStroke(Color.BLACK);
			circle.setStrokeWidth(2);
			circle.setStrokeType(StrokeType.INSIDE);
			circle.setFill(Color.CADETBLUE);
			final Text text = new Text(value.toString());
			text.setFont(Font.font(null, FontWeight.BOLD, 15));
			text.setFill(Color.BLACK);
			text.setX(circle.getCenterX());
			text.setY(circle.getCenterX());
			final StackPane stack = new StackPane();
			stack.getChildren().addAll(circle, text);
			stack.setLayoutX(apDraw.getPrefWidth() / 2);
			stack.setLayoutY(hoehe = hoehe + 100);
			apDraw.getChildren().addAll(stack);
			apDraw.getMaxHeight();
		} else {
			System.out.println("Maxmimale Knotenanzahl erreicht!");
		}

	}

	@FXML
	void levelorder(ActionEvent event) {
		taHistory.appendText("- Ausgabe der Levelorder\n");
		tOutput.setText("Levelorder: ");

	}

	@FXML
	void postorder(ActionEvent event) {
		bsTree.postorderTraverse(bsTree.getRoot());
		System.out.println("");
		taHistory.appendText("- Ausgabe der Postorder\n");
		tOutput.setText("Postorder: ");
	}

	@FXML
	void preorder(ActionEvent event) {
		bsTree.preorderTraverse(bsTree.getRoot());
		System.out.println("");
		taHistory.appendText("- Ausgabe der Preorder\n");
		tOutput.setText("Preorder: ");

	}

	/**
	 * Suchen in der GUI
	 * 
	 * @param event
	 */
	@FXML
	void searchNote(ActionEvent event) {
		int value = Integer.parseInt(tfSearch.getText());
		if (bsTree.searchNote(value) != null) {
			taHistory.appendText("- Wert " + tfSearch.getText() + " gefunden.\n");
			tfSearch.clear();
		} else {
			taHistory.appendText("- Wert " + tfSearch.getText() + " nicht im Baum enthalten.\n");
		}

	}

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		treeSize = 0;
	}

}