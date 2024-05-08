package hw4;

import java.awt.Rectangle;
import api.AbstractElement;

// Special documentation requirement: (see page 11 of documentation)
// you must add a comment to the top of the SimpleElement class
// with a couple of sentences explaining how you decided to organize
// the class hierarchy for the elements.

/**
 * This class is made to be a superclass in the package hierarchy
 * It provides basic functionality and can be extended further for specialized elements
 * 
 */

/**
 * Minimal concrete extension of AbstractElement. The <code>update</code> method
 * in this implementation just increments the frame count.
 * 
 * @author Anthony Phan
 */

public class SimpleElement extends AbstractElement {

	private int width;
	private int height;
	private int updateCount;
	private double xCoord;
	private double yCoord;
	private boolean markForDeletion;

	/**
	 * Constructs a new SimpleElement.
	 * 
	 * @param x x-coordinate of upper left corner
	 * @param y y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	
	public SimpleElement(double x, double y, int width, int height) {
		super();
		this.xCoord = x;
		this.yCoord = y;
		this.width = width;
		this.height = height;

	}

	/**
	 * Determines whether bounding rectangle overlaps the given
	 * element's rectangle
	 * 
	 * @param other given element
	 * @return true if this element overlaps the given element
	 */
	
	public boolean collides(AbstractElement other) {
		if (other == null) {
			return false;
		}
		Rectangle rect1 = new Rectangle((int) this.xCoord, (int) this.yCoord, this.width, this.height);
		Rectangle rect2 = new Rectangle((int) other.getXReal(), (int) other.getYReal(), other.getWidth(),
				other.getHeight());
		return rect1.intersects(rect2);

	}

	/**
	 * the number of times that update() has been invoked for this object.
	 * 
	 * @return number of frames
	 */
	
	public int getFrameCount() {
		return this.updateCount;
	}

	/**
	 * 
	 * @return the width of this object's bounding rectangle.
	 */
	
	public int getWidth() {
		return this.width;
	}

	/**
	 * 
	 * @return the height of this object's bounding rectangle.
	 */
	
	public int getHeight() {
		return this.height;
	}

	/**
	 * 
	 * @return the bounding rectangle for this object as an instance of
	 *         java.awt.Rectangle.
	 */
	
	public Rectangle getRect() {
		return new Rectangle((int) this.xCoord, (int) this.yCoord, this.width, this.height);
	}

	/**
	 * 
	 * @return Returns the horizontal coordinate of the upper-left corner, rounded to the nearest integer.
	 */
	
	public int getXInt() {
		return (int) Math.round(this.xCoord);
	}

	/**
	 * 
	 * @param x
	 */
	
	private void setXInt(int x) {
		this.xCoord = x;
	}

	/**  
	 * @return Returns the x-coordinate's exact value as a double.
	 */
	
	public double getXReal() {
		return xCoord;
	}

	protected void setXReal(double x) {
		this.xCoord = x;
	}

	/**
	 * @return Returns the vertical coordinate of the upper-left corner, rounded to the nearest integer.
	 */
	
	public int getYInt() {
		return (int) Math.round(this.yCoord);
	}

	private void setYInt(int y) {
		this.yCoord = y;
	}

	/**
	 * 
	 * @return Returns the y-coordinate's exact value as a double.
	 */
	
	public double getYReal() {
		return yCoord;
	}

	protected void setYReal(double y) {
		this.yCoord = y;
	}

	/**
	 * 
	 * @return Returns true if this element has been marked for deletion.
	 */
	
	public boolean isMarked() {
		return markForDeletion;
	}

	/**
	 * marks this element for deletion
	 */
	
	public void markForDeletion() {
		this.markForDeletion = true;
	}

	/**
	 * Sets the position of this element
	 * 
	 * @param newX
	 * @param newY
	 */
	
	public void setPosition(double newX, double newY) {
		this.xCoord = newX;
		this.yCoord = newY;
	}

	/**
	 * Updates this object's attributes
	 */
	
	public void update() {
		this.updateCount++;
	}
}
