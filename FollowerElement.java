package hw4;

import api.AbstractElement;

/**
 * A follower element is one that is associated with another "base" element such
 * as a PlatformElement or LiftElement. Specifically, the follower element's
 * movement is determined by the movement of the base element, when the base
 * moves up 10 pixels, the follower moves up 10 pixels. However, the follower
 * may not always be at a fixed location relative to the base. When the
 * horizontal velocity of the follower is set to a non-zero value, the follower
 * will oscillate between the left and right edges of the PlatformElement or
 * LiftElement it is associated with.
 * 
 * @author Anthony Phan
 */

public class FollowerElement extends AttachedElement {
	private double minX;
	private double maxX;

	/**
	 * Constructs a new FollowerElement. Before being added to a "base" element such
	 * as a PlatformElement or LiftElement, the x and y coordinates are zero. When a
	 * base element is set, the initial x-coordinate becomes the base's
	 * x-coordinate, plus the given offset, and the y-coordinate becomes the base's
	 * y-coordinate, minus this element's height.
	 * 
	 * @param width         element's width
	 * @param height        element's height
	 * @param initialOffset when added to a base, this amount will be added to the
	 *                      bases's x-coordinate to calculate this element's initial
	 *                      x-coordinate
	 */
	public FollowerElement(int width, int height, int initialOffset) {
		super(width, height, initialOffset, 0);

	}

	@Override
	public void update() {
		super.update();

		setBounds(getBase().getXReal(), getBase().getXReal() + getBase().getWidth());

		double newX = getXReal();
		if (newX + getWidth() >= maxX) {
			setPosition(maxX - getWidth(), getYReal());
			setVelocity(-1 * getDeltaX(), getDeltaY());
		} else if (newX <= minX) {
			setPosition(minX, getYReal());
			setVelocity(-1 * getDeltaX(), getDeltaY());
		}

	}

	/**
	 * Sets the right and left boundaries 
	 * 
	 * @param min
	 * @param max
	 */
	
	public void setBounds(double min, double max) {
		minX = min;
		maxX = max;
	}

	/**
	 * Returns the left boundary
	 * 
	 * @return
	 */
	
	public double getMin() {
		return minX;
	}

	/**
	 * Returns the right boundary 
	 * 
	 * @return
	 */
	
	public double getMax() {
		return maxX;
	}
}
