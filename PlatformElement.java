package hw4;

import java.util.ArrayList;
import api.AbstractElement;

/**
 * A PlatformElement is an element with two distinctive behaviors. First, it can
 * be set up to move horizontally within a fixed set of boundaries. On reaching
 * a boundary, the x-component of its velocity is reversed. Second, it maintains
 * a list of <em>associated</em> elements whose basic motion all occurs relative
 * to the PlatformElement.
 * 
 * @author Anthony Phan
 */

public class PlatformElement extends MovingElement {

	private double minX;
	private double maxX;
	private ArrayList<AbstractElement> associatedElements;

	/**
	 * Constructs a new PlatformElement. Initially the left and right boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	public PlatformElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		minX = Double.NEGATIVE_INFINITY;
		maxX = Double.POSITIVE_INFINITY;
		associatedElements = new ArrayList<>();

	}

	/**
	 * Updates this object's state for a new frame, and additionally calls update on
	 * all its associated elements.
	 * 
	 */

	public void update() {
		super.update();

		for (AbstractElement element : associatedElements) {
			element.update();
		}

		double newX = getXReal();
		if (newX + getWidth() >= maxX) {
			setPosition(maxX - getWidth(), getYReal());
			setVelocity(-1 * getDeltaX(), getDeltaY());
			for (AbstractElement element : associatedElements) {
				element.setPosition(element.getXReal() - (newX + getWidth() - maxX), element.getYReal());
			}

		} else if (newX <= minX) {
			setPosition(minX, getYReal());
			setVelocity(-1 * getDeltaX(), getDeltaY());
			for (AbstractElement element : associatedElements) {
				element.setPosition(element.getXReal() + (minX - newX), element.getYReal());
			}
		}

	}

	public void setBounds(double min, double max) {
		minX = min;
		maxX = max;
	}

	/**
	 * Deletes all associated elements that have been marked.
	 */
	
	public void deleteMarkedAssociated() {
		associatedElements.removeIf(AbstractElement::isMarked);

	}

	/**
	 * Returns the right boundary for this Platform's movement.
	 * 
	 * @return
	 */
	
	public double getMax() {
		return maxX;
	}

	/**
	 * Returns the left boundary for this Platform's movement.
	 * 
	 * @return
	 */
	
	public double getMin() {
		return minX;
	}

	/**
	 * Adds an associated element to this LiftElement, and sets this object to be
	 * the AttachedElement's base.
	 * 
	 * @param attached
	 */
	
	public void addAssociated(AttachedElement attached) {
		attached.setBase(this);
		getAssociated().add(attached);
	}

	/**
	 * Adds an associated element to this LiftElement, and sets this object to be
	 * the FollowerElement's base.
	 * 
	 * @param follower
	 */
	
	public void addAssociated(FollowerElement follower) {
		follower.setBase(this);
		getAssociated().add(follower);
	}

	/**
	 * Returns a list of all this Elevator's associated elements.
	 * 
	 * @return
	 */
	
	public ArrayList<AbstractElement> getAssociated() {
		return associatedElements;
	}

}
