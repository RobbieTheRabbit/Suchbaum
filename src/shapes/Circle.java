package shapes;

import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/*********************************************************************
 * Klasse um einen neuen Knoten in Kreisform darzustellen. (TESTPHASE)
 * 
 * @author Sven Böhrnsen
 *********************************************************************/
public class Circle {

	final Font font = Font.font("Cooper Black", FontWeight.BOLD, 16);
	final FontMetrics fm = Toolkit.getToolkit().getFontLoader().getFontMetrics(font);

	Integer searchKey;
	private Color backgroundColor;
	private Color borderColor;
	private Color fontColor;

	public Circle(Integer searchKey) {
		this.searchKey = searchKey;
		this.borderColor = Color.BLACK;
		this.backgroundColor = Color.CADETBLUE;
		this.fontColor = Color.WHITE;

	}

	public void drawNode(GraphicsContext gc) {
		// (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gc.setLineWidth(3); // Sets the width of the lines

		// Create a circle
		gc.setFill(backgroundColor);

		// Outline the circle border
		gc.setStroke(borderColor);

		// Draw the id number inside the circle
		gc.setFont(font);
		gc.setFill(getFontColor());
	}

	private String getKey() {
		return Integer.toString(getSearchKey());
	}
	
	/**
	 * @return the searchKey
	 */
	public Integer getSearchKey() {
		return searchKey;
	}

	/**
	 * @param searchKey
	 */
	public void setSearchKey(Integer searchKey) {
		this.searchKey = searchKey;
	}

	/**
	 * @return the backgroundColor
	 */
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * @param backgroundColor
	 */
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	/**
	 * @return the borderColor
	 */
	public Color getBorderColor() {
		return borderColor;
	}

	/**
	 * @param borderColor
	 */
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	/**
	 * @return the fontColor
	 */
	public Color getFontColor() {
		return fontColor;
	}

	/**
	 * @param fontColor
	 */
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

}
