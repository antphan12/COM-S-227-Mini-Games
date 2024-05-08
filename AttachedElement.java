package hw4;

import api.AbstractElement;

/**
 * An attached element is one that is associated with another "base" element
 * such as a PlatformElement or a LiftElement. Specifically, the attached
 * element's movement is determined by the movement of the base element, the
 * element always remains a fixed distance away.
 * 
 * @author Anthony Phan
 */

public class AttachedElement extends MovingElement {

	private int offset;
	private int hover;
	private MovingElement base;

	/**
	 * Constructs a new AttachedElement. Before being added to an associated "base"
	 * element such as a PlatformElement or LiftElement, the x and y coordinates are
	 * initialized to zero. When the base object is set (not in this constructor),
	 * the x-coordinate will be calculated as the base object's x-coordinate, plus
	 * the given offset, and the y-coordinate will become the base object's
	 * y-coordinate, minus this element's height, minus the hover amount.
	 * 
	 * @param width  element's width
	 * @param height element's height
	 * @param offset when combined with a base object, this value will be added 
	 * to the other object's x-coordinate to determine this element's x-coordinate.
	 * @param hover  When combined with a base object, the y-coordinate of this
	 *  element is calculated by subtracting this element's height and the hover 
	 *  amount from the other object's y-coordinate.
	 */
	
	public AttachedElement(int width, int height, int offset, int hover) {
		super(0, 0, width, height);
		this.offset = offset;
		this.hover = hover;

	}

	/**
	 * 
	 * @param b
	 */
	public void setBase(AbstractElement b) {
		this.base = (MovingElement) b;
		updatePosition();
	}

	protected MovingElement getBase() {
		return base;
	}

	protected int getHover() {
		return hover;
	}
	
	/**
	 * Adjust this element's position so that it stays fixed
	 */
	public void update() {
		this.setVelocity(getDeltaX() + base.getDeltaX(), getDeltaY() + base.getDeltaY());
		super.update();
		this.setVelocity(getDeltaX() - base.getDeltaX(), getDeltaY() - base.getDeltaY());
		}
	

	/**
	 * Updates the position of this element based on where the base element is
	 */
	private void updatePosition() {
		setPosition(base.getXReal() + offset, base.getYReal() - getHeight() - hover);
	}
}
