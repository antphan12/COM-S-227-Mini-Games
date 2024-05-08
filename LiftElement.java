package hw4;

import java.util.ArrayList;

import api.AbstractElement;

/**
 * An element with two distinctive behaviors. First, it can be set up to move
 * vertically within a fixed set of boundaries. On reaching a boundary, the
 * y-component of its velocity is reversed. Second, it maintains a list of
 * <em>associated</em> elements whose basic motion all occurs relative to the
 * LiftElement.
 * 
 * @author Anthony Phan
 */

public class LiftElement extends FlyingElement {
	private double minY;
	private double maxY;
	private ArrayList<AbstractElement> associatedElements;

	/**
	 * 
	 * @param x x-coordinate of initial position of upper left corner
	 * @param y y-coordinate of initial position of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	
	public LiftElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		minY = Double.NEGATIVE_INFINITY;
		maxY = Double.POSITIVE_INFINITY;
		associatedElements = new ArrayList<>();
	}


	@Override
	public void update() {
		super.update();

		for (AbstractElement element : associatedElements) {
			element.update();
		}

		double newY = getYReal();
		if (newY >= maxY) {
			setPosition(getXReal(), maxY);
			setVelocity(getDeltaX(), -getDeltaY());
			for (AbstractElement element : associatedElements) {
				element.setPosition(element.getXReal(), element.getYReal() - (newY - maxY));
			}

		} else if (newY <= minY) {
			setPosition(getXReal(), minY);
			setVelocity(getDeltaX(), -getDeltaY());
			for (AbstractElement element : associatedElements) {
				element.setPosition(element.getXReal(), element.getYReal() + (minY - newY));
			}

		}

	}

	/**
	 * Adds an associated element to this LiftElement
	 * 
	 * @param attached
	 */
	
	public void addAssociated(AttachedElement attached) {
		attached.setBase(this);
		getAssociated().add(attached);
	}

	/**
	 * Adds an associated element to this LiftElement
	 * 
	 * @param follower
	 */
	
	public void addAssociated(FollowerElement follower) {
		follower.setBase(this);
		getAssociated().add(follower);
	}

	/**
	 * Deletes all associated elements which were marked.
	 */
	
	public void deleteMarkedAssociated() {
		associatedElements.removeIf(AbstractElement::isMarked);

	}

	/**
	 * Deletes all associated elements which were marked.
	 */
	
	public ArrayList<AbstractElement> getAssociated() {
		return associatedElements;
	}

	/**
	 * Sets the upper and lower boundaries for this Lift's movement
	 * 
	 * @param min
	 * @param max
	 */
	
	public void setBounds(double min, double max) {
		minY = min;
		maxY = max;
	}
	
	/**
	 * Returns the upper boundary 
	 * @return
	 */
	
	public double getMin() {
		return minY;
	}

	/**
	 * Returns the lower boundary
	 * @return
	 */
	
	public double getMax() {
		return maxY;
	}

}